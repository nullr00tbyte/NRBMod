// Nrbmod.java (entry point)
package blackpi.org.nrbmod;
import blackpi.org.nrbmod.block.ModBlocks;
import blackpi.org.nrbmod.item.ModItems;
import blackpi.org.nrbmod.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

public class Rootkz implements ModInitializer {
    public static final String MOD_ID = "nrbmod";

    @Override
    public void onInitialize() {
        ModSounds.initialize();
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
    }
}
