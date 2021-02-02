package nedev.hogoshi.mysql;

import nedev.hogoshi.ThePit;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import lombok.Data;
import lombok.val;
import nedev.hogoshi.listener.ListenerHelper;
import org.bukkit.Bukkit;
import org.bukkit.Sound;

import java.sql.SQLException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Data
public class LoadedUser {

    public static final LoadingCache<UUID, LoadedUser> USER_CACHE = CacheBuilder.newBuilder()
            .expireAfterWrite(1L, TimeUnit.HOURS)
            .concurrencyLevel(6)
            .removalListener((RemovalListener<UUID, LoadedUser>) removalNotification -> removalNotification.getValue().save(true))
            .build(new CacheLoader<UUID, LoadedUser>() {
                @Override
                public LoadedUser load(UUID uuid) {
                    val database = ThePit.getInstance().SQL;
                    val loadedUser = new LoadedUser(uuid);
                    try {
                        val rowSet = database.executeQuery("select * from `playerdata` where uuid = ?", uuid.toString()).get();

                        while (rowSet.next()) {
                            loadedUser.setCoins(rowSet.getLong("coins"));
                            loadedUser.setExp(rowSet.getInt("exp"));
                            loadedUser.setLevel(rowSet.getInt("level"));
                            loadedUser.setKills(rowSet.getInt("kills"));
                            loadedUser.setDeaths(rowSet.getInt("deaths"));
                            loadedUser.setPrestige(rowSet.getInt("prestige"));

                            loadedUser.setFishingrod(rowSet.getBoolean("fishingrod"));
                            loadedUser.setLavabukkit(rowSet.getBoolean("lavabukkit"));
                            loadedUser.setGoldenhead(rowSet.getBoolean("goldenhead"));
                            loadedUser.setCurrentperk(rowSet.getInt("currentperk"));

                            loadedUser.setLoaded(true);
                        }

                        if (!loadedUser.isLoaded()) {
                            database.execute("insert into `playerdata` (uuid) values (?)", uuid.toString());

                            loadedUser.setCoins(50);
                            loadedUser.setExp(0);
                            loadedUser.setLevel(1);
                            loadedUser.setDeaths(0);
                            loadedUser.setKills(0);
                            loadedUser.setPrestige(0);

                            loadedUser.setCurrentperk(0);
                            loadedUser.setFishingrod(false);
                            loadedUser.setLavabukkit(false);
                            loadedUser.setGoldenhead(false);
                        }

                        return loadedUser;
                    } catch (InterruptedException | SQLException | ExecutionException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
            });

    private final UUID uuid;
    private long coins = 0;
    private int level = 1;
    private int exp = 0;
    private int kills = 0;
    private int deaths = 0;
    private int prestige = 0;
    private int currentperk = 0;
    private boolean loaded = false;
    private boolean fishingrod = false;
    private boolean goldenhead = false;
    private boolean lavabukkit = false;

    public void save(boolean async) {
        val database = ThePit.getInstance().SQL;

        if (async) {
            database.executeQuery("update `playerdata` set coins = ?, level = ?, exp = ?, prestige = ?, kills = ?, deaths = ?, lavabukkit = ?, fishingrod = ?, goldenhead = ?, currentperk = ? where uuid = ?", coins, level, exp, prestige, kills, deaths, lavabukkit, fishingrod, goldenhead, currentperk, uuid.toString());
        } else {
            database.executeSync("update `playerdata` set coins = ?, level = ?, exp = ?, prestige = ?, kills = ?, deaths = ?, lavabukkit = ?, fishingrod = ?, goldenhead = ?, currentperk = ? where uuid = ?", coins, level, exp, prestige, kills, deaths, lavabukkit, fishingrod, goldenhead, currentperk, uuid.toString());
        }
    }

    public void addExp(int exp) {
        if (this.exp >= calculateExp() || (this.exp + exp) >= calculateExp()) {
            if (level >= 140) {
                ListenerHelper.setupscoreboard(Bukkit.getPlayer(uuid));
            } else {
                level += 1;
                setExp(0);

                ListenerHelper.setupscoreboard(Bukkit.getPlayer(uuid));

                if (ThePit.getInstance().getConfig().getInt("Language") == 1) {
                    Bukkit.getPlayer(uuid).sendTitle("§aНовый уровень! §7[§c" + (getLevel() - 1) + "§7] §a-> §7[§c" + getLevel() + "§7]", "§7Вы получили новый уровень. Поздравляем!");
                } else {
                    Bukkit.getPlayer(uuid).sendTitle("§aLeveled up! §7[§c" + (getLevel() - 1) + "§7] §a-> §7[§c" + getLevel() + "§7]", "§7You upgraded the level. Nice!");
                }

                Bukkit.getPlayer(uuid).playSound(Bukkit.getPlayer(uuid).getLocation(), Sound.ORB_PICKUP, 1, 1);
                this.addCoins(50);
            }
        } else {
            setExp(getExp() + exp);
        }
    }

    public void addPrestige(int prestige) {
        setLevel(1);
        setExp(0);
        setCoins(1000);
        ListenerHelper.setupscoreboard(Bukkit.getPlayer(uuid));
        this.prestige += prestige;

        if (ThePit.getInstance().getConfig().getInt("Language") == 1) {
            Bukkit.getPlayer(uuid).sendTitle("§aНовый престиж! §7[§c" + (getPrestige() - 1) + "§7] §a-> §7[§c" + getPrestige() + "§7]", "§7Вы получили новый престиж. Поздравляем!");
        } else {
            Bukkit.getPlayer(uuid).sendTitle("§aPrestige up! §7[§c" + (getPrestige() - 1) + "§7] §a-> §7[§c" + getPrestige() + "§7]", "§7You upgraded the prestige. Nice!");
        }
    }

    public boolean isOnSpawn() {
        return Bukkit.getPlayer(uuid).getWorld().getName().equals("world");
    }

    public void addCoins(long value) {
        setCoins(getCoins() + value);
    }

    public void addKills(int value) {
        setKills(getKills() + value);
    }

    public void addDeaths(int value) {
        setDeaths(getDeaths() + value);
    }

    public void takeCoins(long value) {
        setCoins(getCoins() + value);
    }

    public int calculateExp() {
        return calculateExp(this.level);
    }

    private int calculateExp(int level) {
        if (level < 5) {
            return 10 * level;
        } else if (level < 10) {
            return 10 * level + 20;
        } else if (level < 20) {
            return 10 * level + 30;
        } else if (level < 30) {
            return 10 * level + 40;
        } else if (level < 40) {
            return 10 * level + 50;
        } else if (level < 50) {
            return 10 * level + 60;
        } else if (level < 60) {
            return 10 * level + 70;
        } else if (level < 70) {
            return 10 * level + 80;
        } else if (level < 80) {
            return 10 * level + 90;
        } else if (level < 90) {
            return 10 * level + 100;
        } else if (level < 100) {
            return 10 * level + 110;
        } else if (level < 110) {
            return 10 * level + 120;
        } else if (level < 120) {
            return 10 * level + 130;
        } else if (level < 130) {
            return 10 * level + 140;
        } else if (level < 140) {
            return 10 * level + 150;
        } else {
            return 10 * level + 300;
        }
    }
}
