package net.markusmikk.tutorialmod.entity.custom;

import net.markusmikk.tutorialmod.entity.ai.GoblinAttackGoal;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class GoblinEntity extends HostileEntity {
    private static final TrackedData<Boolean> ATTACKING = DataTracker.registerData(GoblinEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private final Random random = new Random();

    private static float movement = 0.3f;

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public GoblinEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            this.idleAnimationTimeout--;
        }

        if (this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 10;  //....................................................................
            attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }

        if (!this.isAttacking()) {
            attackAnimationState.stop();
        }
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0F, 1.0F) : 0.0F;
        this.limbAnimator.updateLimbs(f, 0.2F);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient()) {
            setupAnimationStates();
        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));

        this.goalSelector.add(1, new GoblinAttackGoal(this, 1, false));

        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 4));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<>(this, AnimalEntity.class, true));

    }

    public static DefaultAttributeContainer.Builder createGoblinAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 15.0)
                .add(EntityAttributes.GENERIC_ARMOR, 0)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, movement)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 0.3F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0);
    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }


    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(ATTACKING, false);
    }


    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_RAVAGER_AMBIENT;
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_RAVAGER_ATTACK;
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_RAVAGER_DEATH;
    }
}
