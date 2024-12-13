package net.markusmikk.tutorialmod.entity.custom;

import jdk.jfr.Event;
import net.markusmikk.tutorialmod.entity.ai.Desert_raiderAttackGoal;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class Desert_raiderEntity extends HostileEntity {
    private static final TrackedData<Boolean> ATTACKING = DataTracker.registerData(Desert_raiderEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    private final Random random = new Random();

//----------------------DAMAGE------------------------------------
    private boolean recentlyDamaged = false;

    // Call this method whenever the entity takes damage
    @Override
    public boolean damage(DamageSource source, float amount) {
        boolean result = super.damage(source, amount);

        if (source.getAttacker() instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) source.getAttacker();

            // Ensure the player is a server player before adding to the boss bar
            if (player instanceof ServerPlayerEntity) {
                ServerPlayerEntity serverPlayer = (ServerPlayerEntity) player;
                this.bossBar.addPlayer(serverPlayer);
            }
        }

        // Set the recently damaged flag to true
        recentlyDamaged = true;

        // Optionally reset the flag after some time if you only want to play the animation for a short time
        // You can use a cooldown timer or check the ageInTicks to reset it
        return result;
    }

    public boolean hasTakenDamage() {
        return recentlyDamaged;
    }

    // Reset the flag in the tick or update method to stop playing the damage animation
    public void resetDamageFlag() {
        recentlyDamaged = false;
    }

//----------------------------BOSS BAR---------------------------------------

    private final ServerBossBar bossBar = (ServerBossBar)new ServerBossBar(Text.of(""), BossBar.Color.YELLOW, BossBar.Style.PROGRESS).setDarkenSky(true).setThickenFog(true);

//    @Override
//    public void onStartedTrackingBy(ServerPlayerEntity player) {
//        this.bossBar.addPlayer(player);
//    }

    @Override
    public void onStoppedTrackingBy(ServerPlayerEntity player) {
        super.onStoppedTrackingBy(player);
        this.bossBar.removePlayer(player);
    }

    @Override
    protected void mobTick() {
        this.bossBar.setPercent(this.getHealth() / this.getMaxHealth());
    }


    //----------------------------------------------------------------------------------
    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public Desert_raiderEntity(EntityType<? extends HostileEntity> entityType, World world) {
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

        this.goalSelector.add(1, new Desert_raiderAttackGoal(this, 1, false));


        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 4));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(1, new RevengeGoal(this));

    }

    public static DefaultAttributeContainer.Builder createDesert_raiderAttributes() {
        float movement = 0.2f;
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 400)
                .add(EntityAttributes.GENERIC_ARMOR, 15)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, movement)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 10F)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 5.0);
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
