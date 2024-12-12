package net.markusmikk.tutorialmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.markusmikk.tutorialmod.TutorialMod;
import net.markusmikk.tutorialmod.entity.custom.Desert_raiderEntity;
import net.markusmikk.tutorialmod.entity.custom.GoblinEntity;
import net.markusmikk.tutorialmod.entity.custom.GolemEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public  static  final EntityType<GolemEntity> GOLEM = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MOD_ID, "golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GolemEntity::new)
                    .dimensions(EntityDimensions.fixed(3f,3f)).build());  //mob hitbox size


    public  static  final EntityType<GoblinEntity> GOBLIN = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MOD_ID, "goblin"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GoblinEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f,1.5f)).build());  //mob hitbox size

    public  static  final EntityType<Desert_raiderEntity> Desert_raider = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MOD_ID, "desert_raider"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, Desert_raiderEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f,1.5f)).build());  //mob hitbox size
}
