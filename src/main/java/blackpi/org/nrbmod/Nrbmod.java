// Nrbmod.java (entry point)
package blackpi.org.nrbmod;
import blackpi.org.nrbmod.block.ModBlocks;
import blackpi.org.nrbmod.item.ModItems;
import net.fabricmc.api.ModInitializer;

public class Nrbmod implements ModInitializer {
    public static final String MOD_ID = "nrbmod";

    @Override
    public void onInitialize() {
        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
    }
}
