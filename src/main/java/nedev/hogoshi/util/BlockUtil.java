package nedev.hogoshi.util;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class BlockUtil {

    public static ArrayList<Block> getBlocksBelow(Player player, World world){
        ArrayList<Block> blocksBelow = new ArrayList<Block>();
        Location location = player.getLocation();
        double x = location.getX();
        double z = location.getZ();

        // Add the block below the player to the List.
        Location block = new Location(world, x, location.getY() - 1, z);
        blocksBelow.add(block.getBlock());

        // If the player is on the edge of the block, add the necessary blocks to the List.
        if(x - Math.floor(x) <= 0.3){
            block.setX(Math.floor(x) - 0.5);
            blocksBelow.add(block.getBlock());
            block = new Location(world, x, location.getY() - 1, z);
        } else if(x - Math.floor(x) >= 0.7){
            block.setX(Math.ceil(x) + 0.5);
            blocksBelow.add(block.getBlock());
            block = new Location(world, x, location.getY() - 1, z);
        }

        if(z - Math.floor(z) <= 0.3){
            block.setZ(Math.floor(z) - 0.5);
            blocksBelow.add(block.getBlock());
        } else if(z - Math.floor(z) >= 0.7){
            block.setZ(Math.ceil(z) + 0.5);
            blocksBelow.add(block.getBlock());
        }

        if(x - Math.floor(x) <= 0.3 && z - Math.floor(z) <= 0.3){
            block.setX(Math.floor(x) - 0.5);
            block.setZ(Math.floor(z) - 0.5);

            blocksBelow.add(block.getBlock());
        } else if(x - Math.floor(x) >= 0.7 && z - Math.floor(x) >= 0.7){
            block.setX(Math.ceil(x) + 0.5);
            block.setZ(Math.ceil(z) + 0.5);

            blocksBelow.add(block.getBlock());
        } else if(x - Math.floor(x) <= 0.3 && z - Math.floor(z) >= 0.7){
            block.setX(Math.floor(x) - 0.5);
            block.setZ(Math.ceil(z) + 0.5);

            blocksBelow.add(block.getBlock());
        } else if(x - Math.floor(x) >= 0.7 && z - Math.floor(z) <= 0.3){
            block.setX(Math.ceil(x) + 0.5);
            block.setZ(Math.floor(z) - 0.5);

            blocksBelow.add(block.getBlock());
        }

        // Return the List.
        return blocksBelow;
    }

}
