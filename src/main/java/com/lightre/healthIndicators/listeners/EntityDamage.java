package com.lightre.healthIndicators.listeners;

import com.lightre.healthIndicators.HealthIndicators;
import net.kyori.adventure.text.Component;
import org.bukkit.Location;
import org.bukkit.entity.Display.Billboard;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.TextDisplay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.util.Vector;

import java.util.concurrent.ThreadLocalRandom;

public record EntityDamage(HealthIndicators plugin) implements Listener {

    @EventHandler
    public void onEntityDamageEvent(EntityDamageEvent event) {
        if (!plugin.isIndicatorsEnabled() || event.getFinalDamage() < 0.1) {
            return;
        }

        Entity victim = event.getEntity();
        double damage = event.getFinalDamage();
        String formattedDamage = String.format("%.1f", damage);
        long durationInTicks = plugin.getIndicatorDurationTicks();

        String prefix;
        Location baseLocation;

        if (event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent entityEvent = (EntityDamageByEntityEvent) event;
            Entity damager = entityEvent.getDamager();

            // if the hit’s crit, use the crit prefix. if not, just use the normal one
            if (entityEvent.isCritical()) {
                prefix = plugin.getCriticalIndicatorPrefix();
            } else {
                prefix = plugin.getIndicatorPrefix();
            }

            if (damager instanceof Projectile) {
                Projectile projectile = (Projectile) damager;
                if (projectile.getShooter() instanceof Entity) {
                    damager = (Entity) projectile.getShooter();
                }
            }

            Vector direction = victim.getLocation().toVector().subtract(damager.getLocation().toVector()).normalize();
            baseLocation = victim.getLocation()
                    .add(0, victim.getHeight() / 2, 0)
                    .add(direction.multiply(-0.8));

        } else {
            prefix = plugin.getIndicatorPrefix();
            baseLocation = victim.getLocation().add(
                    ThreadLocalRandom.current().nextDouble(-1.0, 1.0),
                    0.5 + ThreadLocalRandom.current().nextDouble(0.0, 1.0),
                    ThreadLocalRandom.current().nextDouble(-1.0, 1.0)
            );
        }

        Component damageText = Component.text(prefix + formattedDamage);

        double spread = 0.5;
        Location finalSpawnLocation = baseLocation.add(
                ThreadLocalRandom.current().nextDouble(-spread, spread),
                ThreadLocalRandom.current().nextDouble(-spread, spread),
                ThreadLocalRandom.current().nextDouble(-spread, spread)
        );

        victim.getWorld().spawn(finalSpawnLocation, TextDisplay.class, indicator -> {
            indicator.text(damageText);
            indicator.setBillboard(Billboard.CENTER);
            indicator.setShadowed(true);
            plugin.getServer().getScheduler().runTaskLater(plugin, indicator::remove, durationInTicks);
        });
    }
}

// Developed by Lightre and Fists