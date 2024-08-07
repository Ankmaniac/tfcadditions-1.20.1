package net.ankmaniac.tfcadditions.item;

import net.ankmaniac.tfcadditions.TfcAdditions;
import net.ankmaniac.tfcadditions.fluid.ModFluids;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TfcAdditions.MODID);

    public static final RegistryObject<Item> SLAB_MOLD = ITEMS.register("wood/mold/slab/slab_mold",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BRICK_MOLD = ITEMS.register("wood/mold/brick/brick_mold",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CONCRETE_SLAB = ITEMS.register("concrete/slab/concrete_slab",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CINDER_BLOCK = ITEMS.register("concrete/brick/cinder_block",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASBESTOS_LINING = ITEMS.register("asbestos_lining",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASBESTOS_CLOTH = ITEMS.register("asbestos_cloth",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASBESTOS_STRING = ITEMS.register("asbestos_string",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASBEESTOS = ITEMS.register("asbeestos",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ASBESTOS_ORE = ITEMS.register("ore/asbestos",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CONCRETE_BUCKET = ITEMS.register("concrete/bucket",
            () -> new BucketItem(ModFluids.SOURCE_FLUID_CONCRETE, new Item.Properties().craftRemainder(Items.BUCKET)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
