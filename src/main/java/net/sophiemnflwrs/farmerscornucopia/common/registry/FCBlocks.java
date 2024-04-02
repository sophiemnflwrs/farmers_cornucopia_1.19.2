package net.sophiemnflwrs.farmerscornucopia.common.registry;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwrs.farmerscornucopia.common.block.GarlicCrop;
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

    //crops
        public static final RegistryObject<Block> GARLIC_CROP = BLOCKS.register("garlic_crop",
            () -> new GarlicCrop(Block.Properties.copy(Blocks.WHEAT)));

    // register
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
