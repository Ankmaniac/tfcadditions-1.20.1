package net.ankmaniac.tfcadditions.fluid;

//import net.ankmaniac.tfcadditions.block.ModBlocks;
//import net.ankmaniac.tfcadditions.item.ModItems;
//import net.dries007.tfc.common.fluids.ExtendedFluidType;
//import net.dries007.tfc.common.fluids.FluidRegistryObject;
//import net.dries007.tfc.common.fluids.FluidTypeClientProperties;
//import net.dries007.tfc.util.registry.RegistrationHelpers;
//
//import static net.ankmaniac.tfcadditions.fluid.ModFluidTypes.FLUID_TYPES;
//import static net.dries007.tfc.util.registry.RegistrationHelpers.registerFluid;
//
//import net.ankmaniac.tfcadditions.TfcAdditions;
//import net.minecraft.world.level.material.FlowingFluid;
//import net.minecraft.world.level.material.Fluid;
//import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraftforge.fluids.FluidType;
//import net.minecraftforge.fluids.ForgeFlowingFluid;
//import net.minecraftforge.registries.DeferredRegister;
//import net.minecraftforge.registries.ForgeRegistries;
//
//import java.util.function.Consumer;
//import java.util.function.Function;


import net.ankmaniac.tfcadditions.TfcAdditions;
import net.ankmaniac.tfcadditions.block.ModBlocks;
import net.ankmaniac.tfcadditions.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, TfcAdditions.MODID);

    public static final RegistryObject<FlowingFluid> SOURCE_FLUID_CONCRETE = FLUIDS.register("fluid_concrete",
            () -> new ForgeFlowingFluid.Source(ModFluids.FLUID_CONCRETE_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_FLUID_CONCRETE = FLUIDS.register("flowing_fluid_concrete",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.FLUID_CONCRETE_PROPERTIES));

    public static final ForgeFlowingFluid.Properties FLUID_CONCRETE_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.FLUID_CONCRETE_FLUID_TYPE, SOURCE_FLUID_CONCRETE, FLOWING_FLUID_CONCRETE)
            .slopeFindDistance(2).levelDecreasePerBlock(2).bucket(ModItems.CONCRETE_BUCKET);

    public static void register(IEventBus eventBus){
        FLUIDS.register(eventBus);
    }



//    public static final DeferredRegister<Fluid> FLUIDS =
//            DeferredRegister.create(ForgeRegistries.FLUIDS, TfcAdditions.MODID);
//
//    public static final int ALPHA_MASK = 0xFF000000;
//
//    public static final FluidRegistryObject<ForgeFlowingFluid> FLUID_Concrete = registerFluid(
//            "fluids/concrete",
//            properties -> properties
//                    .block(ModBlocks.FLUID_CONCRETE)
//                    .bucket(ModItems.FLUID_BUCKETS.get(FluidId.FLUID_CONCRETE))
//            lavalike()
//                    .descriptionId("fluid.tfcadditions.fluid_concrete")
//    );
//
//
//    private static <F extends FlowingFluid> FluidRegistryObject<F> register(String name, Consumer<ForgeFlowingFluid.Properties> builder, FluidType.Properties typeProperties, FluidTypeClientProperties clientProperties, Function<ForgeFlowingFluid.Properties, F> sourceFactory, Function<ForgeFlowingFluid.Properties, F> flowingFactory){
//        final int index = name.lastIndexOf('/');
//        final String flowingName = index == -1 ? "flowing_" + name : name.substring(0,index) + "/flowing_" + name.substring(index+1);
//
//        return registerFluid(FLUID_TYPES, FLUIDS, name, name, flowingName, builder,
//                () -> new ExtendedFluidType(typeProperties, clientProperties), sourceFactory, flowingFactory);
//    }
//
//    public static void register(IEventBus eventBus) {
//        FLUIDS.register(eventBus);
//    }
}
