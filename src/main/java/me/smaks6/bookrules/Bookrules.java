package me.smaks6.bookrules;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Bookrules extends JavaPlugin {

    private static Bookrules instance;
    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("Plugin enable");
        new cmd(this);
        List<String> rules = new ArrayList<>();
        rules.add("Rules");
        rules.add("1. Rules is rules");
        getConfig().addDefault("rules", rules);
        getConfig().options().copyDefaults(true);
        saveConfig();
        reloadConfig();
    }

    public static Bookrules getInstance() {
        return instance;
    }
}
