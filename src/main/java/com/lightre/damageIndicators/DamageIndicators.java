package com.lightre.damageIndicators;

import com.lightre.damageIndicators.commands.Di;
import com.lightre.damageIndicators.listeners.EntityDamage;
import org.bukkit.ChatColor;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class DamageIndicators extends JavaPlugin {
    private boolean indicatorsEnabled;

    private String indicatorPrefix;
    private String criticalIndicatorPrefix;
    private long indicatorDurationTicks;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        loadConfigValues();
        getCommand("di").setExecutor(new Di(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("DamageIndicators has been disabled!");
    }

    public void reloadConfiguration() {
        this.reloadConfig();
        loadConfigValues();
    }

    private void loadConfigValues() {
        HandlerList.unregisterAll(this);

        this.indicatorsEnabled = getConfig().getBoolean("enabled");

        if (this.indicatorsEnabled) {
            getServer().getPluginManager().registerEvents(new EntityDamage(this), this);
            getLogger().info("Indicators are ENABLED.");
        } else {
            getLogger().info("Indicators are DISABLED in config.yml.");
        }

        // Load Normal Prefix
        if (getConfig().isString("indicator-prefix")) {
            this.indicatorPrefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("indicator-prefix"));
        } else {
            getLogger().warning("'indicator-prefix' is missing or invalid in the config! Default value '&c❤ ' will be used.");
            this.indicatorPrefix = "§c❤ ";
        }

        // Load Critical Prefix
        if (getConfig().isString("critical-indicator-prefix")) {
            this.criticalIndicatorPrefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("critical-indicator-prefix"));
        } else {
            getLogger().warning("'critical-indicator-prefix' is missing or invalid in the config! Default value '&e✯ ' will be used.");
            this.criticalIndicatorPrefix = "§e✯ ";
        }

        // Load Lifetime
        if (getConfig().isDouble("indicator-duration-seconds") || getConfig().isInt("indicator-duration-seconds")) {
            this.indicatorDurationTicks = (long) (getConfig().getDouble("indicator-duration-seconds") * 20);
        } else {
            getLogger().warning("'indicator-duration-seconds' is missing or invalid in the config! Default value '2.0' will be used.");
            this.indicatorDurationTicks = 40L;
        }
    }
    public String getCriticalIndicatorPrefix() { return criticalIndicatorPrefix; }
    public String getIndicatorPrefix() { return indicatorPrefix; }
    public long getIndicatorDurationTicks() { return indicatorDurationTicks; }
    public boolean isIndicatorsEnabled() { return indicatorsEnabled; }
    public void setIndicatorsEnabled(boolean indicatorsEnabled) { this.indicatorsEnabled = indicatorsEnabled; }
}

// Developed by Lightre