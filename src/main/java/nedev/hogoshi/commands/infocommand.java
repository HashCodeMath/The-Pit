package nedev.hogoshi.commands;

import lombok.val;
import nedev.hogoshi.ThePit;
import nedev.hogoshi.mysql.LoadedUser;
import nedev.hogoshi.util.ProgressUtil;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class infocommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if(args.length == 0) {
            if(ThePit.getInstance().getConfig().getInt("Language") == 1) {
                s.sendMessage("§fThe Pit §e> §cПожалуйста, укажите аргументы!");
            } else {
                s.sendMessage("§fThe Pit §e> §cPlease, specify arguments!");
            }
        }
        if(args.length != 1 && args.length != 0) {
            if(ThePit.getInstance().getConfig().getInt("Language") == 1) {
                s.sendMessage("§fThe Pit §e> §cИспользование: §e/info <Игрок>");
            } else {
                s.sendMessage("§fThe Pit §e> §cUsage: §e/info <Player>");
            }
        } else {
            if(ThePit.getInstance().getConfig().getInt("Language") == 1) {
                String name = args[0];
                try {
                    Player p = Bukkit.getPlayer(name);
                    val loadedUser = LoadedUser.USER_CACHE.getUnchecked(p.getUniqueId());

                    if(loadedUser.isLoaded()) {
                        s.sendMessage("§fThe Pit §e> §f");
                        s.sendMessage("§fThe Pit §e> §fИнформация об §c" + p.getName());
                        s.sendMessage("§fThe Pit §e> §f");
                        s.sendMessage("§fThe Pit §e> §fУровень: §c" + loadedUser.getLevel());
                        s.sendMessage("§fThe Pit §e> §fОпыта: §c" + loadedUser.getExp());
                        s.sendMessage("§fThe Pit §e> §fОпыта до следущего уровня: §c" + (loadedUser.calculateExp() - loadedUser.getExp()));
                        s.sendMessage("§fThe Pit §e> §fИндикатор: " + ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), 50, "|", "&c", ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")));
                        s.sendMessage("§fThe Pit §e> §fПрестижей: §c" + loadedUser.getPrestige());
                        s.sendMessage("§fThe Pit §e> §fУбийств: §c" + loadedUser.getKills());
                        s.sendMessage("§fThe Pit §e> §fСмертей: §c" + loadedUser.getDeaths());
                        s.sendMessage("§fThe Pit §e> §fЗолота: §c" + loadedUser.getCoins());
                        s.sendMessage("§fThe Pit §e> §f");
                    } else {
                        s.sendMessage("§fThe Pit §e> §cЭтот игрок не играл раньше!");
                    }
                } catch (Exception e) {
                    OfflinePlayer p = Bukkit.getOfflinePlayer(name);
                    val loadedUser = LoadedUser.USER_CACHE.getUnchecked(p.getUniqueId());

                    if(loadedUser.isLoaded()) {
                        s.sendMessage("§fThe Pit §e> §f");
                        s.sendMessage("§fThe Pit §e> §fИнформация об §c" + p.getName());
                        s.sendMessage("§fThe Pit §e> §f");
                        s.sendMessage("§fThe Pit §e> §fУровень: §c" + loadedUser.getLevel());
                        s.sendMessage("§fThe Pit §e> §fОпыта: §c" + loadedUser.getExp());
                        s.sendMessage("§fThe Pit §e> §fОпыта до следущего уровня: §c" + (loadedUser.calculateExp() - loadedUser.getExp()));
                        s.sendMessage("§fThe Pit §e> §fИндикатор: " + ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), 50, "|", "&c", ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")));
                        s.sendMessage("§fThe Pit §e> §fПрестижей: §c" + loadedUser.getPrestige());
                        s.sendMessage("§fThe Pit §e> §fУбийств: §c" + loadedUser.getKills());
                        s.sendMessage("§fThe Pit §e> §fСмертей: §c" + loadedUser.getDeaths());
                        s.sendMessage("§fThe Pit §e> §fЗолота: §c" + loadedUser.getCoins());
                        s.sendMessage("§fThe Pit §e> §f");
                    } else {
                        s.sendMessage("§fThe Pit §e> §cЭтот игрок не играл раньше!");
                    }
                }
            } else {
                String name = args[0];
                try {
                    Player p = Bukkit.getPlayer(name);
                    val loadedUser = LoadedUser.USER_CACHE.getUnchecked(p.getUniqueId());

                    if(loadedUser.isLoaded()) {
                        s.sendMessage("§fThe Pit §e> §f");
                        s.sendMessage("§fThe Pit §e> §fInfo about §c" + p.getName());
                        s.sendMessage("§fThe Pit §e> §f");
                        s.sendMessage("§fThe Pit §e> §fLevel: §c" + loadedUser.getLevel());
                        s.sendMessage("§fThe Pit §e> §fExp: §c" + loadedUser.getExp());
                        s.sendMessage("§fThe Pit §e> §fExp to next level: §c" + (loadedUser.calculateExp() - loadedUser.getExp()));
                        s.sendMessage("§fThe Pit §e> §fIndicator: " + ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), 50, "|", "&c", ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")));
                        s.sendMessage("§fThe Pit §e> §fPrestiges: §c" + loadedUser.getPrestige());
                        s.sendMessage("§fThe Pit §e> §fKills: §c" + loadedUser.getKills());
                        s.sendMessage("§fThe Pit §e> §fDeaths: §c" + loadedUser.getDeaths());
                        s.sendMessage("§fThe Pit §e> §fGold: §c" + loadedUser.getCoins());
                        s.sendMessage("§fThe Pit §e> §f");
                    } else {
                        s.sendMessage("§fThe Pit §e> §cThis player don't played before!");
                    }
                } catch (Exception e) {
                    OfflinePlayer p = Bukkit.getOfflinePlayer(name);
                    val loadedUser = LoadedUser.USER_CACHE.getUnchecked(p.getUniqueId());

                    if(loadedUser.isLoaded()) {
                        s.sendMessage("§fThe Pit §e> §f");
                        s.sendMessage("§fThe Pit §e> §fInfo about §c" + p.getName());
                        s.sendMessage("§fThe Pit §e> §f");
                        s.sendMessage("§fThe Pit §e> §fLevel: §c" + loadedUser.getLevel());
                        s.sendMessage("§fThe Pit §e> §fExp: §c" + loadedUser.getExp());
                        s.sendMessage("§fThe Pit §e> §fExp to next level: §c" + (loadedUser.calculateExp() - loadedUser.getExp()));
                        s.sendMessage("§fThe Pit §e> §fIndicator: " + ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), 50, "|", "&c", ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")));
                        s.sendMessage("§fThe Pit §e> §fPrestige: §c" + loadedUser.getPrestige());
                        s.sendMessage("§fThe Pit §e> §fKills: §c" + loadedUser.getKills());
                        s.sendMessage("§fThe Pit §e> §fDeaths: §c" + loadedUser.getDeaths());
                        s.sendMessage("§fThe Pit §e> §fGold: §c" + loadedUser.getCoins());
                        s.sendMessage("§fThe Pit §e> §f");
                    } else {
                        s.sendMessage("§fThe Pit §e> §cThis player don't played before!");
                    }
                }
            }
        }
        return true;
    }
}
