package me.pugly.launchpads;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

public class Events implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Location to = e.getTo();
        Location from = e.getFrom();

        if (to.getBlockX() == from.getBlockX() && to.getBlockZ() == from.getBlockZ() && to.getBlockY() == from.getBlockY()) {
            return;
        }

        if (e.getTo().getBlock().getType().equals(Material.LIGHT_WEIGHTED_PRESSURE_PLATE)) {


            e.getPlayer().setVelocity(e.getPlayer().getVelocity().add(new Vector(
                    e.getTo().getDirection().getX()*2, 1.1, e.getTo().getDirection().getZ()*2
            )));

            e.getPlayer().playSound(e.getTo(), Sound.ENTITY_GENERIC_EXPLODE, 90, 1);
            e.getPlayer().spawnParticle(Particle.EXPLOSION_LARGE, e.getTo().getBlock().getLocation(), 1);
        }
    }

}
