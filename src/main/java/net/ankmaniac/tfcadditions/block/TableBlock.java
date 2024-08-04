package net.ankmaniac.tfcadditions.block;

import net.ankmaniac.tfcadditions.TfcAdditionsTags;
import net.dries007.tfc.util.Helpers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class TableBlock extends Block {
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final BooleanProperty NORTHEAST = BooleanProperty.create("northeast");
    public static final BooleanProperty SOUTHEAST = BooleanProperty.create("southeast");
    public static final BooleanProperty NORTHWEST = BooleanProperty.create("northwest");
    public static final BooleanProperty SOUTHWEST = BooleanProperty.create("southwest");

    public TableBlock(Properties properties){
        super(properties);
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(NORTH, true)
                        .setValue(EAST, true)
                        .setValue(SOUTH, true)
                        .setValue(WEST, true)
                        .setValue(NORTHEAST, true)
                        .setValue(SOUTHEAST, true)
                        .setValue(NORTHWEST, true)
                        .setValue(SOUTHWEST, true)
        );
    }

    private static final VoxelShape SHAPE = Shapes.box(0, 14f/16f, 0, 1, 1, 1);

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext ctx) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(NORTH, EAST, SOUTH, WEST, NORTHEAST, SOUTHEAST, NORTHWEST, SOUTHWEST));
    }

    @SuppressWarnings("deprecation")
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos)
    {
        if (facing == Direction.NORTH)
        {
            state = state.setValue(NORTH, !connects(facingState));
        }
        else if (facing == Direction.EAST)
        {
            state = state.setValue(EAST, !connects(facingState));
        }
        else if (facing == Direction.SOUTH)
        {
            state = state.setValue(SOUTH, !connects(facingState));
        }
        else if (facing == Direction.WEST)
        {
            state = state.setValue(WEST, !connects(facingState));
        }
        return state;
    }

    public boolean connects(BlockState adjacent)
    {
        return Helpers.isBlock(adjacent, TfcAdditionsTags.Blocks.TABLES);
    }
}
