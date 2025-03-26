package name.undeadupbringings;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class SoundRegistry {

    // Bouldering Sounds
    public static final Identifier BOULDERING_AMBIENT_ID = Identifier.of("undeadupbringings:bouldering_ambient");
    public static final Identifier BOULDERING_HURT_ID = Identifier.of("undeadupbringings:bouldering_hurt");
    public static final Identifier BOULDERING_DEATH_ID = Identifier.of("undeadupbringings:bouldering_death");
    public static SoundEvent BOULDERING_AMBIENT = SoundEvent.of(BOULDERING_AMBIENT_ID);
    public static SoundEvent BOULDERING_HURT = SoundEvent.of(BOULDERING_HURT_ID);
    public static SoundEvent BOULDERING_DEATH = SoundEvent.of(BOULDERING_DEATH_ID);


    public static void initSoundRegistry() {
        Registry.register(Registries.SOUND_EVENT, SoundRegistry.BOULDERING_AMBIENT_ID, BOULDERING_AMBIENT);
        Registry.register(Registries.SOUND_EVENT, SoundRegistry.BOULDERING_HURT_ID, BOULDERING_HURT);
        Registry.register(Registries.SOUND_EVENT, SoundRegistry.BOULDERING_DEATH_ID, BOULDERING_DEATH);
    }
}
