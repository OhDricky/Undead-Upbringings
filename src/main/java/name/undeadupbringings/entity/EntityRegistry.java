package name.undeadupbringings.entity;

import name.undeadupbringings.UndeadUpbringings;
import name.undeadupbringings.entity.mob.BoulderingEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class EntityRegistry {

    public static void initEntityRegistry() {}


    private static Identifier id (String mobname) {
        return Identifier.of(UndeadUpbringings.MOD_ID, mobname);
    }

    private static RegistryKey<EntityType<?>> registryKey (String mobname) {
        return RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(UndeadUpbringings.MOD_ID, mobname));
    }


    public static final EntityType<BoulderingEntity> BOULDERING = Registry.register(
            Registries.ENTITY_TYPE,
            id("bouldering"),
            EntityType.Builder.create(BoulderingEntity::new, SpawnGroup.MONSTER).dimensions(0.6f, 1.98f).build(registryKey("bouldering")));


}
