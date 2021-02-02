package nedev.hogoshi.listener;

import lombok.val;
import nedev.hogoshi.ThePit;
import nedev.hogoshi.mysql.LoadedUser;
import nedev.hogoshi.util.FormatingUtil;
import nedev.hogoshi.util.ProgressUtil;
import nedev.hogoshi.util.TextBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class APChatEvent implements Listener {

    @EventHandler
    public void c(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        if (!ListenerHelper.verified.get(p.getName())) {
            if (e.getMessage().equalsIgnoreCase(ListenerHelper.key)) {
                if (ThePit.getInstance().getConfig().getInt("Language") == 1) {
                    p.sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("Russian.Verified"));
                } else {
                    p.sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("English.Verified"));
                }
                ListenerHelper.verified.put(p.getName(), true);
                e.setCancelled(true);
            } else {
                ListenerHelper.generateKey();
                if (ThePit.getInstance().getConfig().getInt("Language") == 1) {
                    p.sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("Russian.NewVerifyCode").replaceAll("<code>", ListenerHelper.key));
                } else {
                    p.sendMessage(ThePit.messages.getString("Prefix") + ThePit.messages.getString("English.NewVerifyCode").replaceAll("<code>", ListenerHelper.key));
                }
                e.setCancelled(true);
            }
        } else {
            if (ThePit.getInstance().getConfig().getBoolean("ChatFormatting.enabled")) {
                val loadedUser = LoadedUser.USER_CACHE.getUnchecked(e.getPlayer().getUniqueId());

                if (ThePit.getInstance().getConfig().getInt("Language") == 1) {
                    if (loadedUser.getPrestige() >= 1) {
                        e.setCancelled(true);

                        TextBuilder builder = new TextBuilder(ThePit.getInstance().getConfig().getString("ChatFormatting.HavePrestige")
                                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + Integer.toString(loadedUser.getLevel()))
                                .replaceAll("<player>", e.getPlayer().getName())
                                .replaceAll("<message>", e.getMessage())
                                .replaceAll("<exp>", Integer.toString(loadedUser.getExp()))
                                .replaceAll("<prestige>", FormatingUtil.format(loadedUser.getPrestige())))
                                .setClickEvent(TextBuilder.ClickEventType.RUN_COMMAND, "/do " + p.getName())
                                .setHoverEvent(TextBuilder.HoverEventType.SHOW_TEXT, "§c➥ §fИнформация об §c" + p.getName() +
                                        "\n\n§fУровень: §c" + loadedUser.getLevel() +
                                        "\n§fОпыт: §c" + loadedUser.getExp() +
                                        "\n§fОпыта до следущего уровня: §c" +
                                        loadedUser.calculateExp() +
                                        "\n" + ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), 50, "|", "&c", ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")) +
                                        "\n§fЗолота: §c" + loadedUser.getCoins() +
                                        "\n§fУбийств: §c" + loadedUser.getKills() +
                                        "\n§fСмертей: §c" + loadedUser.getDeaths() +
                                        "\n\n§aНажмите, для совершения действий.")
                                .buildText();

                        Bukkit.getOnlinePlayers().forEach(builder::sendMessage);
                    } else {
                        e.setCancelled(true);

                        TextBuilder builder = new TextBuilder(ThePit.getInstance().getConfig().getString("ChatFormatting.NoPrestige")
                                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + Integer.toString(loadedUser.getLevel()))
                                .replaceAll("<player>", e.getPlayer().getName())
                                .replaceAll("<message>", e.getMessage())
                                .replaceAll("<exp>", Integer.toString(loadedUser.getExp())))
                                .setClickEvent(TextBuilder.ClickEventType.RUN_COMMAND, "/do " + p.getName())
                                .setHoverEvent(TextBuilder.HoverEventType.SHOW_TEXT, "§c➥ §fИнформация о §c" + p.getName() +
                                        "\n\n§fУровень: §c" + loadedUser.getLevel() +
                                        "\n§fОпыт: §c" + loadedUser.getExp() +
                                        "\n§fОпыта до следущего уровня: §c" +
                                        loadedUser.calculateExp() +
                                        "\n" + ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), 50, "|", "&c", ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")) +
                                        "\n§fЗолота: §c" + loadedUser.getCoins() +
                                        "\n§fУбийств: §c" + loadedUser.getKills() +
                                        "\n§fСмертей: §c" + loadedUser.getDeaths() +
                                        "\n\n§aНажмите, для совершения действий.")
                                .buildText();
                        Bukkit.getOnlinePlayers().forEach(builder::sendMessage);
                    }
                } else {
                    if (loadedUser.getPrestige() >= 1) {
                        e.setCancelled(true);

                        TextBuilder builder = new TextBuilder(ThePit.getInstance().getConfig().getString("ChatFormatting.HavePrestige")
                                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + Integer.toString(loadedUser.getLevel()))
                                .replaceAll("<player>", e.getPlayer().getName())
                                .replaceAll("<message>", e.getMessage())
                                .replaceAll("<exp>", Integer.toString(loadedUser.getExp()))
                                .replaceAll("<prestige>", FormatingUtil.format(loadedUser.getPrestige())))
                                .setClickEvent(TextBuilder.ClickEventType.RUN_COMMAND, "/do " + p.getName())
                                .setHoverEvent(TextBuilder.HoverEventType.SHOW_TEXT, "\n§c➥ §fInfo about §c" + p.getName() +
                                        "\n\n§fLevel: §c" + loadedUser.getLevel() +
                                        "\n§fExp: §c" + loadedUser.getExp() +
                                        "\n§fExp to next level: §c" +
                                        loadedUser.calculateExp() +
                                        "\n" + ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), 50, "|", "&c", ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")) +
                                        "\n§fGold: §c" + loadedUser.getCoins() +
                                        "\n§fKills: §c" + loadedUser.getKills() +
                                        "\n§fDeaths: §c" + loadedUser.getDeaths() +
                                        "\n\n§aClick to do something with this player.")
                                .buildText();

                        Bukkit.getOnlinePlayers().forEach(builder::sendMessage);
                    } else {
                        e.setCancelled(true);

                        TextBuilder builder = new TextBuilder(ThePit.getInstance().getConfig().getString("ChatFormatting.NoPrestige")
                                .replaceAll("<level>", ListenerHelper.coloredlevel.get(loadedUser.getLevel()) + Integer.toString(loadedUser.getLevel()))
                                .replaceAll("<player>", e.getPlayer().getName())
                                .replaceAll("<message>", e.getMessage())
                                .replaceAll("<exp>", Integer.toString(loadedUser.getExp())))
                                .setClickEvent(TextBuilder.ClickEventType.RUN_COMMAND, "/do " + p.getName())
                                .setHoverEvent(TextBuilder.HoverEventType.SHOW_TEXT, "\n§c➥ §fInfo about §c" + p.getName() +
                                        "\n\n§fLevel: §c" + loadedUser.getLevel() +
                                        "\n§fExp: §c" + loadedUser.getExp() +
                                        "\n§fExp to next level: §c" +
                                        loadedUser.calculateExp() +
                                        "\n" + ProgressUtil.getProgressBar(loadedUser.getExp(), loadedUser.calculateExp(), 50, "|", "&c", ThePit.getInstance().getConfig().getString("Indicator.NotCompletedColor")) +
                                        "\n§fGold: §c" + loadedUser.getCoins() +
                                        "\n§fKills: §c" + loadedUser.getKills() +
                                        "\n§fDeaths: §c" + loadedUser.getDeaths() +
                                        "\n\n§aClick to do something with this player.")
                                .buildText();
                        Bukkit.getOnlinePlayers().forEach(builder::sendMessage);
                    }
                }
            }
        }
    }

}
