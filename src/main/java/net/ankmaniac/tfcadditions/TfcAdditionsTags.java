package net.ankmaniac.tfcadditions;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("unused")
public class TfcAdditionsTags {
    public static class Blocks{
        public static final TagKey<Block> Rock_Columns = create("rock_columns");
        public static final TagKey<Block> TABLES = create("tables");

        private static TagKey<Block> create(String id)
        {
            return TagKey.create(Registries.BLOCK, TfcAdditionsHelpers.identifier(id));
        }
    }
}
