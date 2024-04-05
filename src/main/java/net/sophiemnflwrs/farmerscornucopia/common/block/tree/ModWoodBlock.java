package net.sophiemnflwrs.farmerscornucopia.common.block.tree;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.sophiemnflwrs.farmerscornucopia.common.utility.FCBlockUtility;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class ModWoodBlock extends RotatedPillarBlock {
    private final Supplier<Block> block;

    public ModWoodBlock(Supplier<Block> strippedBlock, Properties properties) {
        super(properties);
        this.block = strippedBlock;
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    @Nullable
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction action, boolean simulate) {
        if (action == ToolActions.AXE_STRIP)
            return this.block != null ? FCBlockUtility.transferAllBlockStates(state, this.block.get().defaultBlockState()) : null;
        return super.getToolModifiedState(state, context, action, simulate);
    }
}
