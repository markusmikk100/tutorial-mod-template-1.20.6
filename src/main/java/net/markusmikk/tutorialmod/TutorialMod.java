package net.markusmikk.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.markusmikk.tutorialmod.entity.ModEntities;
import net.markusmikk.tutorialmod.entity.custom.Desert_raiderEntity;
import net.markusmikk.tutorialmod.entity.custom.GoblinEntity;
import net.markusmikk.tutorialmod.entity.custom.GolemEntity;
import net.markusmikk.tutorialmod.sound.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {

		FabricDefaultAttributeRegistry.register(ModEntities.GOLEM, GolemEntity.createGolemAttributes());

		FabricDefaultAttributeRegistry.register(ModEntities.GOBLIN, GoblinEntity.createGoblinAttributes());

		FabricDefaultAttributeRegistry.register(ModEntities.Desert_raider, Desert_raiderEntity.createDesert_raiderAttributes());

		ModSounds.registerSounds();

	}
}