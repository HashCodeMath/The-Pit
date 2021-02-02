package nedev.hogoshi.listener;

import nedev.hogoshi.ThePit;
import nedev.hogoshi.util.ActionBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class EDamageEvent implements Listener {

    @EventHandler
    public void dmg1(EntityDamageEvent e) {
        if (e.getCause() != EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void dmg(EntityDamageByEntityEvent e) {
        if (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
            if (e.getEntity() instanceof Player) {
                double i = Math.round(((Player) e.getEntity()).getHealth() / 2);
                if (i == 10) {
                    ActionBar ten = new ActionBar("§e" + e.getEntity().getName() + " §8- §c❤❤❤❤❤❤❤❤❤❤");
                    ten.sendToPlayer((Player) e.getDamager());
                } else if (i == 9) {
                    ActionBar ten = new ActionBar("§e" + e.getEntity().getName() + " §8- §c❤❤❤❤❤❤❤❤❤§8❤");
                    ten.sendToPlayer((Player) e.getDamager());
                } else if (i == 8) {
                    ActionBar ten = new ActionBar("§e" + e.getEntity().getName() + " §8- §c❤❤❤❤❤❤❤❤§8❤❤");
                    ten.sendToPlayer((Player) e.getDamager());
                } else if (i == 7) {
                    ActionBar ten = new ActionBar("§e" + e.getEntity().getName() + " §8- §c❤❤❤❤❤❤❤§8❤❤❤");
                    ten.sendToPlayer((Player) e.getDamager());
                } else if (i == 6) {
                    ActionBar ten = new ActionBar("§e" + e.getEntity().getName() + " §8- §c❤❤❤❤❤❤§8❤❤❤❤");
                    ten.sendToPlayer((Player) e.getDamager());
                } else if (i == 5) {
                    ActionBar ten = new ActionBar("§e" + e.getEntity().getName() + " §8- §c❤❤❤❤❤§8❤❤❤❤❤");
                    ten.sendToPlayer((Player) e.getDamager());
                } else if (i == 4) {
                    ActionBar ten = new ActionBar("§e" + e.getEntity().getName() + " §8- §c❤❤❤❤§8❤❤❤❤❤❤");
                    ten.sendToPlayer((Player) e.getDamager());
                } else if (i == 3) {
                    ActionBar ten = new ActionBar("§e" + e.getEntity().getName() + " §8- §c❤❤❤§8❤❤❤❤❤❤❤");
                    ten.sendToPlayer((Player) e.getDamager());
                } else if (i == 2) {
                    ActionBar ten = new ActionBar("§e" + e.getEntity().getName() + " §8- §c❤❤§8❤❤❤❤❤❤❤❤");
                    ten.sendToPlayer((Player) e.getDamager());
                } else if (i == 1) {
                    ActionBar ten = new ActionBar("§e" + e.getEntity().getName() + " §8- §c❤§8❤❤❤❤❤❤❤❤❤");
                    ten.sendToPlayer((Player) e.getDamager());
                } else if (i == 0) {
                    if (ThePit.getInstance().getConfig().getInt("Language") == 1) {
                        ActionBar ten = new ActionBar("§e" + e.getEntity().getName() + " §8- §cУмер!");
                        ten.sendToPlayer((Player) e.getDamager());
                    } else {
                        ActionBar ten = new ActionBar("§e" + e.getEntity().getName() + " §8- §cDied!");
                        ten.sendToPlayer((Player) e.getDamager());
                    }
                }
            }
        } else {
            e.setCancelled(true);
        }
    }

}
