package nedev.hogoshi.listener;

import nedev.hogoshi.ThePit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PJoinEvent implements Listener {

    @EventHandler
    public void j(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage("");

        p.setHealth(20);
        p.setFoodLevel(20);

        if (ThePit.getInstance().getConfig().getInt("Language") == 1) {
            p.sendTitle(ThePit.messages.getString("Russian.WelcomeTitleTop"), ThePit.messages.getString("Russian.WelcomeTitleBot"));
        } else {
            p.sendTitle(ThePit.messages.getString("English.WelcomeTitleTop"), ThePit.messages.getString("English.WelcomeTitleBot"));
        }

        ListenerHelper.setupscoreboard(p);

        ListenerHelper.setupInventory(p);

        if (!ListenerHelper.verified.containsKey(p.getName()) && !ListenerHelper.tries.containsKey(p.getName())) {
            ListenerHelper.generateKey();
            ListenerHelper.verified.put(p.getName(), false);
            if (ThePit.getInstance().getConfig().getInt("Language") == 1) {
                p.sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("Russian.VerifyMessage").replaceAll("<code>", ListenerHelper.key));
            } else {
                p.sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("English.VerifyMessage").replaceAll("<code>", ListenerHelper.key));
            }
        }
    }

}
