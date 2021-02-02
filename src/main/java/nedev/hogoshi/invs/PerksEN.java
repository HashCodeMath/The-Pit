package nedev.hogoshi.invs;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import lombok.val;
import nedev.hogoshi.listener.ListenerHelper;
import nedev.hogoshi.mysql.LoadedUser;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PerksEN implements InventoryProvider {
    public static final SmartInventory INVENTORY = SmartInventory.builder()
            .id("myInventory")
            .provider(new PerksEN())
            .size(6, 9)
            .title("§9Perks shop")
            .build();

    private final Random random = new Random();

    @Override
    public void init(Player player, InventoryContents contents) {
        val loadedUserr = LoadedUser.USER_CACHE.getUnchecked(player.getUniqueId());

        contents.fillBorders(ClickableItem.empty(new ItemStack(Material.STAINED_GLASS_PANE)));

        ItemStack dsword = new ItemStack(Material.FISHING_ROD);
        ItemMeta dsmeta = dsword.getItemMeta();

        List<String> dslores = new ArrayList<>();

        dslores.add("§e");
        dslores.add("§fCost: §e1000 §fgold");
        dslores.add("§7");
        dslores.add("§fYou getting the fishing rod.");
        dslores.add("§7");
        if(loadedUserr.getCurrentperk() == 1) {
            dslores.add("§aUsing!");
        }
        if(loadedUserr.isFishingrod() && loadedUserr.getCurrentperk() != 1) {
            dslores.add("§aClick to choose!");
        }
        if(!loadedUserr.isFishingrod() && loadedUserr.getCurrentperk() != 1) {
            dslores.add("§aClick to buy it!");
        }

        dsmeta.setDisplayName("§9Fisherman");
        dsmeta.setLore(dslores);

        dsmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        dsword.setItemMeta(dsmeta);

        contents.set(2, 2, ClickableItem.of(dsword,
                e -> {
                    val loadedUser = LoadedUser.USER_CACHE.getUnchecked(player.getUniqueId());

                    if(loadedUser.getCurrentperk() != 1) {
                        if(!loadedUser.isFishingrod()) {
                            if(loadedUser.getCoins() >= 1000) {
                                player.sendMessage("§fThe Pit §e> §aYou successfully buyed perk §eFisherman§a!");
                                loadedUser.setCoins(loadedUser.getCoins() - 1000);
                                ListenerHelper.setupscoreboard(player);
                                player.closeInventory();
                                PerksEN.INVENTORY.open(player);

                                loadedUser.setFishingrod(true);
                            } else {
                                player.sendMessage("§fThe Pit §e> §cYou don't have enough gold!");
                            }
                        } else {
                            player.sendMessage("§fThe Pit §e> §aYou successfully buyed perk §eFisherman§a!");
                            loadedUser.setCurrentperk(1);
                            player.closeInventory();
                            PerksEN.INVENTORY.open(player);
                            player.getInventory().addItem(new ItemStack(Material.FISHING_ROD));
                            player.getInventory().all(Material.LAVA_BUCKET).entrySet().stream().findAny().ifPresent(entry -> player.getInventory().setItem(entry.getKey(), new ItemStack(Material.AIR)));
                        }
                    } else {
                        player.sendMessage("§fThe Pit §e> §aYou already choosed §eFisherman§a!");
                        player.closeInventory();
                        PerksEN.INVENTORY.open(player);
                    }
                }));

        ////////////////////////////////////////////////////////////
        ItemStack random = new ItemStack(Material.SKULL_ITEM,1 , (byte)3);

        SkullMeta meta = (SkullMeta) random.getItemMeta();

        meta.setOwner(Bukkit.getOfflinePlayer("Increasen").getName());

        meta.setDisplayName("§eЗолотые головы");

        random.setItemMeta(meta);

        List<String> dclores = new ArrayList<>();

        dclores.add("§e");
        dclores.add("§fCost: §c1500 §fgold");
        dclores.add("§7");
        dclores.add("§fYou getting the");
        dclores.add("§fGolden head which will give regeneration 1 and speed 1 for 7 seconds");
        dclores.add("§7");
        if(loadedUserr.getCurrentperk() == 2) {
            dclores.add("§aUsing!");
        }
        if(loadedUserr.isGoldenhead() && loadedUserr.getCurrentperk() != 2) {
            dclores.add("§aClick to choose!");
        }
        if(!loadedUserr.isGoldenhead() && loadedUserr.getCurrentperk() != 2) {
            dclores.add("§aClick to buy it!");
        }

        meta.setDisplayName("§eGolden head");
        meta.setLore(dclores);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        random.setItemMeta(meta);

        contents.set(2, 3, ClickableItem.of(random,
                e -> {
                    val loadedUser = LoadedUser.USER_CACHE.getUnchecked(player.getUniqueId());

                    if(loadedUser.getCurrentperk() != 2) {
                        if(!loadedUser.isGoldenhead()) {
                            if(loadedUser.getCoins() >= 1500) {
                                player.sendMessage("§fThe Pit §e> §aYou successfully buyed perk §eGolden head§a!");
                                loadedUser.setCoins(loadedUser.getCoins() - 1500);
                                ListenerHelper.setupscoreboard(player);

                                player.closeInventory();
                                PerksEN.INVENTORY.open(player);

                                loadedUser.setGoldenhead(true);
                            } else {
                                player.sendMessage("§fThe Pit §e> §cYou don't have enough gold!");
                            }
                        } else {
                            player.sendMessage("§fThe Pit §e> §aYou successfully choosed §eGolden head§a!");
                            loadedUser.setCurrentperk(2);
                            player.closeInventory();
                            PerksEN.INVENTORY.open(player);
                            player.getInventory().all(Material.LAVA_BUCKET).entrySet().stream().findAny().ifPresent(entry -> player.getInventory().setItem(entry.getKey(), new ItemStack(Material.AIR)));
                            player.getInventory().all(Material.FISHING_ROD).entrySet().stream().findAny().ifPresent(entry -> player.getInventory().setItem(entry.getKey(), new ItemStack(Material.AIR)));
                        }
                    } else {
                        player.sendMessage("§fThe Pit §e> §aYou already choosed §eGolden head§a!");
                        player.closeInventory();
                        PerksEN.INVENTORY.open(player);
                    }
                }));

        ////////////////////////////////////////////////////////////

        ItemStack dboots = new ItemStack(Material.LAVA_BUCKET);
        ItemMeta dbmeta = dboots.getItemMeta();

        List<String> dblores = new ArrayList<>();

        dblores.add("§e");
        dblores.add("§fCost: §c2000 §fgold");
        dblores.add("§7");
        if(loadedUserr.getCurrentperk() == 3) {
            dblores.add("§aUsing!");
        }
        if(loadedUserr.isLavabukkit() && loadedUserr.getCurrentperk() != 3) {
            dblores.add("§aClick to choose!");
        }
        if(!loadedUserr.isLavabukkit() && loadedUserr.getCurrentperk() != 3) {
            dblores.add("§aClick to buy it!");
        }

        dbmeta.setDisplayName("§cLava bucket");
        dbmeta.setLore(dblores);

        dbmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        dboots.setItemMeta(dbmeta);

        contents.set(2, 4, ClickableItem.of(dboots,
                e -> {
                    val loadedUser = LoadedUser.USER_CACHE.getUnchecked(player.getUniqueId());

                    if(loadedUser.getCurrentperk() != 3) {
                        if(!loadedUser.isLavabukkit()) {
                            if(loadedUser.getCoins() >= 2000) {
                                player.sendMessage("§fThe Pit §e> §aYou successfully buyed perk §eLava bucket§a!");
                                loadedUser.setCoins(loadedUser.getCoins() - 2000);
                                ListenerHelper.setupscoreboard(player);

                                loadedUser.setLavabukkit(true);
                                player.closeInventory();
                                PerksEN.INVENTORY.open(player);
                            } else {
                                player.sendMessage("§fThe Pit §e> §cYou don't have enough gold!");
                            }
                        } else {
                            player.sendMessage("§fThe Pit §e> §aYou successfully choosed §eLava bucket§a!");
                            loadedUser.setCurrentperk(3);
                            player.closeInventory();
                            PerksEN.INVENTORY.open(player);
                            player.getInventory().addItem(new ItemStack(Material.LAVA_BUCKET));
                            player.getInventory().all(Material.FISHING_ROD).entrySet().stream().findAny().ifPresent(entry -> player.getInventory().setItem(entry.getKey(), new ItemStack(Material.AIR)));
                        }
                    } else {
                        player.sendMessage("§fThe Pit §e> §aYou already choosed §eLava bucket§a!");
                        player.closeInventory();
                        PerksEN.INVENTORY.open(player);
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
