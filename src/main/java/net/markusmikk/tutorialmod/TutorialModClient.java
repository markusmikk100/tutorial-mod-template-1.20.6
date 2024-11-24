package net.markusmikk.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.markusmikk.tutorialmod.entity.ModEntities;
import net.markusmikk.tutorialmod.entity.client.GoblinRenderer;
import net.markusmikk.tutorialmod.entity.client.golem;
import net.markusmikk.tutorialmod.entity.client.Goblin;
import net.markusmikk.tutorialmod.entity.client.GolemRenderer;
import net.markusmikk.tutorialmod.entity.client.ModModelLayer;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.GOLEM, GolemRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.GOLEM, golem::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.GOBLIN, GoblinRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.GOBLIN, Goblin::getTexturedModelData);
    }
}
