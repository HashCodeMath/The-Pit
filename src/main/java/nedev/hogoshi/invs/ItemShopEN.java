package nedev.hogoshi.invs;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import lombok.val;
import nedev.hogoshi.listener.ListenerHelper;
import nedev.hogoshi.mysql.LoadedUser;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemShopEN implements InventoryProvider {
    public static final SmartInventory INVENTORY = SmartInventory.builder()
            .id("myInventory")
            .provider(new ItemShopEN())
            .size(6, 9)
            .title("§cItems Shop")
            .build();

    private final Random random = new Random();

    @Override
    public void init(Player player, InventoryContents contents) {
        contents.fillBorders(ClickableItem.empty(new ItemStack(Material.STAINED_GLASS_PANE)));

        ItemStack dsword = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta dsmeta = dsword.getItemMeta();

        List<String> dslores = new ArrayList<>();

        dslores.add("§e");
        dslores.add("§fCost: §c150 §fgold");
        dslores.add("§7");
        dslores.add("§aClick to buy it!");

        dsmeta.setDisplayName("§cDiamond sword");
        dsmeta.setLore(dslores);

        dsmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        dsword.setItemMeta(dsmeta);

        contents.set(2, 2, ClickableItem.of(dsword,
                e -> {
                    val loadedUser = LoadedUser.USER_CACHE.getUnchecked(player.getUniqueId());
                    if (loadedUser.getCoins() >= 150) {
                        player.sendMessage("§fThe Pit §e> §aYou successfully buyed §eDiamond Sword§a!");
                        loadedUser.setCoins(loadedUser.getCoins() - 150);
                        ListenerHelper.setupscoreboard(player);

                        ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
                        ItemMeta meta = sword.getItemMeta();
                        meta.setDisplayName("§cDiamond Sword");
                        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        sword.setItemMeta(meta);

                        if(player.getInventory().contains(Material.IRON_SWORD)) {
                            player.getInventory().all(Material.IRON_SWORD).entrySet().stream().findFirst().ifPresent(entry -> player.getInventory().setItem(entry.getKey(), sword));
                        } else {
                            player.getInventory().addItem(sword);
                        }
                    } else {
                        player.sendMessage("§fThe Pit §e> §cYou don't have enough gold!");
                    }
                }));

        ////////////////////////////////////////////////////////////

        ItemStack dchest = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta dcmeta = dchest.getItemMeta();

        List<String> dclores = new ArrayList<>();

        dclores.add("§e");
        dclores.add("§fCost: §c250 §fgold");
        dclores.add("§7");
        dclores.add("§aClick to buy it!");

        dcmeta.setDisplayName("§cDiamond Chestplate");
        dcmeta.setLore(dclores);

        dcmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        dchest.setItemMeta(dcmeta);

        contents.set(2, 4, ClickableItem.of(dchest,
                e -> {
                    val loadedUser = LoadedUser.USER_CACHE.getUnchecked(player.getUniqueId());
                    if (loadedUser.getCoins() >= 250) {
                        player.sendMessage("§fThe Pit §e> §aYou successfully buyed §eDiamond Chestplate§a!");
                        loadedUser.setCoins(loadedUser.getCoins() - 250);
                        ListenerHelper.setupscoreboard(player);
                        ItemStack chest = new ItemStack(Material.DIAMOND_CHESTPLATE);
                        ItemMeta meta = chest.getItemMeta();
                        meta.setDisplayName("§cDiamond Chestplate");
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
                        player.sendMessage("§fThe Pit §e> §cYou don't have enough gold!");
                    }
                }));

        ////////////////////////////////////////////////////////////

        ItemStack dboots = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta dbmeta = dchest.getItemMeta();

        List<String> dblores = new ArrayList<>();

        dblores.add("§e");
        dblores.add("§fCost: §c100 §fgold");
        dblores.add("§7");
        dblores.add("§aClick to buy it!");

        dbmeta.setDisplayName("§cDiamond Boots");
        dbmeta.setLore(dblores);

        dbmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        dboots.setItemMeta(dbmeta);

        contents.set(2, 5, ClickableItem.of(dboots,
                e -> {
                    val loadedUser = LoadedUser.USER_CACHE.getUnchecked(player.getUniqueId());
                    if (loadedUser.getCoins() >= 100) {
                        player.sendMessage("§fThe Pit §e> §aYou successfully buyed §eDiamond Boots§a!");
                        loadedUser.setCoins(loadedUser.getCoins() - 100);
                        ListenerHelper.setupscoreboard(player);
                        ItemStack boots = new ItemStack(Material.DIAMOND_BOOTS);
                        ItemMeta meta = boots.getItemMeta();
                        meta.setDisplayName("§cDiamond Boots");
                        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        boots.setItemMeta(meta);
                        if(player.getInventory().contains(Material.IRON_BOOTS)) {
                            player.getInventory().all(Material.IRON_BOOTS).entrySet().stream().findFirst().ifPresent(entry -> player.getInventory().setItem(entry.getKey(), boots));
                        } else if(player.getInventory().getBoots().equals(new ItemStack(Material.CHAINMAIL_BOOTS))) {
                            player.getInventory().setBoots(boots);
                        } else if(player.getInventory().getBoots().equals(new ItemStack(Material.IRON_BOOTS))) {
                            player.getInventory().setBoots(boots);
                        } else if(player.getInventory().contains(Material.CHAINMAIL_BOOTS)) {
                            player.getInventory().all(Material.CHAINMAIL_BOOTS).entrySet().stream().findFirst().ifPresent(entry -> player.getInventory().setItem(entry.getKey(), boots));
                        } else {
                            player.getInventory().addItem(boots);
                        }

                    } else {
                        player.sendMessage("§fThe Pit §e> §cYou don't have enough gold!");
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
