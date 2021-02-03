package nedev.hogoshi.invs;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import lombok.val;
import nedev.hogoshi.ThePit;
import nedev.hogoshi.listener.ListenerHelper;
import nedev.hogoshi.mysql.LoadedUser;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class ItemShopRU implements InventoryProvider {
    public static final SmartInventory INVENTORY = SmartInventory.builder()
            .id("myInventory")
            .provider(new ItemShopRU())
            .size(6, 9)
            .title("§cМагазин предметов")
            .build();

    private final Random random = new Random();

    @Override
    public void init(Player player, InventoryContents contents) {
        contents.fillBorders(ClickableItem.empty(new ItemStack(Material.STAINED_GLASS_PANE)));

        ItemStack dsword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta dsmeta = dsword.getItemMeta();

        List<String> dslores = ThePit.items.getStringList("RU.ItemsShop.DiamondSword.Lores");

        dsmeta.setDisplayName(ThePit.items.getString("RU.ItemsShop.DiamondSword.Name"));

        dsmeta.setLore(dslores);

        dsmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        dsword.setItemMeta(dsmeta);

        contents.set(2, 2, ClickableItem.of(dsword,
                e -> {
                    val loadedUser = LoadedUser.USER_CACHE.getUnchecked(player.getUniqueId());
                    if (loadedUser.getCoins() >= 150) {
                        player.sendMessage(ThePit.messages.getString("Russian.ItemsShop.Buyed").replaceAll("<item>", "Diamond Sword"));
                        loadedUser.setCoins(loadedUser.getCoins() - 150);
                        ListenerHelper.setupscoreboard(player);

                        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
                        ItemMeta meta = sword.getItemMeta();
                        meta.setDisplayName(ThePit.items.getString("RU.ItemsShop.DiamondSword.Name"));
                        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        sword.setItemMeta(meta);

                        if(player.getInventory().contains(Material.IRON_SWORD)) {
                            player.getInventory().all(Material.IRON_SWORD).entrySet().stream().findAny().ifPresent(entry -> player.getInventory().setItem(entry.getKey(), sword));
                        } else {
                            player.getInventory().addItem(sword);
                        }
                    } else {
                        player.sendMessage(ThePit.messages.getString("Russian.ItemsShop.HaventGold"));
                    }
                }));

        ////////////////////////////////////////////////////////////

        ItemStack dchest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta dcmeta = dchest.getItemMeta();

        List<String> dclores = ThePit.items.getStringList("RU.ItemsShop.DiamondChestplate.Lores");

        dcmeta.setDisplayName(ThePit.items.getString("RU.ItemsShop.DiamondChestplate.Name"));
        dcmeta.setLore(dclores);

        dcmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        dchest.setItemMeta(dcmeta);

        contents.set(2, 4, ClickableItem.of(dchest,
                e -> {
                    val loadedUser = LoadedUser.USER_CACHE.getUnchecked(player.getUniqueId());
                    if (loadedUser.getCoins() >= 250) {
                        player.sendMessage(ThePit.messages.getString("Russian.ItemsShop.Buyed").replaceAll("<item>", "Diamond Chestplate"));
                        loadedUser.setCoins(loadedUser.getCoins() - 250);
                        ListenerHelper.setupscoreboard(player);
                        ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
                        ItemMeta meta = chest.getItemMeta();
                        meta.setDisplayName(ThePit.items.getString("RU.ItemsShop.DiamondChestplate.Name"));
                        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        chest.setItemMeta(meta);
                        if(player.getInventory().contains(Material.IRON_CHESTPLATE)) {
                            player.getInventory().all(Material.IRON_CHESTPLATE).entrySet().stream().findFirst().ifPresent(entry -> player.getInventory().setItem(entry.getKey(), chest));
                        } else if(player.getInventory().getChestplate().equals(new ItemStack(Material.CHAINMAIL_CHESTPLATE))) {
                            player.getInventory().setChestplate(chest);
                        } else if(player.getInventory().getChestplate().equals(new ItemStack(Material.IRON_CHESTPLATE))) {
                            player.getInventory().setChestplate(chest);
                        } else if(player.getInventory().contains(Material.CHAINMAIL_CHESTPLATE)) {
                            player.getInventory().all(Material.CHAINMAIL_CHESTPLATE).entrySet().stream().findFirst().ifPresent(entry -> player.getInventory().setItem(entry.getKey(), chest));
                        } else {
                            player.getInventory().addItem(chest);
                        }
                    } else {
                        player.sendMessage(ThePit.messages.getString("Russian.ItemsShop.HaventGold"));
                    }
                }));

        ////////////////////////////////////////////////////////////

        ItemStack dboots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta dbmeta = dchest.getItemMeta();

        List<String> dblores = ThePit.items.getStringList("RU.ItemsShop.DiamondBoots.Lores");

        dbmeta.setDisplayName(ThePit.items.getString("RU.ItemsShop.DiamondBoots.Name"));
        dbmeta.setLore(dblores);

        dbmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        dboots.setItemMeta(dbmeta);

        contents.set(2, 5, ClickableItem.of(dboots,
                e -> {
                    val loadedUser = LoadedUser.USER_CACHE.getUnchecked(player.getUniqueId());
                    if (loadedUser.getCoins() >= 100) {
                        player.sendMessage(ThePit.messages.getString("Russian.ItemsShop.Buyed").replaceAll("<item>", "Diamond Boots"));
                        loadedUser.setCoins(loadedUser.getCoins() - 100);
                        ListenerHelper.setupscoreboard(player);
                        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
                        ItemMeta meta = boots.getItemMeta();
                        meta.setDisplayName(ThePit.items.getString("RU.ItemsShop.DiamondBoots.Name"));
                        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        boots.setItemMeta(meta);
                        if(player.getInventory().contains(Material.IRON_BOOTS)) {
                            player.getInventory().all(Material.IRON_BOOTS).entrySet().stream().findFirst().ifPresent(entry -> player.getInventory().setItem(entry.getKey(), boots));
                        } else if(player.getInventory().getBoots().equals(new ItemStack(Material.CHAINMAIL_BOOTS))) {
                            player.getInventory().setChestplate(boots);
                        } else if(player.getInventory().getBoots().equals(new ItemStack(Material.IRON_BOOTS))) {
                            player.getInventory().setChestplate(boots);
                        } else if(player.getInventory().contains(Material.CHAINMAIL_BOOTS)) {
                            player.getInventory().all(Material.CHAINMAIL_BOOTS).entrySet().stream().findFirst().ifPresent(entry -> player.getInventory().setItem(entry.getKey(), boots));
                        } else {
                            player.getInventory().addItem(boots);
                        }

                    } else {
                        player.sendMessage(ThePit.messages.getString("Russian.ItemsShop.HaventGold"));
                    }
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
