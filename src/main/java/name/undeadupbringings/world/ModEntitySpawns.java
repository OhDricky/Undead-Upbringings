package name.undeadupbringings.world;

import name.undeadupbringings.entity.EntityRegistry;
import name.undeadupbringings.entity.mob.BoulderingEntity;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.world.Heightmap;

public class ModEntitySpawns {

    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.all(), SpawnGroup.MONSTER, EntityRegistry.BOULDERING, 70, 2, 4);

        SpawnRestriction.register(EntityRegistry.BOULDERING, SpawnLocationTypes.ON_GROUND, Heightmap.Type.WORLD_SURFACE, BoulderingEntity::canSpawn);
    }
}

