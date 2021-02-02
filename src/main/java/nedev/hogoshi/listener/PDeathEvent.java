package nedev.hogoshi.listener;

import lombok.val;
import nedev.hogoshi.ThePit;
import nedev.hogoshi.mysql.LoadedUser;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class PDeathEvent implements Listener {

    @EventHandler
    public void d(PlayerDeathEvent e) {
        Player p = e.getEntity();

        e.setDeathMessage("");
        e.setKeepInventory(false);
        e.getDrops().clear();

        if (p.getKiller() instanceof Player) {
            val loadedUser = LoadedUser.USER_CACHE.getUnchecked(e.getEntity().getKiller().getUniqueId());
            val loadedUserr = LoadedUser.USER_CACHE.getUnchecked(e.getEntity().getUniqueId());

            if (ThePit.getInstance().getConfig().getInt("Language") == 1) {
                p.sendTitle(ThePit.messages.getString("Russian.DeadTitleTop"), ThePit.messages.getString("Russian.DeadTitleBot").replaceAll("<killer>", e.getEntity().getKiller().getName()));
            } else {
                p.sendTitle(ThePit.messages.getString("English.DeadTitleTop"), ThePit.messages.getString("English.DeadTitleBot").replaceAll("<killer>", e.getEntity().getKiller().getName()));
            }

            if (ThePit.getInstance().getConfig().getInt("Language") == 1) {
                p.getKiller().sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("Russian.Kill").replaceAll("<target>", e.getEntity().getName()));
                p.sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("Russian.DeadMsg").replaceAll("<killer>", e.getEntity().getName()));
            } else {
                p.getKiller().sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("English.Kill").replaceAll("<target>", e.getEntity().getName()));
                p.sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("English.DeadMsg").replaceAll("<killer>", e.getEntity().getName()));
            }

            ItemStack random = new ItemStack(Material.SKULL_ITEM,1 , (byte)3);

            SkullMeta meta = (SkullMeta) random.getItemMeta();

            meta.setOwner(Bukkit.getOfflinePlayer("Increasen").getName());

            random.setItemMeta(meta);

            meta.setDisplayName("§6Золотая голова");

            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

            random.setItemMeta(meta);

            ItemStack ga = new ItemStack(Material.GOLDEN_APPLE);
            ItemMeta metaga = ga.getItemMeta();

            metaga.setDisplayName("§6Золотое яблоко");

            ga.setItemMeta(metaga);

            if(loadedUser.getCurrentperk() == 2) {
                p.getKiller().getInventory().addItem(random);
            } else {
                p.getKiller().getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
            }

            if (loadedUser.getLevel() != 140) {
                loadedUser.addExp(23);
            }

            ListenerHelper.setupscoreboard(p.getKiller());

            loadedUser.addKills(1);
            loadedUserr.addDeaths(1);

        }

        p.spigot().respawn();

        Bukkit.getScheduler().runTaskLater(ThePit.getInstance(), new Runnable() {
            @Override
            public void run() {
                ListenerHelper.setupInventory(p);
            }
        }, 5);
    }

}
