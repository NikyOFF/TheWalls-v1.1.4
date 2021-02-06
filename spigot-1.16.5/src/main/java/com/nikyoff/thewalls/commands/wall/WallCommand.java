package com.nikyoff.thewalls.commands.wall;

import com.nikyoff.thewalls.Main;
import com.nikyoff.thewalls.core.Wall;
import com.nikyoff.thewalls.utils.Adapter;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.regions.Region;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WallCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (Main.Singleton.MapManager.CurrentMap != null) {
            if (args[0].equals(WallCommandActions.add.name())) {
                if (sender instanceof Player) {
                    if (args.length == 2) {
                        String id = args[1];
                        Region region = Adapter.GetWorldEditRegion((com.sk89q.worldedit.entity.Player) BukkitAdapter.adapt(sender));

                        if (region == null) {
                            return false;
                        }

                        Main.Singleton.WallManager.Add(new Wall(id, Adapter.Adapt(((Player) sender).getWorld(), region.getMinimumPoint()), Adapter.Adapt(((Player) sender).getWorld(), region.getMaximumPoint())));
                        return true;
                    } else if (args.length == 8) {
                        World world = ((Player) sender).getWorld();
                        String id = args[1];
                        Location pos0 = new Location(world, Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]));
                        Location pos1 = new Location(world, Double.parseDouble(args[5]), Double.parseDouble(args[6]), Double.parseDouble(args[7]));

                        Main.Singleton.WallManager.Add(new Wall(id, pos0, pos1));
                        return true;
                    }
                }
            } else if (args[0].equals(WallCommandActions.remove.name())) {
                if (args.length == 2 && sender instanceof Player) {
                    String id = args[1];
                    Main.Singleton.WallManager.Remove(id);
                    return true;
                }
            } else if (args[0].equals(WallCommandActions.create.name())) {
                if (args.length == 3 && sender instanceof Player) {
                    String id = args[1];
                    boolean isFallen = args[2].equals("true");
                    Wall wall = Main.Singleton.WallManager.Get(id);

                    if (wall != null) {
                        wall.Create(isFallen);
                        return true;
                    }
                }
            } else if (args[0].equals(WallCommandActions.save.name())) {
                if (args.length == 3 && sender instanceof Player) {
                    String id = args[1];
                    boolean isFallen = args[2].equals("true");
                    Wall wall = Main.Singleton.WallManager.Get(id);

                    if (wall != null) {
                        wall.Save(isFallen);
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
