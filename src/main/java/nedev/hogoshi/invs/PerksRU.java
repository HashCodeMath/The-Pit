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

public class PerksRU implements InventoryProvider {
    public static final SmartInventory INVENTORY = SmartInventory.builder()
            .id("myInventory")
            .provider(new PerksRU())
            .size(6, 9)
            .title("§9Магазин навыков")
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
        dslores.add("§fСтоимость: §91000 §fзолота");
        dslores.add("§7");
        dslores.add("§fВы получаете удочку.");
        dslores.add("§7");
        if(loadedUserr.getCurrentperk() == 1) {
            dslores.add("§aИспользуется!");
        }
        if(loadedUserr.isFishingrod() && loadedUserr.getCurrentperk() != 1) {
            dslores.add("§aНажмите, что бы выбрать!");
        }
        if(!loadedUserr.isFishingrod() && loadedUserr.getCurrentperk() != 1) {
            dslores.add("§aНажмите, что бы купить!");
        }

        dsmeta.setDisplayName("§9Рыбак");
        dsmeta.setLore(dslores);

        dsmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        dsword.setItemMeta(dsmeta);

        contents.set(2, 2, ClickableItem.of(dsword,
                e -> {
                    val loadedUser = LoadedUser.USER_CACHE.getUnchecked(player.getUniqueId());

                    if(loadedUser.getCurrentperk() != 1) {
                        if(!loadedUser.isFishingrod()) {
                            if(loadedUser.getCoins() >= 1000) {
                                player.sendMessage("§fThe Pit §e> §aВы успешно купили навык §eРыбак§a!");
                                loadedUser.setCoins(loadedUser.getCoins() - 1000);
                                ListenerHelper.setupscoreboard(player);
                                player.closeInventory();
                                PerksRU.INVENTORY.open(player);

                                loadedUser.setFishingrod(true);
                            } else {
                                player.sendMessage("§fThe Pit §e> §cУ вас недостаточно золота!");
                            }
                        } else {
                            player.sendMessage("§fThe Pit §e> §aВы успешно выбрали навык §eРыбак§a!");
                            loadedUser.setCurrentperk(1);
                            player.closeInventory();
                            PerksRU.INVENTORY.open(player);
                            player.getInventory().addItem(new ItemStack(Material.FISHING_ROD));
                            player.getInventory().all(Material.LAVA_BUCKET).entrySet().stream().findAny().ifPresent(entry -> player.getInventory().setItem(entry.getKey(), new ItemStack(Material.AIR)));
                        }
                    } else {
                        player.sendMessage("§fThe Pit §e> §aВы уже выбрали навык §eРыбак§a!");
                        player.closeInventory();
                        PerksRU.INVENTORY.open(player);
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
        dclores.add("§fСтоимость: §e1500 §fзолота");
        dclores.add("§7");
        dclores.add("§fВместо золотых яблок вы получаете");
        dclores.add("§fЗолотую голову, дающую регенерацию 1 и скорость.");
        dclores.add("§7");
        if(loadedUserr.getCurrentperk() == 2) {
            dclores.add("§aИспользуется!");
        }
        if(loadedUserr.isGoldenhead() && loadedUserr.getCurrentperk() != 2) {
            dclores.add("§aНажмите, что бы выбрать!");
        }
        if(!loadedUserr.isGoldenhead() && loadedUserr.getCurrentperk() != 2) {
            dclores.add("§aНажмите, что бы купить!");
        }

        meta.setDisplayName("§eЗолотые головы");
        meta.setLore(dclores);

        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        random.setItemMeta(meta);

        contents.set(2, 3, ClickableItem.of(random,
                e -> {
                    val loadedUser = LoadedUser.USER_CACHE.getUnchecked(player.getUniqueId());

                    if(loadedUser.getCurrentperk() != 2) {
                        if(!loadedUser.isGoldenhead()) {
                            if(loadedUser.getCoins() >= 1500) {
                                player.sendMessage("§fThe Pit §e> §aВы успешно купили навык §eЗолотые головы§a!");
                                loadedUser.setCoins(loadedUser.getCoins() - 1500);
                                ListenerHelper.setupscoreboard(player);

                                player.closeInventory();
                                PerksRU.INVENTORY.open(player);

                                loadedUser.setGoldenhead(true);
                            } else {
                                player.sendMessage("§fThe Pit §e> §cУ вас недостаточно золота!");
                            }
                        } else {
                            player.sendMessage("§fThe Pit §e> §aВы успешно выбрали навык §eЗолотые головы§a!");
                            loadedUser.setCurrentperk(2);
                            player.closeInventory();
                            PerksRU.INVENTORY.open(player);
                            player.getInventory().all(Material.LAVA_BUCKET).entrySet().stream().findAny().ifPresent(entry -> player.getInventory().setItem(entry.getKey(), new ItemStack(Material.AIR)));
                            player.getInventory().all(Material.FISHING_ROD).entrySet().stream().findAny().ifPresent(entry -> player.getInventory().setItem(entry.getKey(), new ItemStack(Material.AIR)));
                        }
                    } else {
                        player.sendMessage("§fThe Pit §e> §aВы уже выбрали навык §eЗолотые головы§a!");
                        player.closeInventory();
                        PerksRU.INVENTORY.open(player);
                    }
                }));

        ////////////////////////////////////////////////////////////

        ItemStack dboots = new ItemStack(Material.LAVA_BUCKET);
        ItemMeta dbmeta = dboots.getItemMeta();

        List<String> dblores = new ArrayList<>();

        dblores.add("§e");
        dblores.add("§fСтоимость: §c2000 §fзолота");
        dblores.add("§7");
        if(loadedUserr.getCurrentperk() == 3) {
            dblores.add("§aИспользуется!");
        }
        if(loadedUserr.isLavabukkit() && loadedUserr.getCurrentperk() != 3) {
            dblores.add("§aНажмите, что бы выбрать!");
        }
        if(!loadedUserr.isLavabukkit() && loadedUserr.getCurrentperk() != 3) {
            dblores.add("§aНажмите, что бы купить!");
        }

        dbmeta.setDisplayName("§cВедро лавы");
        dbmeta.setLore(dblores);

        dbmeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        dboots.setItemMeta(dbmeta);

        contents.set(2, 4, ClickableItem.of(dboots,
                e -> {
                    val loadedUser = LoadedUser.USER_CACHE.getUnchecked(player.getUniqueId());

                    if(loadedUser.getCurrentperk() != 3) {
                        if(!loadedUser.isLavabukkit()) {
                            if(loadedUser.getCoins() >= 2000) {
                                player.sendMessage("§fThe Pit §e> §aВы успешно купили навык §eВедро лавы§a!");
                                loadedUser.setCoins(loadedUser.getCoins() - 2000);
                                ListenerHelper.setupscoreboard(player);

                                loadedUser.setLavabukkit(true);
                                player.closeInventory();
                                PerksRU.INVENTORY.open(player);
                            } else {
                                player.sendMessage("§fThe Pit §e> §cУ вас недостаточно золота!");
                            }
                        } else {
                            player.sendMessage("§fThe Pit §e> §aВы успешно выбрали навык §eВедро лавы§a!");
                            loadedUser.setCurrentperk(3);
                            player.closeInventory();
                            PerksRU.INVENTORY.open(player);
                            player.getInventory().addItem(new ItemStack(Material.LAVA_BUCKET));
                            player.getInventory().all(Material.FISHING_ROD).entrySet().stream().findAny().ifPresent(entry -> player.getInventory().setItem(entry.getKey(), new ItemStack(Material.AIR)));
                        }
                    } else {
                        player.sendMessage("§fThe Pit §e> §aВы уже выбрали навык §eВедро лавы§a!");
                        player.closeInventory();
                        PerksRU.INVENTORY.open(player);
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
