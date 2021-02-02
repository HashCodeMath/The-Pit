package nedev.hogoshi.listener;

import lombok.val;
import nedev.hogoshi.mysql.LoadedUser;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PQuitEvent implements Listener {

    @EventHandler
    public void q(PlayerQuitEvent e) {
        e.setQuitMessage("");

        val loadedUser = LoadedUser.USER_CACHE.getUnchecked(e.getPlayer().getUniqueId());

        ListenerHelper.verified.remove(e.getPlayer().getName());
        ListenerHelper.tries.remove(e.getPlayer().getName());
        ListenerHelper.coloredlevel.remove(loadedUser.getLevel());
    }

}
