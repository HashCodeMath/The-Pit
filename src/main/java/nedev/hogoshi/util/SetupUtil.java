package nedev.hogoshi.util;

import nedev.hogoshi.ThePit;

public class SetupUtil {

    public static void setupConfig() {
        try {
            ThePit.messages.addDefault("Prefix", "&fThe Pit &e> &r");
            ThePit.messages.addDefault("Sender", "&e<sender>");
            ThePit.messages.addDefault("Russian.Commands.AddExpCommandUsage", "&cПожалуйста, укажите аргументы! Используйте: &e/addexp <Игрок> <Опыт>");
            ThePit.messages.addDefault("Russian.Commands.AddedExp", "&aВам было добавлено &e<exp> &aопыта!");
            ThePit.messages.addDefault("Russian.Commands.SetExpCommandUsage", "&cПожалуйста, укажите аргументы! Используйте: &e/setexp <Игрок> <Опыт>");
            ThePit.messages.addDefault("Russian.Commands.SetedExp", "&aВам было установлено &e<exp> &aопыта!");
            ThePit.messages.addDefault("Russian.Commands.AddGoldCommandUsage", "&cПожалуйста, укажите аргументы! Используйте: &e/addgold <Игрок> <Золото>");
            ThePit.messages.addDefault("Russian.Commands.AddedGold", "&aВам было добавлено &e<gold> &aзолота!");
            ThePit.messages.addDefault("Russian.Commands.SetGoldCommandUsage", "&cПожалуйста, укажите аргументы! Используйте: &e/setgold <Игрок> <Золото>");
            ThePit.messages.addDefault("Russian.Commands.SetedGold", "&aВам было установлено &e<gold> &aзолота!");
            ThePit.messages.addDefault("Russian.Commands.AddLevelCommandUsage", "&cПожалуйста, укажите аргументы! Используйте: &e/addlevel <Игрок> <Уровень>");
            ThePit.messages.addDefault("Russian.Commands.AddedLevel", "&aВам было добавлено &e<level> &aуровней!");
            ThePit.messages.addDefault("Russian.Commands.SetLevelCommandUsage", "&cПожалуйста, укажите аргументы! Используйте: &e/setlevel <Игрок> <Уровень>");
            ThePit.messages.addDefault("Russian.Commands.SetedLevel", "&aВам было установлено &e<level> &aуровней!");
            ThePit.messages.addDefault("Russian.Commands.SetPrestigeCommandUsage", "&cПожалуйста, укажите аргументы! Используйте: &e/setprestige <Игрок> <Престиж>");
            ThePit.messages.addDefault("Russian.Commands.SetedPrestige", "&aВам было установлен &e<prestige> &aпрестиж!");
            ThePit.messages.addDefault("Russian.Commands.UseNumber", "&cПожалуйста, укажите число!");

            ThePit.messages.addDefault("Russian.ItemsShop.Buyed", "&aВы успешно купили &e<item>&a!");
            ThePit.messages.addDefault("Russian.ItemsShop.HaventGold", "&cУ вас недостаточно золота!");

            ThePit.messages.addDefault("Russian.Commands.GamemodeUsage", "&cИспользование: &e/gamemode <0/1/2/3>");
            ThePit.messages.addDefault("English.Commands.Gamemode", "&aВы успешно установили режим &eвыживания&a!");
            ThePit.messages.addDefault("English.Commands.GamemodeO", "&aВы успешно установили режим &eкреатива&a!");
            ThePit.messages.addDefault("English.Commands.GamemodeT", "&aВы успешно установили режим &eприключений&a!");
            ThePit.messages.addDefault("English.Commands.GamemodeS", "&aВы успешно установили режим &eнаблюдателя&a!");

            ThePit.messages.addDefault("Russian.WelcomeTitleTop", "&aДобро пожаловать!");
            ThePit.messages.addDefault("Russian.WelcomeTitleBot", "&7Вы успешно зашли на сервер!");
            ThePit.messages.addDefault("Russian.Kill", "&aУбийство! &7Вы убили игрока &a<target>&7 (&6+7 Золота&7, &b+23 Опыта&7)!");
            ThePit.messages.addDefault("Russian.DeadTitleTop", "&cВы умерли!");
            ThePit.messages.addDefault("Russian.DeadTitleBot", "&7Вы были убиты игроком &c<killer>&7!");
            ThePit.messages.addDefault("Russian.DeadMsg", "&cСмерть! &7Вы были убиты игроком &c<killer>&7!");
            ThePit.messages.addDefault("Russian.VerifyMessage", "&cПожалуйста, введите код: &e<code>&c!");
            ThePit.messages.addDefault("Russian.NewVerifyCode", "&cНеверный код! Сгенерирован новый код: &e<code>");
            ThePit.messages.addDefault("Russian.Verified", "&aВы успешно прошли капчу!");
            ThePit.messages.addDefault("Russian.NoPerms", "&cУ вас недостаточно прав!");

            ThePit.messages.addDefault("English.Commands.AddExpCommandUsage", "&cPlease specify arguments! Usage: &e/addexp <Player> <Exp>");
            ThePit.messages.addDefault("English.Commands.AddedExp", "&aYou have been added &e<exp> &aexperience!");
            ThePit.messages.addDefault("English.Commands.SetExpCommandUsage", "&cPlease specify arguments! Usage: &e/setexp <Player> <Exp>");
            ThePit.messages.addDefault("English.Commands.SetedExp", "&aYou have been set &e<exp> &aexperience!");
            ThePit.messages.addDefault("English.Commands.AddGoldCommandUsage", "&cPlease specify arguments! Usage: &e/addgold <Player> <Gold>");
            ThePit.messages.addDefault("English.Commands.AddedGold", "&aYou have been added &e<gold> &agold!");
            ThePit.messages.addDefault("English.Commands.SetGoldCommandUsage", "&cPlease specify arguments! Usage: &e/setgold <Player> <Gold>");
            ThePit.messages.addDefault("English.Commands.SetedGold", "&aYou have been set &e<gold> &agold!");
            ThePit.messages.addDefault("English.Commands.AddLevelCommandUsage", "&cPlease specify arguments! Usage: &e/addlevel <Player> <Level>");
            ThePit.messages.addDefault("English.Commands.AddedLevel", "&aYou have been added &e<level> &alevels!");
            ThePit.messages.addDefault("English.Commands.SetLevelCommandUsage", "&cPlease specify arguments! Usage: &e/setlevel <Player> <Level>");
            ThePit.messages.addDefault("English.Commands.SetedLevel", "&aYou have been set &e<level> &alevel!");
            ThePit.messages.addDefault("English.Commands.SetPrestigeCommandUsage", "&cPlease specify arguments! Usage: &e/setprestige <Player> <Prestige>");
            ThePit.messages.addDefault("English.Commands.SetedPrestige", "&aYou have been set &e<prestige> &aprestiges!");
            ThePit.messages.addDefault("English.Commands.AddPrestigeCommandUsage", "&cPlease specify arguments! Usage: &e/addprestige <Player> <Prestige>");
            ThePit.messages.addDefault("English.Commands.AddedPrestige", "&aYou have been added &e<prestige> &aprestiges!");
            ThePit.messages.addDefault("English.Commands.UseNumber", "&cPlease, specify number!");

            ThePit.messages.addDefault("English.ItemsShop.Buyed", "&aYou successfully buyed &e<item>&a!");
            ThePit.messages.addDefault("English.ItemsShop.HaventGold", "&cYou don't have enough gold!");

            ThePit.messages.addDefault("English.Commands.GamemodeUsage", "&cUsage: &e/gamemode <0/1/2/3>");
            ThePit.messages.addDefault("English.Commands.Gamemode", "&aYou successfully set gamemode to &esurvival&a!");
            ThePit.messages.addDefault("English.Commands.GamemodeO", "&aYou successfully set gamemode to &ecreative&a!");
            ThePit.messages.addDefault("English.Commands.GamemodeT", "&aYou successfully set gamemode to &eadventure&a!");
            ThePit.messages.addDefault("English.Commands.GamemodeS", "&aYou successfully set gamemode to &espectator&a!");

            ThePit.messages.addDefault("English.WelcomeTitleTop", "&aWelcome!");
            ThePit.messages.addDefault("English.WelcomeTitleBot", "&7You joined to the server!");
            ThePit.messages.addDefault("English.Kill", "&aKill! &7You killed &a<target>&7 (&6+7 Gold&7, &b+23 XP&7)!");
            ThePit.messages.addDefault("English.DeadTitleTop", "&cYou died!");
            ThePit.messages.addDefault("English.DeadTitleBot", "&7You was killed by &c<killer>&7!");
            ThePit.messages.addDefault("English.DeadMsg", "&cDie! &7You was killed by &c<killer>&7!");
            ThePit.messages.addDefault("English.VerifyMessage", "&cPlease, write the code: &e<code>&c!");
            ThePit.messages.addDefault("English.NewVerifyCode", "&cInvalid code! Generated new code: &e<code>");
            ThePit.messages.addDefault("English.Verified", "&aYou was verified!");
            ThePit.messages.addDefault("English.NoPerms", "&cYou don't have permissions!");

            ThePit.messages.copyDefaults(true);
            ThePit.messages.save();
            if (ThePit.getInstance().getConfig().getInt("Language") == 1) {
                ThePit.cs.sendMessage("§fThe Pit §e> §aСоздание сообщений...");
            } else {
                ThePit.cs.sendMessage("§fThe Pit §e> §aCreating ThePit.messages...");
            }

            if(!ThePit.items.contains("RU.ItemsShop.DiamondSword")) {
                ThePit.items.set("RU.ItemsShop.DiamondSword.Name", "&cАлмазный меч");
                ThePit.items.setStrings("RU.ItemsShop.DiamondSword.Lores", "&e", "&fСтоимость: &c150 &fзолота", "&7", "&aНажмите, чтобы купить!");
            }
            if(!ThePit.items.contains("RU.ItemsShop.DiamondChestplate")) {
                ThePit.items.set("RU.ItemsShop.DiamondChestplate.Name", "&cАлмазный нагрудник");
                ThePit.items.setStrings("RU.ItemsShop.DiamondChestplate.Lores", "&e", "&fСтоимость: &c250 &fзолота", "&7", "&aНажмите, чтобы купить!");
            }
            if(!ThePit.items.contains("RU.ItemsShop.DiamondBoots")) {
                ThePit.items.set("RU.ItemsShop.DiamondBoots.Name", "&cАлмазные ботинки");
                ThePit.items.setStrings("RU.ItemsShop.DiamondBoots.Lores", "&e", "&fСтоимость: &c100 &fзолота", "&7", "&aНажмите, чтобы купить!");
            }

            if(!ThePit.items.contains("EN.ItemsShop.DiamondSword")) {
                ThePit.items.set("EN.ItemsShop.DiamondSword.Name", "&cDiamond sword");
                ThePit.items.setStrings("EN.ItemsShop.DiamondSword.Lores", "&e", "&fCost: &c150 &fgold", "&7", "&aClick to buy!");
            }
            if(!ThePit.items.contains("EN.ItemsShop.DiamondChestplate")) {
                ThePit.items.set("EN.ItemsShop.DiamondChestplate.Name", "&cDiamond chestplate");
                ThePit.items.setStrings("EN.ItemsShop.DiamondChestplate.Lores", "&e", "&fCost: &c250 &fgold", "&7", "&aClick to buy!");
            }
            if(!ThePit.items.contains("EN.ItemsShop.DiamondBoots")) {
                ThePit.items.set("EN.ItemsShop.DiamondBoots.Name", "&cDiamond boots");
                ThePit.items.setStrings("EN.ItemsShop.DiamondBoots.Lores", "&e", "&fCost: &c100 &fgold", "&7", "&aClick to buy!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
