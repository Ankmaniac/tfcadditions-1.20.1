package net.ankmaniac.tfcadditions.fluid;

import net.ankmaniac.tfcadditions.TfcAdditions;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flowing");
    public static final ResourceLocation OVERLAY = new ResourceLocation(TfcAdditions.MODID,"block/fluid/overlay");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, TfcAdditions.MODID);

    public static final RegistryObject<FluidType> FLUID_CONCRETE_FLUID_TYPE = register("fluid_concrete",
            FluidType.Properties.create());

    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, OVERLAY,
                0xA1666666, new Vector3f(102f/255f, 102f/255f, 102f/255f), properties));
    }


    public static void register(IEventBus eventBus){
        FLUID_TYPES.register(eventBus);
    }

}
