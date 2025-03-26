package name.undeadupbringings.entity.renderer;

import name.undeadupbringings.entity.EntityRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class ModEntityRendererRegistry {


    public static void initEntityRenderers() {
        EntityRendererRegistry.register(EntityRegistry.BOULDERING, BoulderingEntityRenderer::new);

    }


}
