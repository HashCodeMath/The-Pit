package nedev.hogoshi.util;

import nedev.hogoshi.ThePit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class VersionUtil {

    public static void versionChecker() {
        try {
            String c = Randomizer.generateRandomKey(5000);

            HttpURLConnection connection = (HttpURLConnection) new URL("https://api.spigotmc.org/legacy/update.php?key=" + c + "&resource=soon").openConnection();
            connection.setDoOutput(true);
            String version = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine();
            if (version.equals(Settings.versionstring)) {
                if (ThePit.getInstance().getConfig().getInt("Language") == 0) {
                    ThePit.getInstance().getServer().getConsoleSender().sendMessage("§fThe Pit §e> §cPlease the set language in configuration!");
                } else if (ThePit.getInstance().getConfig().getInt("Language") == 1) {
                    ThePit.getInstance().getServer().getConsoleSender().sendMessage("§fThe Pit §e> §aБольшое спасибо за использование нашей новейшей версии!");
                    ThePit.getInstance().getServer().getConsoleSender().sendMessage("§fThe Pit §e> §aВаша версия плагина: §e" + Settings.versionstring);
                    ThePit.getInstance().getServer().getConsoleSender().sendMessage("§fThe Pit §e> §aНужная версия: §e" + version);
                } else if (ThePit.getInstance().getConfig().getInt("Language") == 2) {
                    ThePit.getInstance().getServer().getConsoleSender().sendMessage("§fThe Pit §e> §aBig thanks for using latest version of the plugin!");
                    ThePit.getInstance().getServer().getConsoleSender().sendMessage("§fThe Pit §e> §aCurrent version: §e" + Settings.versionstring);
                    ThePit.getInstance().getServer().getConsoleSender().sendMessage("§fThe Pit §e> §aLatest Version: §e" + version);
                } else {
                    ThePit.getInstance().getServer().getConsoleSender().sendMessage("§fThe Pit §e> §cPlease the set language in configuration!");
                }
            } else {
                if (ThePit.getInstance().getConfig().getInt("Language") == 0) {
                    ThePit.getInstance().getServer().getConsoleSender().sendMessage("§fThe Pit §e> §cPlease the set language in configuration!");
                } else if (ThePit.getInstance().getConfig().getInt("Language") == 1) {
                    ThePit.getInstance().getServer().getConsoleSender().sendMessage("§fThe Pit §e> §cОшибка: Вы используете устаревшую версию плагина! Ваша версия: §e" + Settings.versionstring + "§c, Требуемая версия: §e" + version);
                    ThePit.getInstance().getServer().getConsoleSender().sendMessage("§fThe Pit §e> §cМы заботимся о наших игроках и пользователях, поэтому что бы вы были заинтересованы в обновлении, мы отключили плагин!");
                    ThePit.getInstance().getServer().getConsoleSender().sendMessage("§fThe Pit §e> §cСкачать последнюю версию плагина можно здесь:");
                    ThePit.getInstance().getServer().getConsoleSender().sendMessage("§fThe Pit §e> §ehttps://www.spigotmc.org/resources/soon/");
                } else if (ThePit.getInstance().getConfig().getInt("Language") == 2) {
                    ThePit.getInstance().getServer().getConsoleSender().sendMessage("§fThe Pit §e> §cError: You are using an outdated plugin version! Your current version: §e" + Settings.versionstring + "§c, Latest version: §e" + version);
                    ThePit.getInstance().getServer().getConsoleSender().sendMessage("§fThe Pit §e> §cWe are love our users and we love they, because it, we disabled plugin!");
                    ThePit.getInstance().getServer().getConsoleSender().sendMessage("§fThe Pit §e> §cDownload latest version here:");
                    ThePit.getInstance().getServer().getConsoleSender().sendMessage("§fThe Pit §e> §ehttps://www.spigotmc.org/resources/soon/");
                } else {
                    ThePit.getInstance().getServer().getConsoleSender().sendMessage("§fThe Pit §e> §cPlease the set language in configuration!");
                }
            }
        } catch (IOException e) {
        }
    }

}
