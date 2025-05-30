package blackpi.org.nrbmod.client;

import blackpi.org.nrbmod.block.ModBlocks;
import blackpi.org.nrbmod.block.WeedCropBlock;
import blackpi.org.nrbmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class WeedLootTableProvider extends FabricBlockLootTableProvider {
    protected WeedLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.WEED_CROP, cropDrops(ModBlocks.WEED_CROP, ModItems.BUD, ModItems.WEED_SEED, BlockStatePropertyLootCondition.builder(ModBlocks.WEED_CROP).properties(StatePredicate.Builder.create().exactMatch(WeedCropBlock.AGE, 7))));
    }
}