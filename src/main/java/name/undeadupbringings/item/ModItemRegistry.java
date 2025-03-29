package name.undeadupbringings.item;

import name.undeadupbringings.UndeadUpbringings;
import name.undeadupbringings.entity.EntityRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItemRegistry {

    private static final Item.Settings settings = new Item.Settings();
    private static Identifier modID (String name) {
        return Identifier.of(UndeadUpbringings.MOD_ID, name);
    }

    private static Item register(String name, Function<Item.Settings, Item> itemFactory) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, modID(name));
        Item item = itemFactory.apply(settings.registryKey(itemKey));
        Registry.register(Registries.ITEM, itemKey, item);
        return item;
    }

    private static Function<Item.Settings, Item> createSpawnEggItem(EntityType<? extends MobEntity> entityType) {
        return (settings) -> new SpawnEggItem(entityType, settings);
    }


    public static void registerItems() {
        final Item BOULDERING_SPAWN_EGG = register("bouldering_spawn_egg", createSpawnEggItem(EntityRegistry.BOULDERING));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> content.add(BOULDERING_SPAWN_EGG));
    }

}
