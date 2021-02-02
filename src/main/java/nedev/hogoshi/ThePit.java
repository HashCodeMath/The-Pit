package nedev.hogoshi;

import nedev.hogoshi.commands.*;
import nedev.hogoshi.listener.*;
import nedev.hogoshi.mysql.MySQL;
import nedev.hogoshi.util.*;
import lombok.SneakyThrows;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public final class ThePit extends JavaPlugin {

    public static FileUtil messages = new FileUtil("messages", "plugins/ThePit/");

    CommandSender cs = Bukkit.getServer().getConsoleSender();
    public MySQL SQL = new MySQL();

    @SneakyThrows
    @Override
    public void onEnable() {
        setInstance(this);
        File config = new File(getDataFolder() + File.separator + "config.yml");

        cs.sendMessage("§fThe Pit §e> §aMade in Russia by §e" + Settings.author);
        cs.sendMessage("§fThe Pit §e> §aMade in Russia by §e" + Settings.author);
        cs.sendMessage("§fThe Pit §e> §aMade in Russia by §e" + Settings.author);

        if (!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
            if (getConfig().getInt("Language") == 1) {
                cs.sendMessage("§fThe Pit §e> §aСоздание конфигурации...");
            } else {
                cs.sendMessage("§fThe Pit §e> §aCreating config...");
            }
        }

        try {
            messages.addDefault("Prefix", "&fThe Pit &e> &r");
            messages.addDefault("Sender", "&e<sender>");
            messages.addDefault("Russian.Commands.AddExpCommandUsage", "&cПожалуйста, укажите аргументы! Используйте: &e/addexp <Игрок> <Опыт>");
            messages.addDefault("Russian.Commands.AddedExp", "&aВам было добавлено &e<exp> &aопыта!");
            messages.addDefault("Russian.Commands.SetExpCommandUsage", "&cПожалуйста, укажите аргументы! Используйте: &e/setexp <Игрок> <Опыт>");
            messages.addDefault("Russian.Commands.SetedExp", "&aВам было установлено &e<exp> &aопыта!");
            messages.addDefault("Russian.Commands.AddGoldCommandUsage", "&cПожалуйста, укажите аргументы! Используйте: &e/addgold <Игрок> <Золото>");
            messages.addDefault("Russian.Commands.AddedGold", "&aВам было добавлено &e<gold> &aзолота!");
            messages.addDefault("Russian.Commands.SetGoldCommandUsage", "&cПожалуйста, укажите аргументы! Используйте: &e/setgold <Игрок> <Золото>");
            messages.addDefault("Russian.Commands.SetedGold", "&aВам было установлено &e<gold> &aзолота!");
            messages.addDefault("Russian.Commands.AddLevelCommandUsage", "&cПожалуйста, укажите аргументы! Используйте: &e/addlevel <Игрок> <Уровень>");
            messages.addDefault("Russian.Commands.AddedLevel", "&aВам было добавлено &e<level> &aуровней!");
            messages.addDefault("Russian.Commands.SetLevelCommandUsage", "&cПожалуйста, укажите аргументы! Используйте: &e/setlevel <Игрок> <Уровень>");
            messages.addDefault("Russian.Commands.SetedLevel", "&aВам было установлено &e<level> &aуровней!");
            messages.addDefault("Russian.Commands.SetPrestigeCommandUsage", "&cПожалуйста, укажите аргументы! Используйте: &e/setprestige <Игрок> <Престиж>");
            messages.addDefault("Russian.Commands.SetedPrestige", "&aВам было установлен &e<prestige> &aпрестиж!");
            messages.addDefault("Russian.Commands.UseNumber", "&cПожалуйста, укажите число!");

            messages.addDefault("Russian.Commands.GamemodeUsage", "&cИспользование: &e/gamemode <0/1/2/3>");
            messages.addDefault("English.Commands.Gamemode", "&aВы успешно установили режим &eвыживания&a!");
            messages.addDefault("English.Commands.GamemodeO", "&aВы успешно установили режим &eкреатива&a!");
            messages.addDefault("English.Commands.GamemodeT", "&aВы успешно установили режим &eприключений&a!");
            messages.addDefault("English.Commands.GamemodeS", "&aВы успешно установили режим &eнаблюдателя&a!");

            messages.addDefault("Russian.WelcomeTitleTop", "&aДобро пожаловать!");
            messages.addDefault("Russian.WelcomeTitleBot", "&7Вы успешно зашли на сервер!");
            messages.addDefault("Russian.Kill", "&aУбийство! &7Вы убили игрока &a<target>&7 (&6+7 Золота&7, &b+23 Опыта&7)!");
            messages.addDefault("Russian.DeadTitleTop", "&cВы умерли!");
            messages.addDefault("Russian.DeadTitleBot", "&7Вы были убиты игроком &c<killer>&7!");
            messages.addDefault("Russian.DeadMsg", "&cСмерть! &7Вы были убиты игроком &c<killer>&7!");
            messages.addDefault("Russian.VerifyMessage", "&cПожалуйста, введите код: &e<code>&c!");
            messages.addDefault("Russian.NewVerifyCode", "&cНеверный код! Сгенерирован новый код: &e<code>");
            messages.addDefault("Russian.Verified", "&aВы успешно прошли капчу!");
            messages.addDefault("Russian.NoPerms", "&cУ вас недостаточно прав!");

            messages.addDefault("English.Commands.AddExpCommandUsage", "&cPlease specify arguments! Usage: &e/addexp <Player> <Exp>");
            messages.addDefault("English.Commands.AddedExp", "&aYou have been added &e<exp> &aexperience!");
            messages.addDefault("English.Commands.SetExpCommandUsage", "&cPlease specify arguments! Usage: &e/setexp <Player> <Exp>");
            messages.addDefault("English.Commands.SetedExp", "&aYou have been set &e<exp> &aexperience!");
            messages.addDefault("English.Commands.AddGoldCommandUsage", "&cPlease specify arguments! Usage: &e/addgold <Player> <Gold>");
            messages.addDefault("English.Commands.AddedGold", "&aYou have been added &e<gold> &agold!");
            messages.addDefault("English.Commands.SetGoldCommandUsage", "&cPlease specify arguments! Usage: &e/setgold <Player> <Gold>");
            messages.addDefault("English.Commands.SetedGold", "&aYou have been set &e<gold> &agold!");
            messages.addDefault("English.Commands.AddLevelCommandUsage", "&cPlease specify arguments! Usage: &e/addlevel <Player> <Level>");
            messages.addDefault("English.Commands.AddedLevel", "&aYou have been added &e<level> &alevels!");
            messages.addDefault("English.Commands.SetLevelCommandUsage", "&cPlease specify arguments! Usage: &e/setlevel <Player> <Level>");
            messages.addDefault("English.Commands.SetedLevel", "&aYou have been set &e<level> &alevel!");
            messages.addDefault("English.Commands.SetPrestigeCommandUsage", "&cPlease specify arguments! Usage: &e/setprestige <Player> <Prestige>");
            messages.addDefault("English.Commands.SetedPrestige", "&aYou have been set &e<prestige> &aprestiges!");
            messages.addDefault("English.Commands.AddPrestigeCommandUsage", "&cPlease specify arguments! Usage: &e/addprestige <Player> <Prestige>");
            messages.addDefault("English.Commands.AddedPrestige", "&aYou have been added &e<prestige> &aprestiges!");
            messages.addDefault("English.Commands.UseNumber", "&cPlease, specify number!");

            messages.addDefault("English.Commands.GamemodeUsage", "&cUsage: &e/gamemode <0/1/2/3>");
            messages.addDefault("English.Commands.Gamemode", "&aYou successfully set gamemode to &esurvival&a!");
            messages.addDefault("English.Commands.GamemodeO", "&aYou successfully set gamemode to &ecreative&a!");
            messages.addDefault("English.Commands.GamemodeT", "&aYou successfully set gamemode to &eadventure&a!");
            messages.addDefault("English.Commands.GamemodeS", "&aYou successfully set gamemode to &espectator&a!");

            messages.addDefault("English.WelcomeTitleTop", "&aWelcome!");
            messages.addDefault("English.WelcomeTitleBot", "&7You joined to the server!");
            messages.addDefault("English.Kill", "&aKill! &7You killed &a<target>&7 (&6+7 Gold&7, &b+23 XP&7)!");
            messages.addDefault("English.DeadTitleTop", "&cYou died!");
            messages.addDefault("English.DeadTitleBot", "&7You was killed by &c<killer>&7!");
            messages.addDefault("English.DeadMsg", "&cDie! &7You was killed by &c<killer>&7!");
            messages.addDefault("English.VerifyMessage", "&cPlease, write the code: &e<code>&c!");
            messages.addDefault("English.NewVerifyCode", "&cInvalid code! Generated new code: &e<code>");
            messages.addDefault("English.Verified", "&aYou was verified!");
            messages.addDefault("English.NoPerms", "&cYou don't have permissions!");

            messages.copyDefaults(true);
            messages.save();
            if (getConfig().getInt("Language") == 1) {
                cs.sendMessage("§fThe Pit §e> §aСоздание сообщений...");
            } else {
                cs.sendMessage("§fThe Pit §e> §aCreating messages...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        VersionUtil.versionChecker();

        SQL.connect();

        registerCommands();
        registerEvents();

        if (getConfig().getInt("Language") == 1) {
            cs.sendMessage("§fThe Pit §e> §aПлагин был успешно запущен!");
        } else {
            cs.sendMessage("§fThe Pit §e> §aPlugin was successfully enabled!");
        }
    }

    public void registerCommands() {
        getCommand("setgold").setExecutor(new setgoldcommand());
        getCommand("setlevel").setExecutor(new setlevelcommand());
        getCommand("setexp").setExecutor(new setexpcommand());
        getCommand("addgold").setExecutor(new addgoldcommand());
        getCommand("addlevel").setExecutor(new addlevelcommand());
        getCommand("addexp").setExecutor(new addexpcommand());
        getCommand("addprestige").setExecutor(new addprestigecommand());
        getCommand("setprestige").setExecutor(new setprestigecommand());
        getCommand("r").setExecutor(new reload());
        getCommand("thepit").setExecutor(new thepitcommand());
        getCommand("gamemode").setExecutor(new gamemodecommand());
        getCommand("do").setExecutor(new docommand());
        getCommand("info").setExecutor(new infocommand());
    }

    public void registerEvents() {
        if (getConfig().getInt("Language") == 1) {
            cs.sendMessage("§fThe Pit §e> §aЗагрузка Эвентов...");
        } else if (getConfig().getInt("Language") == 2) {
            cs.sendMessage("§fThe Pit §e> §aLoading Events...");
        }

        getServer().getPluginManager().registerEvents(new APChatEvent(), this);
        getServer().getPluginManager().registerEvents(new EDamageEvent(), this);
        getServer().getPluginManager().registerEvents(new FChangeEvent(), this);
        getServer().getPluginManager().registerEvents(new OtherEvents(), this);
        getServer().getPluginManager().registerEvents(new PDeathEvent(), this);
        getServer().getPluginManager().registerEvents(new PJoinEvent(), this);
        getServer().getPluginManager().registerEvents(new PQuitEvent(), this);
        getServer().getPluginManager().registerEvents(new PInteractEvent(), this);
    }

    public void onDisable() {
        Saver.saveAll();
        if (getConfig().getInt("Language") == 1) {
            cs.sendMessage("§fThe Pit §e> §cПлагин был успешно выключен!");
        } else {
            cs.sendMessage("§fThe Pit §e> §cPlugin was successfully disabled!");
        }
    }

    public static ThePit instance;
    public static ThePit getInstance() {
        return instance;
    }
    public static void setInstance(ThePit instance) {
        ThePit.instance = instance;
    }
    public void fastAsync(Runnable runnable) {
        getServer().getScheduler().runTaskAsynchronously(this, runnable);
    }
}
