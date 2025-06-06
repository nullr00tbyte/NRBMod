// Nrbmod.java (entry point)
package blackpi.org.rootkz;
import blackpi.org.rootkz.block.ModBlocks;
import blackpi.org.rootkz.effects.WeedEffect;
import blackpi.org.rootkz.item.ModItems;
import blackpi.org.rootkz.sound.ModSounds;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rootkz implements ModInitializer {
    public static final String MOD_ID = "rootkz";
    public static final Logger LOGGER = LoggerFactory.getLogger(Rootkz.MOD_ID);

    public static final RegistryEntry<StatusEffect> WEED =
            Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Rootkz.MOD_ID, "weed"), new WeedEffect());


    @Override
    public void onInitialize() {
        ModSounds.initialize();
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        LOGGER.info("Mod inicializado");
    }
}
