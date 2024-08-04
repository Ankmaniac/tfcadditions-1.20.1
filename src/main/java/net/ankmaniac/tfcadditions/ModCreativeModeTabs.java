package net.ankmaniac.tfcadditions;

import net.ankmaniac.tfcadditions.block.ModBlocks;
import net.ankmaniac.tfcadditions.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TfcAdditions.MODID);

    public static final RegistryObject<CreativeModeTab> TFCADDITIONS_TAB = CREATIVE_MODE_TABS.register("tfcadditions_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CONCRETE_SLAB.get()))
                    .title(Component.translatable("creativetab.tfcadditions_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SLAB_MOLD.get());
                        pOutput.accept(ModItems.BRICK_MOLD.get());
                        pOutput.accept(ModItems.CONCRETE_SLAB.get());
                        pOutput.accept(ModItems.CINDER_BLOCK.get());

                        pOutput.accept(ModBlocks.CINDERBLOCKS.get());
                        pOutput.accept(ModBlocks.CONCRETE_SLABS.get());
                        pOutput.accept(ModBlocks.CONCRETE.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
