package name.undeadupbringings.entity.mob;

import name.undeadupbringings.entity.EntityRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class AttributeRegistry {

    public static void initAttributeRegistry() {
        FabricDefaultAttributeRegistry.register(EntityRegistry.BOULDERING, BoulderingEntity.createZombieAttributes());
    }
}