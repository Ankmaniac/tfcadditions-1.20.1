package net.ankmaniac.tfcadditions.util;

import net.ankmaniac.tfcadditions.block.ModBlocks;
import net.dries007.tfc.common.blocks.wood.Wood;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.RegistryObject;

import static net.ankmaniac.tfcadditions.block.ModBlocks.INSULATED_PLANKS;
import static net.ankmaniac.tfcadditions.block.ModBlocks.INSULATED_PLANKS_SLABS;

public class InsulationReplacement {
    public static Block getReplacementPlank(Wood wood) {
        return ModBlocks.INSULATED_PLANKS.get(wood).get();
    }

    public static Block getReplacementSlab(Wood wood) {
        return INSULATED_PLANKS_SLABS.get(wood).get();
    }

    public static Block getReplacementStairs(Wood wood) {
        return ModBlocks.INSULATED_PLANKS_STAIRS.get(wood).get();
    }
}
