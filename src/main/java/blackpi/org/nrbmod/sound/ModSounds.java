package blackpi.org.nrbmod.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import blackpi.org.nrbmod.Nrbmod;

public class ModSounds {
    public static final RegistryEntry<SoundEvent> JOINT_SMOKE = registerSound("joint_smoke");
    public static final RegistryEntry<SoundEvent> COF = registerSound("cof");

    private static RegistryEntry<SoundEvent> registerSound(String name) {
        Identifier id = Identifier.of(Nrbmod.MOD_ID, name);
        SoundEvent soundEvent = SoundEvent.of(id);
        return Registry.registerReference(
                Registries.SOUND_EVENT,
                id,
                soundEvent
        );
    }

    public static void initialize() {

    }
}