package net.ankmaniac.tfcadditions.block;

import net.dries007.tfc.common.blocks.ExtendedProperties;
import net.dries007.tfc.common.blocks.IForgeBlockExtension;
import net.dries007.tfc.common.container.TFCWorkbenchContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CraftingCloth extends CraftingTableBlock implements IForgeBlockExtension {
    private static final Component CONTAINER_TITLE = Component.translatable("container.crafting");
    private final ExtendedProperties properties;

    public CraftingCloth(ExtendedProperties properties)
    {
        super(properties.properties());
        this.properties = properties;
    }

    @Override
    public ExtendedProperties getExtendedProperties()
    {
        return properties;
    }

    @Override
    public MenuProvider getMenuProvider(BlockState state, Level world, BlockPos pos)
    {
        return new SimpleMenuProvider((id, inv, player) -> new TFCWorkbenchContainer(id, inv, ContainerLevelAccess.create(world, pos)), CONTAINER_TITLE);
    }
}
