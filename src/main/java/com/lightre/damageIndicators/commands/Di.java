package com.lightre.damageIndicators.commands;

import com.lightre.damageIndicators.DamageIndicators;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public record Di(DamageIndicators plugin) implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§eUsage: /di <toggle|reload|help>");
            return true;
        }

        String subCommand = args[0].toLowerCase();

        if (subCommand.equals("toggle")) {
            if (!sender.hasPermission("damageindicators.toggle")) {
                sender.sendMessage("§cYou do not have permission to use this command!");
                return true;
            }

            boolean currentState = plugin.getConfig().getBoolean("enabled");

            boolean newState = !currentState;

            plugin.getConfig().set("enabled", newState);
            plugin.saveConfig();
            plugin.reloadConfiguration();

            if (newState) {
                sender.sendMessage("§aDamage Indicators have been enabled.");
            } else {
                sender.sendMessage("§cDamage Indicators have been disabled.");
            }
        } else if (subCommand.equals("reload")) {
            if (!sender.hasPermission("damageindicators.reload")) {
                sender.sendMessage("§cYou do not have permission to use this command!");
                return true;
            }
            plugin.reloadConfiguration();
            sender.sendMessage("§aDamageIndicators config file reloaded!");

            // 'help' subcommand
        } else if (subCommand.equals("help")) {
            if (!sender.hasPermission("damageindicators.help")) {
                sender.sendMessage("§cYou do not have permission to use this command!");
                return true;
            }

            // get plugin information from plugin.yml
            PluginDescriptionFile desc = plugin.getDescription();
            String authors = String.join(", ", desc.getAuthors());

            sender.sendMessage("§8§m----------------------------------");
            sender.sendMessage(" §e" + desc.getName() + " §7v" + desc.getVersion());
            sender.sendMessage(" §7Created by: §b" + authors);
            sender.sendMessage(""); // spacer
            sender.sendMessage(" §7Available Commands:");
            sender.sendMessage(" §e/di help   §8- §7Displays this help message.");
            sender.sendMessage(" §e/di reload §8- §7Reloads the configuration file.");
            sender.sendMessage(" §e/di toggle §8- §7Toggles indicators on or off.");
            sender.sendMessage("§8§m----------------------------------");

        } else {
            sender.sendMessage("§cUnknown command. Usage: §7/di §e<toggle|reload|help>");
        }
        return true;
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 1) {
            List<String> completions = new ArrayList<>();

            if (sender.hasPermission("damageindicators.help")) {
                completions.add("help");
            }
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