package nedev.hogoshi.commands;

import nedev.hogoshi.ThePit;
import nedev.hogoshi.util.TextBuilder;
import net.md_5.bungee.api.chat.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class docommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String l, String[] args) {
        if (args.length == 0) {
            s.sendMessage("§cSpecify args!");
        }
        if (args.length == 1) {
            String name = args[0];
            Player target = Bukkit.getPlayer(name);

            try {
                if (ThePit.getInstance().getConfig().getInt("Language") == 1) {
                    TextComponent msg = new TextComponent("§a" + target.getName() + " §f- ");
                    msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aОнлайн").create()));

                    TextComponent ls = new TextComponent(" §2ЛС");
                    ls.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aНаписать игроку личное сообщение").create()));
                    ls.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tell " + target.getName() + " "));

                    TextComponent ban = new TextComponent(" §cБан");
                    ban.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cЗабанить игрока").create()));
                    ban.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/ban " + target.getName() + " "));

                    TextComponent mute = new TextComponent(" §9Мут");
                    mute.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§9Замутить игрока").create()));
                    mute.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/mute " + target.getName() + " "));

                    TextComponent info = new TextComponent(" §6Информация");
                    info.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§6Просмотреть всю информацию об игроке").create()));
                    info.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/info " + target.getName()));

                    Player p = (Player) s;

                    if (p.hasPermission("ban") && p.hasPermission("mute")) {
                        p.spigot().sendMessage(msg, ls, ban, mute, info);
                    } else if (p.hasPermission("ban") && !p.hasPermission("mute")) {
                        p.spigot().sendMessage(msg, ls, ban, info);
                    } else if (p.hasPermission("mute") && !p.hasPermission("ban")) {
                        p.spigot().sendMessage(msg, ls, mute, info);
                    } else {
                        p.spigot().sendMessage(msg, ls, info);
                    }
                } else {
                    TextComponent msg = new TextComponent("§a" + target.getName() + " §f- ");
                    msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aOnline").create()));

                    TextComponent ls = new TextComponent(" §2DM");
                    ls.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aDm this player").create()));
                    ls.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tell " + target.getName() + " "));

                    TextComponent ban = new TextComponent(" §cBan");
                    ban.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cBan player").create()));
                    ban.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/ban " + target.getName() + " "));

                    TextComponent mute = new TextComponent(" §9Mute");
                    mute.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§9Mute player").create()));
                    mute.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/mute " + target.getName() + " "));

                    TextComponent info = new TextComponent(" §6Info");
                    info.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§6Suggest info about this player").create()));
                    info.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/info " + target.getName()));

                    Player p = (Player) s;

                    if (p.hasPermission("ban") && p.hasPermission("mute")) {
                        p.spigot().sendMessage(msg, ls, ban, mute, info);
                    } else if (p.hasPermission("ban") && !p.hasPermission("mute")) {
                        p.spigot().sendMessage(msg, ls, ban, info);
                    } else if (p.hasPermission("mute") && !p.hasPermission("ban")) {
                        p.spigot().sendMessage(msg, ls, mute, info);
                    } else {
                        p.spigot().sendMessage(msg, ls, info);
                    }
                }
            } catch (Exception e) {
                OfflinePlayer targetoffline = Bukkit.getOfflinePlayer(name);
                if (ThePit.getInstance().getConfig().getInt("Language") == 1) {
                    TextComponent msg = new TextComponent("§c" + targetoffline.getName() + " §f- ");
                    msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cOffline").create()));

                    TextComponent ls = new TextComponent(" §2ЛС");
                    ls.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aНаписать игроку личное сообщение").create()));
                    ls.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tell " + targetoffline.getName() + " "));

                    TextComponent ban = new TextComponent(" §cБан");
                    ban.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cЗабанить игрока").create()));
                    ban.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/ban " + targetoffline.getName() + " "));

                    TextComponent mute = new TextComponent(" §9Мут");
                    mute.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§9Замутить игрока").create()));
                    mute.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/mute " + targetoffline.getName() + " "));

                    TextComponent info = new TextComponent(" §6Информация");
                    info.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§6Просмотреть всю информацию об игроке").create()));
                    info.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/info " + targetoffline.getName()));

                    Player p = (Player) s;

                    if (p.hasPermission("ban") && p.hasPermission("mute")) {
                        p.spigot().sendMessage(msg, ls, ban, mute, info);
                    } else if (p.hasPermission("ban") && !p.hasPermission("mute")) {
                        p.spigot().sendMessage(msg, ls, ban, info);
                    } else if (p.hasPermission("mute") && !p.hasPermission("ban")) {
                        p.spigot().sendMessage(msg, ls, mute, info);
                    } else {
                        p.spigot().sendMessage(msg, ls, info);
                    }
                } else {
                    TextComponent msg = new TextComponent("§c" + targetoffline.getName() + " §f- ");
                    msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cOffline").create()));

                    TextComponent ls = new TextComponent(" §2DM");
                    ls.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§aDm this player").create()));
                    ls.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tell " + targetoffline.getName() + " "));

                    TextComponent ban = new TextComponent(" §cBan");
                    ban.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§cBan player").create()));
                    ban.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/ban " + targetoffline.getName() + " "));

                    TextComponent mute = new TextComponent(" §9Mute");
                    mute.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§9Mute player").create()));
                    mute.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/mute " + targetoffline.getName() + " "));

                    TextComponent info = new TextComponent(" §6Info");
                    info.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§6Suggest info about this player").create()));
                    info.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/info " + targetoffline.getName()));

                    Player p = (Player) s;

                    if (p.hasPermission("ban") && p.hasPermission("mute")) {
                        p.spigot().sendMessage(msg, ls, ban, mute, info);
                    } else if (p.hasPermission("ban") && !p.hasPermission("mute")) {
                        p.spigot().sendMessage(msg, ls, ban, info);
                    } else if (p.hasPermission("mute") && !p.hasPermission("ban")) {
                        p.spigot().sendMessage(msg, ls, mute, info);
                    } else {
                        p.spigot().sendMessage(msg, ls, info);
                    }
                }
            }

        }
        return true;
    }
}
