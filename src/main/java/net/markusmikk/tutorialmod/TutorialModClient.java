package net.markusmikk.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.markusmikk.tutorialmod.entity.ModEntities;
import net.markusmikk.tutorialmod.entity.client.*;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.GOLEM, GolemRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.GOLEM, golem::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.GOBLIN, GoblinRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.GOBLIN, goblin::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.Desert_raider, Desert_raiderRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayer.DESERT_RAIDER, desertRaider::getTexturedModelData);
    }
}
