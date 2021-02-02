package nedev.hogoshi.listener;

import nedev.hogoshi.ThePit;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;

public class PInteractEvent implements Listener {

    public HashMap<String, Long> cd = new HashMap<String, Long>();

    @EventHandler
    public void i(PlayerInteractEvent e) {
        if (e.getItem() != null) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
                Player p = e.getPlayer();
                if (e.getItem().getType() == Material.SKULL_ITEM) {

                    int cooldownTime = 8;
                    if (cd.containsKey(p.getName())) {
                        long secondsLeft = ((cd.get(p.getName()) / 1000) + cooldownTime) - (System.currentTimeMillis() / 1000);
                        if (secondsLeft > 0) {
                            if (ThePit.getInstance().getConfig().getInt("Language") == 1) {
                                p.sendMessage("The Pit §e> §cВы сможете использовать голову через §e" + secondsLeft + " §cсекунд!");
                            } else {
                                p.sendMessage("The Pit §e> §cYou can use head after §e" + secondsLeft + " §cseconds!");
                            }
                        } else {
                            p.getInventory().removeItem(e.getItem());
                            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 4 * 20, 1));
                            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 8 * 20, 1));
                            cd.put(p.getName(), System.currentTimeMillis());
                        }
                    } else {
                        p.getInventory().removeItem(e.getItem());
                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 4 * 20, 1));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 8 * 20, 1));
                        cd.put(p.getName(), System.currentTimeMillis());
                    }
                }
            }
        }
    }

}
