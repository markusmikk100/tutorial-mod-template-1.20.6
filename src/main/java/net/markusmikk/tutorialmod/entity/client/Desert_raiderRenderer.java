package net.markusmikk.tutorialmod.entity.client;

import net.markusmikk.tutorialmod.entity.custom.Desert_raiderEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class Desert_raiderRenderer extends MobEntityRenderer<Desert_raiderEntity, desertRaider<Desert_raiderEntity>> {
    private static final Identifier TEXTURE = new Identifier("tutorial_mod", "textures/entity/desert_raider.png");

    public Desert_raiderRenderer(EntityRendererFactory.Context context) {
        super(context, new desertRaider<>(context.getPart(ModModelLayer.DESERT_RAIDER)), 0.3f); //SHADOW
    }

    @Override
    public Identifier getTexture(Desert_raiderEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(Desert_raiderEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}