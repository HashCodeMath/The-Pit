package nedev.hogoshi.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class OtherEvents implements Listener {

    @EventHandler
    public void m(PlayerMoveEvent e) {
        if (!ListenerHelper.verified.get(e.getPlayer().getName())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void m(EntitySpawnEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void p(BlockPlaceEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void b(BlockBreakEvent e) {
        e.setCancelled(true);
    }

}
