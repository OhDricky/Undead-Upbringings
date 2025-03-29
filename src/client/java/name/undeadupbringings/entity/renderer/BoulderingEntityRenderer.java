package name.undeadupbringings.entity.renderer;

import name.undeadupbringings.UndeadUpbringings;
import name.undeadupbringings.entity.mob.BoulderingEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ZombieBaseEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.ZombieEntityModel;
import net.minecraft.client.render.entity.state.ZombieEntityRenderState;
import net.minecraft.util.Identifier;


@Environment(EnvType.CLIENT)
public class BoulderingEntityRenderer extends ZombieBaseEntityRenderer<BoulderingEntity, ZombieEntityRenderState, ZombieEntityModel<ZombieEntityRenderState>> {


    private static final Identifier TEXTURE = Identifier.of(UndeadUpbringings.MOD_ID, "textures/entity/mob/bouldering.png");

    public BoulderingEntityRenderer(EntityRendererFactory.Context context) {
        this(context, EntityModelLayers.HUSK,
                EntityModelLayers.HUSK_BABY,
                EntityModelLayers.HUSK_INNER_ARMOR,
                EntityModelLayers.HUSK_OUTER_ARMOR,
                EntityModelLayers.HUSK_BABY_INNER_ARMOR,
                EntityModelLayers.HUSK_BABY_OUTER_ARMOR);
    }

    @Override
    public ZombieEntityRenderState createRenderState() {
        return new ZombieEntityRenderState();
    }

    public BoulderingEntityRenderer(EntityRendererFactory.Context ctx, EntityModelLayer layer, EntityModelLayer legsArmorLayer, EntityModelLayer bodyArmorLayer, EntityModelLayer entityModelLayer, EntityModelLayer entityModelLayer2, EntityModelLayer entityModelLayer3) {
        super(ctx, new ZombieEntityModel<>(ctx.getPart(layer)), new ZombieEntityModel<>(ctx.getPart(legsArmorLayer)), new ZombieEntityModel<>(ctx.getPart(bodyArmorLayer)), new ZombieEntityModel<>(ctx.getPart(entityModelLayer)), new ZombieEntityModel<>(ctx.getPart(entityModelLayer2)), new ZombieEntityModel<>(ctx.getPart(entityModelLayer3)));
    }


    public Identifier getTexture(ZombieEntityRenderState zombieEntityRenderState) {
        return TEXTURE;
    }
}
