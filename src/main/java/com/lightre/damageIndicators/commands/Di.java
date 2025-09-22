package com.lightre.damageIndicators.commands;

import com.lightre.damageIndicators.DamageIndicators;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public record Di(DamageIndicators plugin) implements CommandExecutor, TabCompleter {

    // onCommand
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§eUsage: /di <toggle|reload>");
            return true;
        }
        String subCommand = args[0].toLowerCase();
        if (subCommand.equals("toggle")) {
            if (!sender.hasPermission("damageindicators.toggle")) {
                sender.sendMessage("§cYou do not have permission to use this command!");
                return true;
            }
            boolean newState = !plugin.isIndicatorsEnabled();
            plugin.setIndicatorsEnabled(newState);
            if (newState) {
                sender.sendMessage("§aDamage Indicators Enabled.");
            } else {
                sender.sendMessage("§cDamage Indicators Disabled.");
            }
        } else if (subCommand.equals("reload")) {
            if (!sender.hasPermission("damageindicators.reload")) {
                sender.sendMessage("§cYou do not have permission to use this command!");
                return true;
            }
            plugin.reloadConfiguration();
            sender.sendMessage("§aDamageIndicators config file reloaded!");
        } else {
            sender.sendMessage("§cUsage: §7/di §e<toggle|reload>");
        }
        return true;
    }

    // --- AUTOFILL ---
    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            List<String> completions = new ArrayList<>();

            if (sender.hasPermission("damageindicators.toggle")) {
                completions.add("toggle");
            }
            if (sender.hasPermission("damageindicators.reload")) {
                completions.add("reload");
            }

            return StringUtil.copyPartialMatches(args[0], completions, new ArrayList<>());
        }

        return new ArrayList<>();
    }
}

// Developed by Lightre