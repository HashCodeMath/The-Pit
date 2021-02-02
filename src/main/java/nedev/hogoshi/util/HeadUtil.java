package nedev.hogoshi.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class HeadUtil {

    public static ItemStack Skull(String skullOwner, int quantity) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, quantity, (short) SkullType.PLAYER.ordinal());
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setOwner(Bukkit.getServer().getOfflinePlayer("Notch").getUniqueId().toString());
        skull.setItemMeta(skullMeta);
        return skull;

    }

}
