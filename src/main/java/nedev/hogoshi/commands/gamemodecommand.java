package nedev.hogoshi.commands;

import nedev.hogoshi.ThePit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gamemodecommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String l, String[] args) {
        if(args.length == 0) {
            if(ThePit.getInstance().getConfig().getInt("Language") == 1) {
                s.sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("Russian.Commands.GamemodeUsage"));
            } else {
                s.sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("English.Commands.GamemodeUsage"));
            }
        }

        if(args.length == 1) {
            if(s.hasPermission("gamemode.use")) {
                if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("s")) {
                    Player p = (Player) s;
                    p.setGameMode(GameMode.SURVIVAL);
                    if(ThePit.getInstance().getConfig().getInt("Language") == 1) {
                        p.sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("Russian.Commands.Gamemode"));
                    } else {
                        p.sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("English.Commands.Gamemode"));
                    }
                }
                if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("c")) {
                    Player p = (Player) s;
                    p.setGameMode(GameMode.SURVIVAL);
                    if(ThePit.getInstance().getConfig().getInt("Language") == 1) {
                        p.sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("Russian.Commands.GamemodeO"));
                    } else {
                        p.sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("English.Commands.GamemodeO"));
                    }
                }
                if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("a")) {
                    Player p = (Player) s;
                    p.setGameMode(GameMode.SURVIVAL);
                    if(ThePit.getInstance().getConfig().getInt("Language") == 1) {
                        p.sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("Russian.Commands.GamemodeT"));
                    } else {
                        p.sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("English.Commands.GamemodeT"));
                    }
                }
                if(args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("spec")) {
                    Player p = (Player) s;
                    p.setGameMode(GameMode.SURVIVAL);
                    if(ThePit.getInstance().getConfig().getInt("Language") == 1) {
                        p.sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("Russian.Commands.GamemodeS"));
                    } else {
                        p.sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("English.Commands.GamemodeS"));
                    }
                }
            }
        }
        return true;
    }
}
