package blackpi.org.rootkz.entities;

import blackpi.org.rootkz.Rootkz;
import blackpi.org.rootkz.entity.RastaEntity;


import net.minecraft.entity.EntityType;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntities {


    // Identificador
    public static final Identifier RASTA_ID =Identifier.of(Rootkz.MOD_ID, "rasta_man");

    // RegistryKey genérico requerido por .build()
    public static final RegistryKey<EntityType<?>> RASTA_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, RASTA_ID);

    public static  final EntityType<RastaEntity> RASTA = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Rootkz.MOD_ID, "rasta"),
            EntityType.Builder.create(RastaEntity::new,SpawnGroup.CREATURE).build(RASTA_KEY)
    );

    // Registro de la entidad
    public static void register() {


    }
}