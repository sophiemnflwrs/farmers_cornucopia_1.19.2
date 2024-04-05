package net.sophiemnflwrs.farmerscornucopia.common.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwrs.farmerscornucopia.common.block.crops.GarlicCrop;
import net.sophiemnflwrs.farmerscornucopia.common.block.crops.GingerCrop;
import net.sophiemnflwrs.farmerscornucopia.common.block.tree.WoodBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;

public class FCBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FarmersCornucopia.MOD_ID);

    // salt
    public static final RegistryObject<Block> SALT_BLOCK = BLOCKS.register("salt_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SALT_ORE = BLOCKS.register("salt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).sound(SoundType.STONE).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> DEEPSLATE_SALT_ORE = BLOCKS.register("deepslate_salt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f).sound(SoundType.STONE).requiresCorrectToolForDrops(), UniformInt.of(3,6)));

    // wild crops
    public static final RegistryObject<Block> WILD_GARLIC = BLOCKS.register("wild_garlic",
            () -> new WildCropBlock(MobEffects.FIRE_RESISTANCE, 6, BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> WILD_GINGER = BLOCKS.register("wild_ginger",
            () -> new WildCropBlock(MobEffects.FIRE_RESISTANCE, 10, BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));

    // trees
    public static final RegistryObject<Block> OLIVE_LOG = BLOCKS.register("olive_log",
            () -> new WoodBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> OLIVE_WOOD = BLOCKS.register("olive_wood",
            () -> new WoodBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_OLIVE_LOG = BLOCKS.register("stripped_olive_log",
            () -> new WoodBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_OLIVE_WOOD = BLOCKS.register("stripped_olive_wood",
            () -> new WoodBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> OLIVE_LEAVES = BLOCKS.register("olive_log",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
            }
        );
    public static final RegistryObject<Block> OLIVE_SAPLING = BLOCKS.register("olive_sapling",
            () -> new SaplingBlock( , BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> OLIVE_PLANKS = BLOCKS.register("olive_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {
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
                    return 20;
                }
            }
        );

    // crops
        public static final RegistryObject<Block> GARLIC_CROP = BLOCKS.register("garlic_crop",
            () -> new GarlicCrop(Block.Properties.copy(Blocks.WHEAT)));
        public static final RegistryObject<Block> GINGER_CROP = BLOCKS.register("ginger_crop",
            () -> new GingerCrop(Block.Properties.copy(Blocks.WHEAT)));

    // register
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
