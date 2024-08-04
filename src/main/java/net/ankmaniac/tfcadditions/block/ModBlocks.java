package net.ankmaniac.tfcadditions.block;

import net.ankmaniac.tfcadditions.TfcAdditions;
import net.ankmaniac.tfcadditions.fluid.ModFluids;
import net.ankmaniac.tfcadditions.item.ModItems;
import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.common.blocks.rock.Rock;
import net.dries007.tfc.util.Helpers;
import net.dries007.tfc.util.registry.RegistrationHelpers;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TfcAdditions.MODID);

    public static final RegistryObject<Block> CINDERBLOCKS = registerBlock("concrete/bricks/cinderblocks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE).noOcclusion()));
    public static final RegistryObject<Block> CONCRETE_SLABS = registerBlock("concrete/slabs/concrete_slabs",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
    public static final RegistryObject<Block> CONCRETE = registerBlock("concrete/concrete",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.LIGHT_GRAY_CONCRETE)));
//  public static final RegistryObject<Block> MARBLE_COLUMN = registerBlock("rock/column/marble",
//            () -> new Block(BlockBehaviour.Properties.of()));
    public static final Map<Rock, RegistryObject<Block>> ROCKS_COLUMNS = Helpers.mapOfKeys(Rock.class, rock ->(
                register(("rock/column/"+ rock.name()), () -> new
                        ColumnBlock(BlockBehaviour.Properties.of()
                        .mapColor(rock.color())
                        .instrument(NoteBlockInstrument.BASEDRUM)
                        .strength(6.5f,10)
                        .noOcclusion()))));
    public static final RegistryObject<Block> TABLE = registerBlock("wood/table/table",
            () -> new Block(BlockBehaviour.Properties.of().noOcclusion()));

    public static final RegistryObject<Block> FLUID_CONCRETE_BLOCK = BLOCKS.register("fluid/fluid_concrete_block",
            () -> new LiquidBlock(ModFluids.SOURCE_FLUID_CONCRETE, BlockBehaviour.Properties.copy(Blocks.WATER)));

    public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier)
    {
        return register(name, blockSupplier, block -> new BlockItem(block, new Item.Properties()));
    }
    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> blockSupplier, @Nullable Function<T, ? extends BlockItem> blockItemFactory)
    {
        return RegistrationHelpers.registerBlock(ModBlocks.BLOCKS, ModItems.ITEMS, name, blockSupplier, blockItemFactory);
    }
}
