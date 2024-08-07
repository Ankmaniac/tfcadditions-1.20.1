package net.ankmaniac.tfcadditions.sound;

import net.ankmaniac.tfcadditions.TfcAdditions;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, TfcAdditions.MODID);

    public static final RegistryObject<SoundEvent> ASBESTOS_BREAK = registerSoundEvents("asbestos/asbestos_break");
    public static final RegistryObject<SoundEvent> ASBESTOS_STEP = registerSoundEvents("asbestos/asbestos_step");
    public static final RegistryObject<SoundEvent> ASBESTOS_PLACE = registerSoundEvents("asbestos/asbestos_place");
    public static final RegistryObject<SoundEvent> ASBESTOS_HIT = registerSoundEvents("asbestos/asbestos_hit");
    public static final RegistryObject<SoundEvent> ASBESTOS_FALL = registerSoundEvents("asbestos/asbestos_fall");

    public static final RegistryObject<SoundEvent> ASBESTOS_PLANKS_BREAK = registerSoundEvents("asbestos/asbestos_planks_break");
    public static final RegistryObject<SoundEvent> ASBESTOS_PLANKS_STEP = registerSoundEvents("asbestos/asbestos_planks_step");
    public static final RegistryObject<SoundEvent> ASBESTOS_PLANKS_PLACE = registerSoundEvents("asbestos/asbestos_planks_place");
    public static final RegistryObject<SoundEvent> ASBESTOS_PLANKS_HIT = registerSoundEvents("asbestos/asbestos_planks_hit");
    public static final RegistryObject<SoundEvent> ASBESTOS_PLANKS_FALL = registerSoundEvents("asbestos/asbestos_planks_fall");


    public static final ForgeSoundType ASBESTOS_SOUNDS = new ForgeSoundType
            (1f, 1f,
            ModSounds.ASBESTOS_BREAK,
            ModSounds.ASBESTOS_STEP,
            ModSounds.ASBESTOS_PLACE,
            ModSounds.ASBESTOS_HIT,
            ModSounds.ASBESTOS_FALL);
    public static final ForgeSoundType ASBESTOS_PLANKS_SOUNDS = new ForgeSoundType
            (1f, 1f,
            ModSounds.ASBESTOS_PLANKS_BREAK,
            ModSounds.ASBESTOS_PLANKS_STEP,
            ModSounds.ASBESTOS_PLANKS_PLACE,
            ModSounds.ASBESTOS_PLANKS_HIT,
            ModSounds.ASBESTOS_PLANKS_FALL);

    public static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(TfcAdditions.MODID, name)));
    }

    public static  void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
