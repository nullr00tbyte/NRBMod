package blackpi.org.rootkz.sound;

import blackpi.org.rootkz.Rootkz;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.block.jukebox.JukeboxSongs;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final RegistryEntry<SoundEvent> JOINT_SMOKE = registerSound("joint_smoke");
    public static final RegistryEntry<SoundEvent> COF = registerSound("cof");

    public static final RegistryEntry<SoundEvent> DUB_SONG = registerSound("dub_song");
    public static final RegistryKey<JukeboxSong> DUB_SONG_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Rootkz.MOD_ID, "dub_song"));

    private static RegistryEntry<SoundEvent> registerSound(String name) {
        Identifier id = Identifier.of(Rootkz.MOD_ID, name);
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