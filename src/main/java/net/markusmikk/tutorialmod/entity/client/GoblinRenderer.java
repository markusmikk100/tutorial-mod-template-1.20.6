package net.markusmikk.tutorialmod.entity.client;

import net.markusmikk.tutorialmod.entity.custom.GoblinEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class GoblinRenderer extends MobEntityRenderer<GoblinEntity, goblin<GoblinEntity>> {
    private static final Identifier TEXTURE = new Identifier("tutorial_mod", "textures/entity/goblin.png");

    public GoblinRenderer(EntityRendererFactory.Context context) {
        super(context, new goblin<>(context.getPart(ModModelLayer.GOBLIN)), 0.3f); //SHADOW
    }

    @Override
    public Identifier getTexture(GoblinEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(GoblinEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (mobEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}