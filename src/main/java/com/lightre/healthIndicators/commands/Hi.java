package com.lightre.healthIndicators.commands;

import com.lightre.healthIndicators.HealthIndicators;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public record Hi(HealthIndicators plugin) implements CommandExecutor, TabCompleter {

    // onCommand
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§eUsage: /hi <toggle|reload>");
            return true;
        }
        String subCommand = args[0].toLowerCase();
        if (subCommand.equals("toggle")) {
            if (!sender.hasPermission("healthindicators.toggle")) {
                sender.sendMessage("§cYou do not have permission to use this command!");
                return true;
            }
            boolean newState = !plugin.isIndicatorsEnabled();
            plugin.setIndicatorsEnabled(newState);
            if (newState) {
                sender.sendMessage("§aHealth Indicators Enabled.");
            } else {
                sender.sendMessage("§cHealth Indicators Disabled.");
            }
        } else if (subCommand.equals("reload")) {
            if (!sender.hasPermission("healthindicators.reload")) {
                sender.sendMessage("§cYou do not have permission to use this command!");
                return true;
            }
            plugin.reloadConfiguration();
            sender.sendMessage("§aHealthIndicators config file reloaded!");
        } else {
            sender.sendMessage("§cUsage: §7/hi §e<toggle|reload>");
        }
        return true;
    }

    // --- AUTOFILL ---
    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            List<String> completions = new ArrayList<>();

            if (sender.hasPermission("healthindicators.toggle")) {
                completions.add("toggle");
            }
            if (sender.hasPermission("healthindicators.reload")) {
                completions.add("reload");
            }

            return StringUtil.copyPartialMatches(args[0], completions, new ArrayList<>());
        }

        return new ArrayList<>();
    }
}

// Developed by Lightre