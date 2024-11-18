package net.markusmikk.tutorialmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityType;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.markusmikk.tutorialmod.TutorialMod;
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
                    .dimensions(EntityDimensions.fixed(1f,1f)).build());
}
