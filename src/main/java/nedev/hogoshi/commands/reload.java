package nedev.hogoshi.commands;

import nedev.hogoshi.ThePit;
import nedev.hogoshi.util.Randomizer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class reload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        String i = Randomizer.generateRandomKey(8);
        if(s.hasPermission("*") || s.hasPermission("reload")) {
            if (args.length == 1) {

                if (args[0].equalsIgnoreCase(ThePit.getInstance().getConfig().getString("ReloadCode"))) {
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        if(ThePit.getInstance().getConfig().getInt("Language") == 1) {
                            players.kickPlayer("§fThePit §e> §cСервер перезагружается!");
                        } else {
                            players.kickPlayer("§fThePit §e> §cServer Reloading!");
                        }
                    }
                    Bukkit.getServer().reload();
                } else {
                    if(ThePit.getInstance().getConfig().getInt("Language") == 1) {
                        s.sendMessage("§fThe Pit §e> §cКод неверный! Ваш код: §e" + i);
                    } else {
                        s.sendMessage("§fThe Pit §e> §cInvalid code! Your new code: §e" + i);
                    }
                    ThePit.getInstance().getConfig().set("ReloadCode", i);
                }

            } else {
                if(ThePit.getInstance().getConfig().getInt("Language") == 1) {
                    s.sendMessage("§fThe Pit §e> §aКод для верификации перезагрузки: §e" + i + "§a! Использование: §e/r <Код>");
                } else {
                    s.sendMessage("§fThe Pit §e> §aCode for verify reloading server: §e" + i + "§a! Usage: §e/r <Код>");
                }
                ThePit.getInstance().getConfig().set("ReloadCode", i);
            }
        } else {
            if(ThePit.getInstance().getConfig().getInt("Language") == 1) {
                s.sendMessage("§fThe Pit §e> §cУ вас недостаточно прав!");
            } else {
                s.sendMessage("§fThe Pit §e> §cYou haven't permissions!");
            }
        }
        return true;
    }
}
