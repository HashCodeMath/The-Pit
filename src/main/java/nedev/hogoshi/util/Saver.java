package nedev.hogoshi.util;

import nedev.hogoshi.mysql.LoadedUser;
import lombok.val;
import org.bukkit.Bukkit;

public class Saver {

    public static void saveAll() {
        for(val onlinePlayer : Bukkit.getOnlinePlayers()) {
            val loadedUser = LoadedUser.USER_CACHE.getUnchecked(onlinePlayer.getUniqueId());
            loadedUser.save(false);
        }
    }
}
