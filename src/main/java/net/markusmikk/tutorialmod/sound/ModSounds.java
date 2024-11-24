package net.markusmikk.tutorialmod.sound;

import net.markusmikk.tutorialmod.TutorialMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent GOBLIN_HURT = registerSoundEvent("goblin_hurt");
    public static final SoundEvent GOBLIN_AMBIENT = registerSoundEvent("goblin_ambient");
    public static final SoundEvent GOBLIN_DEATH = registerSoundEvent("goblin_death");


   // public static final BlockSoundGroup SOUND_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f,
  //          ModSounds.SOUND_BLOCK_BREAK, ModSounds.SOUND_BLOCK_STEP, ModSounds.SOUND_BLOCK_PLACE,
 //           ModSounds.SOUND_BLOCK_HIT, ModSounds.SOUND_BLOCK_FALL);


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(TutorialMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        TutorialMod.LOGGER.info("Registering Sounds for " + TutorialMod.MOD_ID);
    }
}
