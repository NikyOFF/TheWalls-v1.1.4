package com.nikyoff.thewalls.utils;

import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.entity.Player;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.Region;
import org.bukkit.Location;
import org.bukkit.World;

import java.math.BigDecimal;

public class Adapter {
    public static Location Adapt(World world, BlockVector3 blockVector3) {
        return new Location(world, blockVector3.getBlockX(), blockVector3.getBlockY(), blockVector3.getBlockZ());
    }

    public static Region GetWorldEditRegion(Player player) {
        LocalSession session = WorldEdit.getInstance().getSessionManager().get(player);
        return session.getSelection(player.getWorld());
    }

    public static String LocationToString(Location location) {
        return "x: " + BigDecimal.valueOf(location.getX()).setScale(2, BigDecimal.ROUND_DOWN) + ", y: " + BigDecimal.valueOf(location.getY()).setScale(2, BigDecimal.ROUND_DOWN) + ", z: " + BigDecimal.valueOf(location.getZ()).setScale(2, BigDecimal.ROUND_DOWN);
    }
}
