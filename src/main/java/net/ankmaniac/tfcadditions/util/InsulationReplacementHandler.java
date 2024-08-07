package net.ankmaniac.tfcadditions.util;

import net.ankmaniac.tfcadditions.item.ModItems;
import net.ankmaniac.tfcadditions.sound.ModSounds;
import net.dries007.tfc.common.blocks.wood.Wood;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "tfcadditions")
public class InsulationReplacementHandler {
    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        BlockPos pos = event.getPos();
        Player player = event.getEntity();
        ItemStack itemStack = event.getItemStack();
        InteractionHand hand = event.getHand();

        if (itemStack.getItem() == ModItems.ASBESTOS_LINING.get()) {
            BlockState state = level.getBlockState(pos);

            for (Wood wood : Wood.values()) {
                if (state.is(wood.getBlock(Wood.BlockType.PLANKS).get())) {
                    replaceBlock(level, pos, state, InsulationReplacement.getReplacementPlank(wood), player, itemStack);
                    level.playSound(null, pos, ModSounds.ASBESTOS_PLACE.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
                    if (player instanceof ServerPlayer) {
                        ((ServerPlayer) player).swing(hand, true);
                    }
                    break;
                } else if (state.is(wood.getBlock(Wood.BlockType.SLAB).get())) {
                    replaceBlock(level, pos, state, InsulationReplacement.getReplacementSlab(wood), player, itemStack);
                    level.playSound(null, pos, ModSounds.ASBESTOS_PLACE.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
                    if (player instanceof ServerPlayer) {
                        ((ServerPlayer) player).swing(hand, true);
                    }
                    break;
                } else if (state.is(wood.getBlock(Wood.BlockType.STAIRS).get())) {
                    replaceBlock(level, pos, state, InsulationReplacement.getReplacementStairs(wood), player, itemStack);
                    level.playSound(null, pos, ModSounds.ASBESTOS_PLACE.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
                    if (player instanceof ServerPlayer) {
                        ((ServerPlayer) player).swing(hand, true);
                    }
                    break;
                }
            }
        }

    }
    private static void replaceBlock(Level level, BlockPos pos, BlockState state, Block replacementBlock, Player player, ItemStack itemStack){
        if (replacementBlock != null) {
            BlockState newState = copyBlockStateProperties(state, replacementBlock.defaultBlockState());
            level.setBlock(pos, newState, 3);

            if (!player.isCreative()) {
                itemStack.shrink(1);
            }
        }
    }
    private static BlockState copyBlockStateProperties(BlockState oldState, BlockState newState) {
        for (Property<?> property : oldState.getProperties()) {
            if (newState.hasProperty(property)) {
                newState = setBlockStateValue(newState, property, oldState.getValue(property));
            }
        }
        return newState;
    }

    private static <T extends Comparable<T>> BlockState setBlockStateValue(BlockState state, Property<T> property, Comparable<?> value) {
        return state.setValue(property, property.getValueClass().cast(value));
    }
}
