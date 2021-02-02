package nedev.hogoshi.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class FChangeEvent implements Listener {

    @EventHandler
    public void m(FoodLevelChangeEvent e) {
        e.setFoodLevel(20);
        e.setCancelled(true);
    }

}
