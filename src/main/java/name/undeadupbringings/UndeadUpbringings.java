package name.undeadupbringings;

import name.undeadupbringings.entity.EntityRegistry;
import name.undeadupbringings.entity.mob.AttributeRegistry;
import name.undeadupbringings.item.ModItemRegistry;
import name.undeadupbringings.world.ModEntitySpawns;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UndeadUpbringings implements ModInitializer {
	public static final String MOD_ID = "undeadupbringings";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		EntityRegistry.initEntityRegistry();
		AttributeRegistry.initAttributeRegistry();
		SoundRegistry.initSoundRegistry();
		ModEntitySpawns.addSpawns();
		ModItemRegistry.registerItems();

		LOGGER.info("Undead Upbringings initialized! :D");
	}
}