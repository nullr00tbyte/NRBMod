// Nrbmod.java (entry point)
package blackpi.org.rootkz;
import blackpi.org.rootkz.block.ModBlocks;
import blackpi.org.rootkz.item.ModItems;
import blackpi.org.rootkz.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

public class Rootkz implements ModInitializer {
    public static final String MOD_ID = "rootkz";

    @Override
    public void onInitialize() {
        ModSounds.initialize();
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
    }
}
