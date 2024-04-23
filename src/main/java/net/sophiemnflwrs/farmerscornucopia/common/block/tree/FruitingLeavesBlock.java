package net.sophiemnflwrs.farmerscornucopia.common.block.tree;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ForgeHooks;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCBlocks;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCItems;

public class FruitingLeavesBlock extends FCLeavesBlock implements BonemealableBlock {
    public static final int MAX_AGE = 4;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_4;

    public FruitingLeavesBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(AGE, Integer.valueOf(0))
                .setValue(DISTANCE, Integer.valueOf(7))
                .setValue(PERSISTENT, Boolean.valueOf(false))
                .setValue(WATERLOGGED, Boolean.valueOf(false)));

    }

    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < MAX_AGE || state.getValue(DISTANCE) == 7 && !state.getValue(PERSISTENT);
    }

    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource rand) {
        if (this.decaying(state)) {
            dropResources(state, world, pos);
            world.removeBlock(pos, false);
        }
        else {
            int age = state.getValue(AGE);
            if (age < MAX_AGE) {
                BlockState blockstate = state.setValue(AGE, Integer.valueOf(age + 1));
                world.setBlock(pos, blockstate, 2);
                world.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(blockstate));
                ForgeHooks.onCropsGrowPost(world, pos, state);
            }
        }
    }

    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        int i = state.getValue(AGE);
        boolean flag = i == MAX_AGE;
        if (!flag && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (i > 1) {
            if (state.is(FCBlocks.FRUITING_OLIVE_LEAVES.get())) {
                int j = 1 + world.random.nextInt(2);
                popResource(world, pos, new ItemStack(FCItems.OLIVE.get(), j + (flag ? 1 : 0)));
                world.playSound((Player) null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + world.random.nextFloat() * 0.4F);
                BlockState blockstate = state.setValue(AGE, Integer.valueOf(0));
                world.setBlock(pos, blockstate, 2);
                world.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, blockstate));
            }
            return InteractionResult.sidedSuccess(world.isClientSide);
        } else {
            return super.use(state, world, pos, player, hand, result);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        state.add(AGE);
        state.add(DISTANCE, PERSISTENT, WATERLOGGED);
    }

    public boolean isValidBonemealTarget(BlockGetter getter, BlockPos pos, BlockState state, boolean b) {
        return state.getValue(AGE) < MAX_AGE;
    }

    public boolean isBonemealSuccess(Level level, RandomSource source, BlockPos pos, BlockState state) {
        return true;
    }

    public void performBonemeal(ServerLevel p_222553_, RandomSource source, BlockPos pos, BlockState state) {
        int i = Math.min(MAX_AGE, state.getValue(AGE) + 1);
        p_222553_.setBlock(pos, state.setValue(AGE, Integer.valueOf(i)), 2);
    }
}
