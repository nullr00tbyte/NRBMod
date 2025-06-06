// ModBlocks.java
package blackpi.org.rootkz.block;

import blackpi.org.rootkz.Rootkz;
import blackpi.org.rootkz.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final WeedCropBlock WEED_CROP = registerBlockOnly(
            settings -> new WeedCropBlock(settings, () -> ModItems.WEED_SEED),
            Block.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)
    );

    private static <T extends Block> T registerBlockOnly(Function<Block.Settings, T> factory, Block.Settings settings) {
        RegistryKey<Block> blockKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Rootkz.MOD_ID, "weed_crop"));
        T block = factory.apply(settings.registryKey(blockKey));
        Registry.register(Registries.BLOCK, blockKey, block);
        return block;
    }

    public static void registerModBlocks() {
        // Inicialización explícita para cargar los bloques
    }
}