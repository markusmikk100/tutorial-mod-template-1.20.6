package net.markusmikk.tutorialmod.entity.client;

import net.markusmikk.tutorialmod.entity.animation.ModAnimations;
import net.markusmikk.tutorialmod.entity.custom.GoblinEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class goblin<T extends GoblinEntity> extends SinglePartEntityModel<T> {
	private final ModelPart goblin;
	private final ModelPart Head;

	public goblin(ModelPart root) {
		this.goblin = root.getChild("Goblin");
		this.Head = goblin.getChild("Head");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Goblin = modelPartData.addChild("Goblin", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData Head = Goblin.addChild("Head", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -6.0F, -3.0F, 6.0F, 6.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -17.0F, 0.0F));

		ModelPartData Rarm = Goblin.addChild("Rarm", ModelPartBuilder.create().uv(24, 0).cuboid(-3.0F, 0.0F, -1.0F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-3.0F, -17.0F, 0.0F));

		ModelPartData Body = Goblin.addChild("Body", ModelPartBuilder.create().uv(0, 12).cuboid(-3.0F, -8.0F, -1.0F, 6.0F, 8.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.0F, 0.0F));

		ModelPartData Larm = Goblin.addChild("Larm", ModelPartBuilder.create().uv(12, 24).cuboid(0.0F, 0.0F, -1.0F, 3.0F, 8.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, -17.0F, 0.0F));

		ModelPartData Rleg = Goblin.addChild("Rleg", ModelPartBuilder.create().uv(18, 12).cuboid(-2.0F, 0.0F, -1.0F, 3.0F, 9.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -9.0F, 0.0F));

		ModelPartData Lleg = Goblin.addChild("Lleg", ModelPartBuilder.create().uv(0, 23).cuboid(-1.0F, 0.0F, -1.0F, 3.0F, 9.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(1.0F, -9.0F, 0.0F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(GoblinEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.WALKINGGOBLIN, limbSwing, limbSwingAmount, 1f, 1f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.IDLEGOBLIN, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.ATTACKGG, ageInTicks, 3f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30F, 30F);
		headPitch = MathHelper.clamp(headPitch, -25F, 45F);
		this.Head.yaw = headYaw * 0.017453292F;
		this.Head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		goblin.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return goblin;
	}
}