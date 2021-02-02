package nedev.hogoshi.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileUtil {

    private YamlConfiguration yaml;
    private File config;

    public FileUtil(String name, String path) {
        new File(path).mkdirs();
        this.config = new File(path + "/", name + ".yml");
        if (!this.config.exists()) {
            try {
                this.config.createNewFile();
            } catch (IOException e) {
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&fTNTTag &e> &cError when creating the file: " + name + ".yml"));
                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&fTNTTag &e> &c" + e.getMessage()));
            }
        }

        this.yaml = YamlConfiguration.loadConfiguration(this.config);

    }

    public void reload() {
        this.yaml = YamlConfiguration.loadConfiguration(this.config);
    }

    public boolean fileExists() {
        return this.config.exists();
    }

    public void save() {
        try {
            this.yaml.save(this.config);
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&fTNTTag &e> &cError when creating the file: " + this.config.getName() + ".yml"));
            Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&fTNTTag &e> &c" + e.getMessage()));
        }
    }

    public void set(String label, Object String) {
        this.yaml.set(label, String);
        this.save();
    }

    public void setStrings(String label, String... String) {
        this.yaml.set(label, String);
    }

    public boolean contains(String whatContains) {
        return this.yaml.contains(whatContains);
    }

    public List<String> getStringList(String s) {
        ArrayList<String> var1 = new ArrayList<String>();
        Iterator<?> var2 = this.yaml.getStringList(s).iterator();

        while (var2.hasNext()) {
            String var3 = (String) var2.next();
            var1.add(ChatColor.translateAlternateColorCodes('&', var3));
        }
        return var1;
    }

    public String getString(String s) {
        return ChatColor.translateAlternateColorCodes('&', this.yaml.getString(s));
    }


    public double getDouble(String s) {
        return this.yaml.getDouble(s);
    }

    public Location getLocation(String loc) {
        return new Location(Bukkit.getWorld(this.getString(loc + ".World")),
                this.getDouble(loc + ".X"), this.getDouble(loc + ".Y"),
                this.getDouble(loc + ".Z"),
                (float) this.getDouble(loc + ".Yaw"),
                (float) this.getDouble(loc + ".Pitch"));
    }

    public void addDefault(String s, Object o) {
        this.yaml.addDefault(s, o);
    }

    public void copyDefaults(boolean what) {
        this.yaml.options().copyDefaults(what);
    }

    public int getInt(String integer) {
        return this.yaml.getInt(integer);
    }

    public ConfigurationSection getConfigurationSection(String s) {
        return this.yaml.getConfigurationSection(s);
    }

    public Object getObject(String s) {
        return this.yaml.get(s);
    }

}
