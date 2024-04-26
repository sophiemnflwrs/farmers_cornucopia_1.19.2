package net.sophiemnflwrs.farmerscornucopia.common.registry;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwrs.farmerscornucopia.common.block.bush.BlueberryBush;
import net.sophiemnflwrs.farmerscornucopia.common.block.crop.GarlicCrop;
import net.sophiemnflwrs.farmerscornucopia.common.block.crop.GingerCrop;
import net.sophiemnflwrs.farmerscornucopia.common.block.shrub.LemonSeedling;
import net.sophiemnflwrs.farmerscornucopia.common.block.shrub.LemonShrub;
import net.sophiemnflwrs.farmerscornucopia.common.block.tree.FCLeavesBlock;
import net.sophiemnflwrs.farmerscornucopia.common.block.tree.FCLogBlock;
import net.sophiemnflwrs.farmerscornucopia.common.block.tree.FCPlanksBlock;
import net.sophiemnflwrs.farmerscornucopia.common.block.tree.FruitingLeavesBlock;
import net.sophiemnflwrs.farmerscornucopia.common.world.feature.tree.OliveTreeGrower;
import vectorwing.farmersdelight.common.block.WildCropBlock;

public class FCBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FarmersCornucopia.MOD_ID);

    // crop crates
    public static final RegistryObject<Block> GARLIC_CRATE = BLOCKS.register("garlic_crate",
            () -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GINGER_CRATE = BLOCKS.register("ginger_crate",
            () -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> OLIVE_CRATE = BLOCKS.register("olive_crate",
            () -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEMON_CRATE = BLOCKS.register("lemon_crate",
            () -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BLUEBERRY_CRATE = BLOCKS.register("blueberry_crate",
            () -> new Block(Block.Properties.of(Material.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    // salt
    public static final RegistryObject<Block> SALT_BLOCK = BLOCKS.register("salt_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SALT_ORE = BLOCKS.register("salt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).sound(SoundType.STONE).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> DEEPSLATE_SALT_ORE = BLOCKS.register("deepslate_salt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f).sound(SoundType.STONE).requiresCorrectToolForDrops(), UniformInt.of(3,6)));

    // trees
    public static final RegistryObject<Block> OLIVE_LOG = BLOCKS.register("olive_log",
            () -> new FCLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_OLIVE_LOG = BLOCKS.register("stripped_olive_log",
            () -> new FCLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> OLIVE_LEAVES = BLOCKS.register("olive_leaves",
            () -> new FCLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> FRUITING_OLIVE_LEAVES = BLOCKS.register("fruiting_olive_leaves",
            () -> new FruitingLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> OLIVE_PLANKS = BLOCKS.register("olive_planks",
            () -> new FCPlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> OLIVE_SAPLING = BLOCKS.register("olive_sapling",
            () -> new SaplingBlock(new OliveTreeGrower(),  BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    // shrubs
    public static final RegistryObject<Block> LEMON_SEEDLING = BLOCKS.register("lemon_seedling",
            () -> new LemonSeedling(BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> LEMON_SHRUB = BLOCKS.register("lemon_shrub",
            () -> new LemonShrub(BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.GRASS).noOcclusion()));

    // bush
    public static final RegistryObject<Block> BLUEBERRY_BUSH = BLOCKS.register("blueberry_bush",
            () -> new BlueberryBush(BlockBehaviour.Properties.of(Material.PLANT).instabreak().sound(SoundType.GRASS).noOcclusion()));

    // wild crops
    public static final RegistryObject<Block> WILD_GARLIC = BLOCKS.register("wild_garlic",
            () -> new WildCropBlock(MobEffects.FIRE_RESISTANCE, 6, BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> WILD_GINGER = BLOCKS.register("wild_ginger",
            () -> new WildCropBlock(MobEffects.FIRE_RESISTANCE, 10, BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));

    // flowers
    public static final RegistryObject<Block> VIOLET = BLOCKS.register("violet",
            () -> new FlowerBlock(MobEffects.REGENERATION, 4, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> POTTED_VIOLET = BLOCKS.register("potted_violet",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock)Blocks.FLOWER_POT), FCBlocks.VIOLET, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));

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
