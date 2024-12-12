package net.markusmikk.tutorialmod.entity.client;

import net.markusmikk.tutorialmod.entity.animation.ModAnimations;
import net.markusmikk.tutorialmod.entity.custom.Desert_raiderEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class desertRaider<T extends Desert_raiderEntity> extends SinglePartEntityModel<T> {
	private final ModelPart Raider;
	private  final  ModelPart Head;

	public desertRaider(ModelPart root) {
		this.Raider = root.getChild("Raider");
		this.Head = Raider.getChild("Raider").getChild("upper_body").getChild("Head");

	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Raider = modelPartData.addChild("Raider", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData upper_body = Raider.addChild("upper_body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Sword = upper_body.addChild("Sword", ModelPartBuilder.create().uv(41, 91).cuboid(-0.6156F, -1.0338F, -1.7552F, 1.0F, 2.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-5.2546F, -25.5799F, 3.9636F, -1.1345F, 1.5272F, 3.1416F));

		ModelPartData rip_r12D = Sword.addChild("rip_r12D", ModelPartBuilder.create().uv(64, 97).cuboid(-6.0083F, -8.274F, 6.0F, 12.0F, 4.0F, 3.0F, new Dilation(0.025F))
		.uv(64, 92).cuboid(-6.0083F, -8.274F, 6.0F, 12.0F, 1.0F, 3.0F, new Dilation(0.025F))
		.uv(68, 65).cuboid(-6.0083F, -8.274F, 6.0F, 12.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(49, 19).cuboid(-3.0083F, -8.274F, 7.0F, 6.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(48, 17).cuboid(-2.0083F, -8.274F, 6.0F, 4.0F, 1.0F, 3.0F, new Dilation(0.0F))
		.uv(84, 26).cuboid(-2.0083F, 6.726F, 7.0F, 4.0F, 8.0F, 1.0F, new Dilation(-0.25F))
		.uv(85, 41).cuboid(-2.0083F, 7.726F, 7.0F, 4.0F, 0.0F, 1.0F, new Dilation(0.0F))
		.uv(95, 70).cuboid(-2.0083F, -7.274F, 7.0F, 4.0F, 22.0F, 1.0F, new Dilation(0.125F)), ModelTransform.of(-7.6326F, -0.0386F, -9.4764F, -1.5708F, 0.0F, -1.5708F));

		ModelPartData rip_r11D = Sword.addChild("rip_r11D", ModelPartBuilder.create().uv(105, 70).cuboid(-2.0083F, -7.274F, 7.0F, 8.0F, 24.0F, 1.0F, new Dilation(0.15F)), ModelTransform.of(-7.6326F, -0.1636F, -9.4764F, -1.5708F, 0.0F, -1.5708F));

		ModelPartData swordtop_r1 = Sword.addChild("swordtop_r1", ModelPartBuilder.create().uv(53, 73).cuboid(-2.0F, -10.0F, -0.5F, 4.0F, 20.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-0.1326F, -0.0303F, -12.2024F, -1.5708F, 0.0F, -1.5708F));

		ModelPartData l_arm = upper_body.addChild("l_arm", ModelPartBuilder.create().uv(82, 0).cuboid(0.0F, -1.5F, -2.0F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F))
		.uv(105, 4).cuboid(-0.55F, -2.0F, -2.5F, 5.0F, 7.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -21.5F, 1.0F));

		ModelPartData bone = l_arm.addChild("bone", ModelPartBuilder.create().uv(82, 6).cuboid(-2.0F, 0.0F, -3.5F, 4.0F, 6.0F, 4.0F, new Dilation(0.0F))
		.uv(105, 22).cuboid(-2.55F, -0.5F, -4.0F, 5.0F, 9.0F, 5.0F, new Dilation(-0.02F)), ModelTransform.pivot(2.0F, 4.5F, 1.5F));

		ModelPartData chest = upper_body.addChild("chest", ModelPartBuilder.create().uv(68, 45).cuboid(-4.0F, -5.5F, -2.0F, 8.0F, 11.0F, 4.0F, new Dilation(-0.01F))
		.uv(107, 131).cuboid(4.1F, 5.6F, 2.1F, -8.2F, -11.2F, -4.2F, new Dilation(-0.01F)), ModelTransform.pivot(0.0F, -17.5F, 1.0F));

		ModelPartData Body_c = upper_body.addChild("Body_c", ModelPartBuilder.create().uv(37, 28).cuboid(-4.5F, -9.0F, -2.0F, 9.0F, 22.0F, 5.0F, new Dilation(-0.025F)), ModelTransform.pivot(0.0F, -14.5F, 0.5F));

		ModelPartData Head = upper_body.addChild("Head", ModelPartBuilder.create().uv(37, 58).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -23.0F, 1.0F));

		ModelPartData backb_r1 = Head.addChild("backb_r1", ModelPartBuilder.create().uv(1, 117).cuboid(-4.0F, -9.0F, 2.0F, 8.0F, 9.0F, 1.0F, new Dilation(0.0F))
		.uv(20, 114).cuboid(-4.0F, -9.0F, 0.0F, 8.0F, 9.0F, 4.0F, new Dilation(0.025F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));

		ModelPartData front2_r1 = Head.addChild("front2_r1", ModelPartBuilder.create().uv(50, 113).cuboid(-4.0F, -5.0F, 1.0F, 8.0F, 5.0F, 4.0F, new Dilation(0.325F)), ModelTransform.of(0.0F, -1.325F, -0.575F, 1.309F, 0.0F, 0.0F));

		ModelPartData front_r1 = Head.addChild("front_r1", ModelPartBuilder.create().uv(49, 112).cuboid(-4.0F, -8.0F, -2.0F, 8.0F, 8.0F, 5.0F, new Dilation(0.375F)), ModelTransform.of(0.0F, -0.025F, -0.575F, 0.7418F, 0.0F, 0.0F));

		ModelPartData front_r2 = Head.addChild("front_r2", ModelPartBuilder.create().uv(99, 111).cuboid(-4.0F, -8.0F, -5.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.35F)), ModelTransform.of(0.0F, -2.525F, 3.925F, 1.789F, 0.0F, 0.0F));

		ModelPartData mid_r1 = Head.addChild("mid_r1", ModelPartBuilder.create().uv(6, 101).cuboid(-4.0F, -8.0F, -2.0F, 8.0F, 8.0F, 5.0F, new Dilation(0.35F)), ModelTransform.of(0.0F, -0.5F, 0.0F, 0.2182F, 0.0F, 0.0F));

		ModelPartData r_arm = upper_body.addChild("r_arm", ModelPartBuilder.create().uv(21, 1).cuboid(-4.45F, -2.0F, -2.5F, 5.0F, 22.0F, 5.0F, new Dilation(-0.02F))
		.uv(68, 70).cuboid(-4.0F, -1.5F, -2.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -21.5F, 1.0F));

		ModelPartData l_leg = Raider.addChild("l_leg", ModelPartBuilder.create().uv(36, 73).cuboid(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -12.0F, 0.0F));

		ModelPartData r_leg = Raider.addChild("r_leg", ModelPartBuilder.create().uv(19, 73).cuboid(-2.0F, 0.0F, -1.0F, 4.0F, 12.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -12.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(Desert_raiderEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.WALKINGG, limbSwing, limbSwingAmount, 1f, 1f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.IDLEG, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.ATTACKG, ageInTicks, 3f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30F, 30F);
		headPitch = MathHelper.clamp(headPitch, -25F, 45F);
		this.Head.yaw = headYaw * 0.017453292F;
		this.Head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		Raider.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return Raider;
	}
}