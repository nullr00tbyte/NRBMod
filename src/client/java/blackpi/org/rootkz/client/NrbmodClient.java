// NrbmodClient.java
package blackpi.org.rootkz.client;

import blackpi.org.rootkz.block.ModBlocks;
import blackpi.org.rootkz.entities.ModEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import blackpi.org.rootkz.client.render.RastaEntityRenderer;

@Environment(EnvType.CLIENT)
public class NrbmodClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WEED_CROP, RenderLayer.getCutout());
        EntityRendererRegistry.register(ModEntities.RASTA, RastaEntityRenderer::new);
    }
}