package nedev.hogoshi.commands;

import nedev.hogoshi.invs.*;
import nedev.hogoshi.ThePit;
import nedev.hogoshi.util.Saver;
import nedev.hogoshi.util.Settings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class thepitcommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String l, String[] args) {
        if(s.hasPermission("thepit.help.*") || s.hasPermission("thepit.*") || s.hasPermission("thepit.help")) {
            if(args.length == 0) {
                s.sendMessage("The Pit §e> §a");
                s.sendMessage("The Pit §e> §aВерсия плагина: §ev" + Settings.versionstring);
                s.sendMessage("The Pit §e> §a");
                return true;
            }
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("help")) {
                    if (ThePit.getInstance().getConfig().getInt("Language") == 1) {
                        s.sendMessage("The Pit §e> §a");
                        s.sendMessage("The Pit §e> §aСписок доступных команд:");
                        s.sendMessage("The Pit §e> §e/AddGold <Игрок> <Золото> §a- Добавить к балансу игрока золото.");
                        s.sendMessage("The Pit §e> §e/SetGold <Игрок> <Золото> §a- Установить золото игрока.");
                        s.sendMessage("The Pit §e> §e/AddLevel <Игрок> <Уровень> §a- Добавить к уровням игрока определённое кол-во уровней.");
                        s.sendMessage("The Pit §e> §e/SetLevel <Игрок> <Уровень> §a- Установить уровень игрока.");
                        s.sendMessage("The Pit §e> §e/AddExp <Игрок> <Опыт> §a- Добавить к опыту игрока определённое кол-во опыта.");
                        s.sendMessage("The Pit §e> §e/SetExp <Игрок> <Опыт> §a- Установить опыт игрока.");
                        s.sendMessage("The Pit §e> §e/r <Код> §a- Перезагрузка сервера.");
                        s.sendMessage("The Pit §e> §e/info <Игрок> §a- Информация об игроке.");
                        s.sendMessage("The Pit §e> §e/do <Игрок> §a- Сделать что-либо с игроком.");
                        s.sendMessage("The Pit §e> §e/addprestige <Игрок> <Престижи> §a- Выдать игроку престижи.");
                        s.sendMessage("The Pit §e> §e/setprestige <Игрок> <Престижи> §a- Установить игроку престижи.");
                        s.sendMessage("The Pit §e> §e/thepit itemsshop §a- Магазин предметов.");
                        s.sendMessage("The Pit §e> §e/thepit prestige §a- Сделать престиж.");
                        s.sendMessage("The Pit §e> §a");
                        return true;
                    } else {
                        s.sendMessage("The Pit §e> §a");
                        s.sendMessage("The Pit §e> §aList of commands:");
                        s.sendMessage("The Pit §e> §e/AddGold <Player> <Gold> §a- Add to player balance gold.");
                        s.sendMessage("The Pit §e> §e/SetGold <Player> <Gold> §a- Set the player balance gold.");
                        s.sendMessage("The Pit §e> §e/AddLevel <Player> <Level> §a- Add player level.");
                        s.sendMessage("The Pit §e> §e/SetLevel <Player> <Level> §a- Set the player level.");
                        s.sendMessage("The Pit §e> §e/AddExp <Player> <Exp> §a- Add to player exp.");
                        s.sendMessage("The Pit §e> §e/SetExp <Player> <Exp> §a- Set the player exp.");
                        s.sendMessage("The Pit §e> §e/r <Code> §a- Reload server.");
                        s.sendMessage("The Pit §e> §e/info <Player> §a- Info about player.");
                        s.sendMessage("The Pit §e> §e/do <Player> §a- Do smthng with player.");
                        s.sendMessage("The Pit §e> §e/addprestige <Player> <Prestige> §a- Give to player prestiges.");
                        s.sendMessage("The Pit §e> §e/setprestige <Player> <Prestige> §a- Set player's prestiges.");
                        s.sendMessage("The Pit §e> §e/thepit itemsshop §a- Items Shop.");
                        s.sendMessage("The Pit §e> §e/thepit prestige §a- Do prestige.");
                        s.sendMessage("The Pit §e> §a");
                        return true;
                    }
                }
            }
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("help")) {
                    if (ThePit.getInstance().getConfig().getInt("Language") == 1) {
                        s.sendMessage("The Pit §e> §a");
                        s.sendMessage("The Pit §e> §aСписок доступных команд:");
                        s.sendMessage("The Pit §e> §e/AddGold <Игрок> <Золото> §a- Добавить к балансу игрока золото.");
                        s.sendMessage("The Pit §e> §e/SetGold <Игрок> <Золото> §a- Установить золото игрока.");
                        s.sendMessage("The Pit §e> §e/AddLevel <Игрок> <Уровень> §a- Добавить к уровням игрока определённое кол-во уровней.");
                        s.sendMessage("The Pit §e> §e/SetLevel <Игрок> <Уровень> §a- Установить уровень игрока.");
                        s.sendMessage("The Pit §e> §e/AddExp <Игрок> <Опыт> §a- Добавить к опыту игрока определённое кол-во опыта.");
                        s.sendMessage("The Pit §e> §e/SetExp <Игрок> <Опыт> §a- Установить опыт игрока.");
                        s.sendMessage("The Pit §e> §e/r <Код> §a- Перезагрузка сервера.");
                        s.sendMessage("The Pit §e> §e/info <Игрок> §a- Информация об игроке.");
                        s.sendMessage("The Pit §e> §e/do <Игрок> §a- Сделать что-либо с игроком.");
                        s.sendMessage("The Pit §e> §e/addprestige <Игрок> <Престижи> §a- Выдать игроку престижи.");
                        s.sendMessage("The Pit §e> §e/setprestige <Игрок> <Престижи> §a- Установить игроку престижи.");
                        s.sendMessage("The Pit §e> §e/thepit itemsshop §a- Магазин предметов.");
                        s.sendMessage("The Pit §e> §e/thepit prestige §a- Сделать престиж.");
                        s.sendMessage("The Pit §e> §a");
                        return true;
                    } else {
                        s.sendMessage("The Pit §e> §a");
                        s.sendMessage("The Pit §e> §aList of commands:");
                        s.sendMessage("The Pit §e> §e/AddGold <Player> <Gold> §a- Add to player balance gold.");
                        s.sendMessage("The Pit §e> §e/SetGold <Player> <Gold> §a- Set the player balance gold.");
                        s.sendMessage("The Pit §e> §e/AddLevel <Player> <Level> §a- Add player level.");
                        s.sendMessage("The Pit §e> §e/SetLevel <Player> <Level> §a- Set the player level.");
                        s.sendMessage("The Pit §e> §e/AddExp <Player> <Exp> §a- Add to player exp.");
                        s.sendMessage("The Pit §e> §e/SetExp <Player> <Exp> §a- Set the player exp.");
                        s.sendMessage("The Pit §e> §e/r <Code> §a- Reload server.");
                        s.sendMessage("The Pit §e> §e/info <Player> §a- Info about player.");
                        s.sendMessage("The Pit §e> §e/do <Player> §a- Do smthng with player.");
                        s.sendMessage("The Pit §e> §e/addprestige <Player> <Prestige> §a- Give to player prestiges.");
                        s.sendMessage("The Pit §e> §e/setprestige <Player> <Prestige> §a- Set player's prestiges.");
                        s.sendMessage("The Pit §e> §e/thepit itemsshop §a- Items Shop.");
                        s.sendMessage("The Pit §e> §e/thepit prestige §a- Do prestige.");
                        s.sendMessage("The Pit §e> §a");
                        return true;
                    }
                }
                if(args[0].equalsIgnoreCase("saveall")) {
                    Saver.saveAll();
                    s.sendMessage("§fThe Pit §e> §aSaved!");
                }
            }
        } else {
            s.sendMessage("The Pit §e> §cУ вас недостаточно прав!");
        }

        if(args[0].equalsIgnoreCase("itemsshop")) {
            Player p = (Player) s;

            if(ThePit.getInstance().getConfig().getInt("Language") == 1) {
                ItemShopRU.INVENTORY.open(p);
            } else {
                ItemShopEN.INVENTORY.open(p);
            }
        }

        if(args[0].equalsIgnoreCase("prestige")) {
            Player p = (Player) s;

            if(ThePit.getInstance().getConfig().getInt("Language") == 1) {
                PrestigeRU.INVENTORY.open(p);
            } else {
                PrestigeEN.INVENTORY.open(p);
            }
        }

        if(args[0].equalsIgnoreCase("perks")) {
            Player p = (Player) s;

            if(ThePit.getInstance().getConfig().getInt("Language") == 1) {
                PerksRU.INVENTORY.open(p);
            } else {
                PerksEN.INVENTORY.open(p);
            }
        }
        return true;
    }
}
