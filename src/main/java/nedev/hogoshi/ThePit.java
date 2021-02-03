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
    public static FileUtil items = new FileUtil("items", "plugins/ThePit/menus/");

    public static CommandSender cs = Bukkit.getServer().getConsoleSender();
    public MySQL SQL = new MySQL();

    @SneakyThrows
    @Override
    public void onEnable() {
        setInstance(this);
        File config = new File(getDataFolder() + File.separator + "config.yml");

        if (!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
            if (getConfig().getInt("Language") == 1) {
                cs.sendMessage("§fThe Pit §e> §aСоздание конфигурации...");
            } else {
                cs.sendMessage("§fThe Pit §e> §aCreating config...");
            }
        }

        SetupUtil.setupConfig();

        VersionUtil.versionChecker();
        try {
            SQL.connect();
        } catch (Exception e) {
            cs.sendMessage("§fThe Pit §e> §cDatabase not connected!");
        }

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
