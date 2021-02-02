package nedev.hogoshi.invs;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import lombok.val;
import nedev.hogoshi.mysql.LoadedUser;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionPrestigeEN implements InventoryProvider {
    public static final SmartInventory INVENTORY = SmartInventory.builder()
            .id("myInventory")
            .provider(new QuestionPrestigeEN())
            .size(6, 9)
            .title("§aContinue?")
            .build();

    private final Random random = new Random();

    @Override
    public void init(Player player, InventoryContents contents) {
        contents.fillBorders(ClickableItem.empty(new ItemStack(Material.STAINED_GLASS_PANE)));

        ItemStack dsword = new ItemStack(Material.PAPER);
        ItemMeta dsmeta = dsword.getItemMeta();

        List<String> dslores = new ArrayList<>();

        dslores.add("§e");
        dslores.add("§f§o* Prestiges - Restoring stats, but ");
        dslores.add("§f§oyour level, exp, inventory, e.t.c, will be reset");
        dslores.add("§f§obut you will get bonus for that.");
        dslores.add("§e");
        dslores.add("§f§o* You need 140 level.");
        dslores.add("§e");


        dsmeta.setDisplayName("§eWhat prestiges does?");
        dsmeta.setLore(dslores);

        dsmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        dsword.setItemMeta(dsmeta);

        contents.set(1, 4, ClickableItem.of(dsword,
                e -> {
                }));

        ItemStack makeprestige = new ItemStack(Material.EMERALD_BLOCK);
        ItemMeta prestigemeta = makeprestige.getItemMeta();

        List<String> plores = new ArrayList<>();

        plores.add("§e");
        plores.add("§aClick for apply.");
        plores.add("§e");

        prestigemeta.setDisplayName("§aApply");
        prestigemeta.setLore(plores);

        prestigemeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        makeprestige.setItemMeta(prestigemeta);

        contents.set(3, 2, ClickableItem.of(makeprestige,
                e -> {
                    player.closeInventory();
                    val loadedUser = LoadedUser.USER_CACHE.getUnchecked(player.getUniqueId());
                    if(loadedUser.getLevel() == 140) {
                        loadedUser.addPrestige(1);
                    } else {
                        player.sendMessage("§fThe Pit §e> §cYou don't have enough level!");
                    }
                }));

        ItemStack cancel = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta cancelmeta = cancel.getItemMeta();

        List<String> cancelores = new ArrayList<>();

        cancelores.add("§e");
        cancelores.add("§cClick to cancel.");
        cancelores.add("§e");

        cancelmeta.setDisplayName("§cCancel");
        cancelmeta.setLore(cancelores);

        cancelmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        cancel.setItemMeta(cancelmeta);

        contents.set(3, 6, ClickableItem.of(cancel,
                e -> {
                    player.closeInventory();
                }));
    }

    @Override
    public void update(Player player, InventoryContents contents) {
        int state = contents.property("state", 0);
        contents.setProperty("state", state + 1);

        if (state % 5 != 0)
            return;

        short durability = (short) random.nextInt(15);

        ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, durability);
        contents.fillBorders(ClickableItem.empty(glass));
    }
}
