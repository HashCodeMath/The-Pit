package nedev.hogoshi.listener;

import lombok.val;
import nedev.hogoshi.ThePit;
import nedev.hogoshi.mysql.LoadedUser;
import nedev.hogoshi.netherboard.Netherboard;
import nedev.hogoshi.netherboard.bukkit.BPlayerBoard;
import nedev.hogoshi.util.ProgressUtil;
import nedev.hogoshi.util.Randomizer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ListenerHelper {

    public static String key;

    public static void generateKey() {
        key = Randomizer.generateRandomKey(6);
    }

    public static Map<Integer, String> coloredlevel = new HashMap<Integer, String>();
    public static HashMap<String, Boolean> verified = new HashMap<String, Boolean>();
    public static HashMap<String, Integer> tries = new HashMap<String, Integer>();

    public static void setupscoreboard(Player p) {
        setuplevel(p);
        val loadedUser = LoadedUser.USER_CACHE.getUnchecked(p.getUniqueId());
        BPlayerBoard board = Netherboard.instance().createBoard(p, "§c§lTHE PIT");

        String one = ThePit.getInstance().getConfig().getString("RU.scoreboard.1")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String two = ThePit.getInstance().getConfig().getString("RU.scoreboard.2")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String three = ThePit.getInstance().getConfig().getString("RU.scoreboard.3")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String four = ThePit.getInstance().getConfig().getString("RU.scoreboard.4")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String five = ThePit.getInstance().getConfig().getString("RU.scoreboard.5")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String six = ThePit.getInstance().getConfig().getString("RU.scoreboard.6")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String seven = ThePit.getInstance().getConfig().getString("RU.scoreboard.7")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String eight = ThePit.getInstance().getConfig().getString("RU.scoreboard.8")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String nine = ThePit.getInstance().getConfig().getString("RU.scoreboard.9")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String ten = ThePit.getInstance().getConfig().getString("RU.scoreboard.10")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String eleven = ThePit.getInstance().getConfig().getString("RU.scoreboard.11")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String twelve = ThePit.getInstance().getConfig().getString("RU.scoreboard.12")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String threeteen = ThePit.getInstance().getConfig().getString("RU.scoreboard.13")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));

        String enthreeteen = ThePit.getInstance().getConfig().getString("EN.scoreboard.13")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));


        String enone = ThePit.getInstance().getConfig().getString("EN.scoreboard.1")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String entwo = ThePit.getInstance().getConfig().getString("EN.scoreboard.2")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String enthree = ThePit.getInstance().getConfig().getString("EN.scoreboard.3")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String enfour = ThePit.getInstance().getConfig().getString("EN.scoreboard.4")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String enfive = ThePit.getInstance().getConfig().getString("EN.scoreboard.5")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String ensix = ThePit.getInstance().getConfig().getString("EN.scoreboard.6")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String enseven = ThePit.getInstance().getConfig().getString("EN.scoreboard.7")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String eneight = ThePit.getInstance().getConfig().getString("EN.scoreboard.8")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String ennine = ThePit.getInstance().getConfig().getString("EN.scoreboard.9")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String enten = ThePit.getInstance().getConfig().getString("EN.scoreboard.10")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String eneleven = ThePit.getInstance().getConfig().getString("EN.scoreboard.11")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String entwelve = ThePit.getInstance().getConfig().getString("EN.scoreboard.12")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));

        String maxlevel = ThePit.getInstance().getConfig().getString("RU.scoreboard.maxlevel")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));
        String enmaxlevel = ThePit.getInstance().getConfig().getString("EN.scoreboard.maxlevel")
                .replaceAll("<players>", Integer.toString(Bukkit.getOnlinePlayers().size()))
                .replaceAll("<indicator>", ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), ThePit.getInstance().getConfig().getInt("Indicator.TotalBars"), ThePit.getInstance().getConfig().getString("Indicator.Symbol"), ThePit.getInstance().getConfig().getString("Indicator.CompletedColor"), ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")))
                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + loadedUser.getLevel())
                .replaceAll("<coins>", Integer.toString((int) loadedUser.getCoins()))
                .replaceAll("<xpneed>", Integer.toString(loadedUser.calculateExp() - loadedUser.getExp()))
                .replaceAll("<prestige>", Integer.toString(loadedUser.getPrestige()))
                .replaceAll("<xp>", Integer.toString(loadedUser.getExp()));

        if (ThePit.getInstance().getConfig().getInt("Language") == 1) {
            if (loadedUser.getLevel() < 140) {
                board.setAll(
                        one,
                        two,
                        three,
                        four,
                        five,
                        six,
                        seven,
                        eight,
                        nine,
                        ten,
                        eleven,
                        twelve,
                        threeteen
                );
            } else {
                board.setAll(
                        one,
                        two,
                        three,
                        four,
                        five,
                        six,
                        maxlevel,
                        eight,
                        nine,
                        ten,
                        eleven,
                        twelve,
                        threeteen
                );
            }
        } else {
            if (loadedUser.getLevel() < 140) {
                board.setAll(
                        enone,
                        entwo,
                        enthree,
                        enfour,
                        enfive,
                        ensix,
                        enseven,
                        eneight,
                        ennine,
                        enten,
                        eneleven,
                        entwelve,
                        enthreeteen
                );
            } else {
                board.setAll(
                        enone,
                        entwo,
                        enthree,
                        enfour,
                        enfive,
                        ensix,
                        enmaxlevel,
                        eneight,
                        ennine,
                        enten,
                        eneleven,
                        entwelve,
                        enthreeteen
                );
            }
        }
    }

    public static void setupInventory(Player p) {
        if (p.getInventory().contains(Material.SKULL) ||
                p.getInventory().contains(Material.DIAMOND_SWORD) ||
                p.getInventory().contains(Material.DIAMOND_HELMET) ||
                p.getInventory().contains(Material.DIAMOND_CHESTPLATE) ||
                p.getInventory().contains(Material.DIAMOND_LEGGINGS) ||
                p.getInventory().contains(Material.DIAMOND_BOOTS)) {
        } else {
            p.getInventory().clear();
            p.getInventory().setItem(0, new ItemStack(Material.IRON_SWORD));
            p.getInventory().setItem(1, new ItemStack(Material.BOW));
            p.getInventory().setItem(8, new ItemStack(Material.ARROW, 32));
            val loadedUser = LoadedUser.USER_CACHE.getUnchecked(p.getUniqueId());
            if(loadedUser.getCurrentperk() == 1) {
                p.getInventory().setItem(2, new ItemStack(Material.FISHING_ROD));
            }
            if(loadedUser.getCurrentperk() == 3) {
                p.getInventory().setItem(2, new ItemStack(Material.LAVA_BUCKET));
            }

            if (Randomizer.generateRandomBoolean()) {
                p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
            } else {
                p.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
            }
            p.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
            if (Randomizer.generateRandomBoolean()) {
                p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
            } else {
                p.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
            }
        }
    }

    public static void setuplevel(Player p) {
        val loadedUser = LoadedUser.USER_CACHE.getUnchecked(p.getUniqueId());

        if (loadedUser.getLevel() >= 1 && loadedUser.getLevel() < 10) {
            ListenerHelper.coloredlevel.put(loadedUser.getLevel(), "§7§l");
        } else if (loadedUser.getLevel() >= 10 && loadedUser.getLevel() < 20) {
            ListenerHelper.coloredlevel.put(loadedUser.getLevel(), "§9§l");
        } else if (loadedUser.getLevel() >= 20 && loadedUser.getLevel() < 30) {
            ListenerHelper.coloredlevel.put(loadedUser.getLevel(), "§3§l");
        } else if (loadedUser.getLevel() >= 30 && loadedUser.getLevel() < 40) {
            ListenerHelper.coloredlevel.put(loadedUser.getLevel(), "§2§l");
        } else if (loadedUser.getLevel() >= 40 && loadedUser.getLevel() < 50) {
            ListenerHelper.coloredlevel.put(loadedUser.getLevel(), "§a§l");
        } else if (loadedUser.getLevel() >= 50 && loadedUser.getLevel() < 60) {
            ListenerHelper.coloredlevel.put(loadedUser.getLevel(), "§e§l");
        } else if (loadedUser.getLevel() >= 60 && loadedUser.getLevel() < 70) {
            ListenerHelper.coloredlevel.put(loadedUser.getLevel(), "§6§l");
        } else if (loadedUser.getLevel() >= 70 && loadedUser.getLevel() < 80) {
            ListenerHelper.coloredlevel.put(loadedUser.getLevel(), "§c§l");
        } else if (loadedUser.getLevel() >= 80 && loadedUser.getLevel() < 90) {
            ListenerHelper.coloredlevel.put(loadedUser.getLevel(), "§4§l");
        } else if (loadedUser.getLevel() >= 90 && loadedUser.getLevel() < 100) {
            ListenerHelper.coloredlevel.put(loadedUser.getLevel(), "§5§l");
        } else if (loadedUser.getLevel() >= 100 && loadedUser.getLevel() < 110) {
            ListenerHelper.coloredlevel.put(loadedUser.getLevel(), "§d§l");
        } else if (loadedUser.getLevel() >= 110 && loadedUser.getLevel() < 120) {
            ListenerHelper.coloredlevel.put(loadedUser.getLevel(), "§f§l");
        } else if (loadedUser.getLevel() >= 120 && loadedUser.getLevel() < 130) {
            ListenerHelper.coloredlevel.put(loadedUser.getLevel(), "§b§l");
        } else if (loadedUser.getLevel() >= 130 && loadedUser.getLevel() < 140) {
            ListenerHelper.coloredlevel.put(loadedUser.getLevel(), "§9§l");
        } else if (loadedUser.getLevel() >= 140) {
            ListenerHelper.coloredlevel.put(loadedUser.getLevel(), "§0§l");
        }
    }

    public static int getRandomNumber(int min, int max) {
        Random r = new Random();
        int randomNumber = r.nextInt(max - min) + min;
        return randomNumber;
    }

}
