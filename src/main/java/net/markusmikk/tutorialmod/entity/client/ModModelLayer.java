package net.markusmikk.tutorialmod.entity.client;

import net.markusmikk.tutorialmod.TutorialMod;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayer {
    public  static  final EntityModelLayer GOLEM = new EntityModelLayer(new Identifier(TutorialMod.MOD_ID, "golem"), "main");
    public  static  final EntityModelLayer GOBLIN = new EntityModelLayer(new Identifier(TutorialMod.MOD_ID, "goblin"), "main");
    public  static  final EntityModelLayer DESERT_RAIDER = new EntityModelLayer(new Identifier(TutorialMod.MOD_ID, "desert_raider"), "main");
}
