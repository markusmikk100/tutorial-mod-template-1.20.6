package net.markusmikk.tutorialmod.entity.client;

import net.markusmikk.tutorialmod.entity.animation.ModAnimations;
import net.markusmikk.tutorialmod.entity.custom.GolemEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class golem<T extends GolemEntity> extends SinglePartEntityModel<T> {
    private final ModelPart magmagolem;
    private final ModelPart head;

    public golem(ModelPart root) {
        this.magmagolem = root.getChild("MagmaGolem");
        this.head = magmagolem.getChild("Head");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData MagmaGolem = modelPartData.addChild("MagmaGolem", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, 24.0F, -8.0F));

        ModelPartData l_arm = MagmaGolem.addChild("l_arm", ModelPartBuilder.create().uv(88, 0).cuboid(-11.0F, -37.0F, -15.0F, 16.0F, 37.0F, 20.0F, new Dilation(0.0F))
                .uv(0, 137).cuboid(-10.0F, -51.0F, -12.0F, 13.0F, 36.0F, 14.0F, new Dilation(0.0F))
                .uv(210, 44).cuboid(-8.0F, -57.0F, -11.0F, 10.0F, 29.0F, 11.0F, new Dilation(0.0F))
                .uv(160, 217).cuboid(-7.0F, -47.0F, -13.0F, 11.0F, 32.0F, 9.0F, new Dilation(0.0F))
                .uv(214, 258).cuboid(-6.0F, -66.0F, -9.0F, 6.0F, 9.0F, 7.0F, new Dilation(0.0F))
                .uv(158, 258).cuboid(-7.0F, -63.0F, -10.0F, 5.0F, 6.0F, 9.0F, new Dilation(0.0F))
                .uv(264, 134).cuboid(-2.0F, -60.0F, -10.0F, 3.0F, 3.0F, 9.0F, new Dilation(0.0F))
                .uv(108, 147).cuboid(-4.0F, -27.0F, -16.0F, 10.0F, 27.0F, 17.0F, new Dilation(0.0F))
                .uv(162, 147).cuboid(-12.0F, -19.0F, -16.0F, 3.0F, 19.0F, 22.0F, new Dilation(0.0F))
                .uv(240, 212).cuboid(-8.0F, -47.0F, 2.0F, 11.0F, 32.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(30.0F, 0.0F, -14.0F));

        ModelPartData r_arm = MagmaGolem.addChild("r_arm", ModelPartBuilder.create().uv(160, 44).cuboid(9.0F, -19.0F, -16.0F, 3.0F, 19.0F, 22.0F, new Dilation(0.0F))
                .uv(54, 147).cuboid(-3.0F, -51.0F, -12.0F, 13.0F, 36.0F, 14.0F, new Dilation(0.0F))
                .uv(264, 122).cuboid(-1.0F, -60.0F, -10.0F, 3.0F, 3.0F, 9.0F, new Dilation(0.0F))
                .uv(200, 217).cuboid(-4.0F, -47.0F, -13.0F, 11.0F, 32.0F, 9.0F, new Dilation(0.0F))
                .uv(212, 147).cuboid(-2.0F, -57.0F, -11.0F, 10.0F, 29.0F, 11.0F, new Dilation(0.0F))
                .uv(126, 262).cuboid(0.0F, -66.0F, -9.0F, 6.0F, 9.0F, 7.0F, new Dilation(0.0F))
                .uv(186, 258).cuboid(2.0F, -63.0F, -10.0F, 5.0F, 6.0F, 9.0F, new Dilation(0.0F))
                .uv(88, 57).cuboid(-5.0F, -37.0F, -15.0F, 16.0F, 37.0F, 20.0F, new Dilation(0.0F))
                .uv(160, 0).cuboid(-6.0F, -27.0F, -16.0F, 10.0F, 27.0F, 17.0F, new Dilation(0.0F))
                .uv(0, 244).cuboid(-3.0F, -47.0F, 2.0F, 11.0F, 32.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-24.0F, 0.0F, -14.0F));

        ModelPartData head1 = MagmaGolem.addChild("Head", ModelPartBuilder.create().uv(44, 227).cuboid(0.0F, -48.0F, -25.0F, 5.0F, 1.0F, 17.0F, new Dilation(0.0F))
                .uv(0, 226).cuboid(-5.0F, -48.0F, -25.0F, 5.0F, 1.0F, 17.0F, new Dilation(0.0F))
                .uv(164, 116).cuboid(-7.0F, -47.0F, -26.0F, 7.0F, 9.0F, 22.0F, new Dilation(0.0F))
                .uv(164, 85).cuboid(0.0F, -47.0F, -26.0F, 7.0F, 9.0F, 22.0F, new Dilation(0.0F))
                .uv(214, 28).cuboid(0.0F, -35.0F, -26.0F, 7.0F, 2.0F, 14.0F, new Dilation(0.0F))
                .uv(222, 130).cuboid(-7.0F, -35.0F, -26.0F, 7.0F, 2.0F, 14.0F, new Dilation(0.0F))
                .uv(86, 104).cuboid(-1.0F, -36.0F, -26.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(86, 105).cuboid(0.0F, -36.0F, -26.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(58, 143).cuboid(2.0F, -36.0F, -26.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(82, 113).cuboid(1.0F, -38.0F, -26.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(78, 141).cuboid(4.0F, -38.0F, -26.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(66, 143).cuboid(5.0F, -36.0F, -26.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(264, 94).cuboid(0.0F, -33.0F, -22.0F, 5.0F, 2.0F, 10.0F, new Dilation(0.0F))
                .uv(264, 82).cuboid(-5.0F, -33.0F, -22.0F, 5.0F, 2.0F, 10.0F, new Dilation(0.0F))
                .uv(74, 140).cuboid(7.0F, -36.0F, -26.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(70, 140).cuboid(7.0F, -36.0F, -23.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(66, 140).cuboid(7.0F, -36.0F, -20.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(70, 137).cuboid(7.0F, -38.0F, -19.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(62, 137).cuboid(7.0F, -38.0F, -22.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(54, 137).cuboid(7.0F, -38.0F, -25.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(78, 142).cuboid(-6.0F, -38.0F, -26.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(54, 143).cuboid(-3.0F, -38.0F, -26.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(78, 140).cuboid(-4.0F, -36.0F, -26.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(62, 143).cuboid(-7.0F, -36.0F, -26.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F))
                .uv(82, 104).cuboid(-7.0F, -36.0F, -26.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(58, 140).cuboid(-7.0F, -38.0F, -25.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(54, 140).cuboid(-7.0F, -38.0F, -22.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(78, 137).cuboid(-7.0F, -38.0F, -19.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(58, 137).cuboid(-7.0F, -36.0F, -20.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F))
                .uv(82, 110).cuboid(-7.0F, -36.0F, -23.0F, 0.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(3.0F, 0.0F, 11.0F));

        ModelPartData l_leg = MagmaGolem.addChild("l_leg", ModelPartBuilder.create(), ModelTransform.pivot(7.0F, -20.0F, 39.0F));

        ModelPartData cube_r1 = l_leg.addChild("cube_r1", ModelPartBuilder.create().uv(58, 245).cuboid(4.0F, -2.4349F, -3.0194F, 10.0F, 14.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 9.0F, -8.0F, 0.3927F, 0.0F, 0.0F));

        ModelPartData cube_r2 = l_leg.addChild("cube_r2", ModelPartBuilder.create().uv(108, 191).cuboid(2.0F, -5.5168F, -4.3971F, 13.0F, 17.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, -7.0F, -0.1745F, 0.0F, 0.0F));

        ModelPartData l_shoulder = MagmaGolem.addChild("l_shoulder", ModelPartBuilder.create(), ModelTransform.pivot(7.0F, -36.0F, 15.0F));

        ModelPartData cube_r3 = l_shoulder.addChild("cube_r3", ModelPartBuilder.create().uv(252, 55).cuboid(-4.0F, 1.0F, -20.0F, 19.0F, 10.0F, 1.0F, new Dilation(0.0F))
                .uv(214, 14).cuboid(-4.0F, -3.0F, -16.0F, 22.0F, 2.0F, 12.0F, new Dilation(0.0F))
                .uv(0, 104).cuboid(-4.0F, -1.0F, -19.0F, 23.0F, 15.0F, 18.0F, new Dilation(0.0F))
                .uv(162, 188).cuboid(14.0F, 0.0F, -31.0F, 11.0F, 12.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

        ModelPartData r_leg = MagmaGolem.addChild("r_leg", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, -21.0F, 32.0F));

        ModelPartData cube_r4 = r_leg.addChild("cube_r4", ModelPartBuilder.create().uv(56, 197).cuboid(-15.0F, -5.5168F, -4.3971F, 13.0F, 17.0F, 13.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.0F));

        ModelPartData cube_r5 = r_leg.addChild("cube_r5", ModelPartBuilder.create().uv(24, 245).cuboid(-14.0F, -2.4349F, -3.0194F, 10.0F, 14.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 10.0F, -1.0F, 0.3927F, 0.0F, 0.0F));

        ModelPartData body = MagmaGolem.addChild("Body", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, -36.0F, 20.0F));

        ModelPartData cube_r6 = body.addChild("cube_r6", ModelPartBuilder.create().uv(108, 221).cuboid(0.0F, -5.0F, -17.0F, 6.0F, 8.0F, 17.0F, new Dilation(0.0F))
                .uv(218, 187).cuboid(-6.0F, -5.0F, -17.0F, 6.0F, 8.0F, 17.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

        ModelPartData cube_r7 = body.addChild("cube_r7", ModelPartBuilder.create().uv(222, 84).cuboid(0.0F, -3.0F, -17.0F, 4.0F, 6.0F, 17.0F, new Dilation(0.0F))
                .uv(222, 107).cuboid(-4.0F, -3.0F, -17.0F, 4.0F, 6.0F, 17.0F, new Dilation(0.0F))
                .uv(256, 28).cuboid(0.0F, -1.0F, -1.0F, 4.0F, 4.0F, 11.0F, new Dilation(0.0F))
                .uv(254, 162).cuboid(-4.0F, -1.0F, -1.0F, 4.0F, 4.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 7.0F, 13.0F, -0.48F, 0.0F, 0.0F));

        ModelPartData cube_r8 = body.addChild("cube_r8", ModelPartBuilder.create().uv(0, 52).cuboid(-4.0F, -3.0F, -4.0F, 9.0F, 17.0F, 35.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-13.0F, -3.0F, -4.0F, 9.0F, 17.0F, 35.0F, new Dilation(0.0F))
                .uv(240, 245).cuboid(-4.0F, -1.0F, 30.0F, 9.0F, 12.0F, 8.0F, new Dilation(0.0F))
                .uv(92, 246).cuboid(-13.0F, -1.0F, 30.0F, 9.0F, 12.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(4.0F, 0.0F, -5.0F, -0.5672F, 0.0F, 0.0F));

        ModelPartData r_shoulder = MagmaGolem.addChild("r_shoulder", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, -36.0F, 15.0F));

        ModelPartData cube_r9 = r_shoulder.addChild("cube_r9", ModelPartBuilder.create().uv(252, 44).cuboid(-15.0F, 1.0F, -20.0F, 19.0F, 10.0F, 1.0F, new Dilation(0.0F))
                .uv(0, 197).cuboid(-25.0F, 0.0F, -31.0F, 11.0F, 12.0F, 17.0F, new Dilation(0.0F))
                .uv(82, 114).cuboid(-19.0F, -1.0F, -19.0F, 23.0F, 15.0F, 18.0F, new Dilation(0.0F))
                .uv(214, 0).cuboid(-18.0F, -3.0F, -16.0F, 22.0F, 2.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 512, 512);
    }

    @Override
    public void setAngles(GolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(ModAnimations.WALKING, limbSwing, limbSwingAmount, 3f, 3f);
        this.updateAnimation(entity.idleAnimationState, ModAnimations.IDLE, ageInTicks, 1f);
        this.updateAnimation(entity.attackAnimationState, ModAnimations.ATTACK_L, ageInTicks, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30F, 30F);
        headPitch = MathHelper.clamp(headPitch, -25F, 45F);
        this.getPart().yaw = headYaw * 0.017453292F;
        this.getPart().pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        magmagolem.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart getPart() {
        return magmagolem;
    }
}