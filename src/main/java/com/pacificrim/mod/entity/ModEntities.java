package com.pacificrim.mod.entity;

import com.pacificrim.mod.PacificRimMod;
import com.pacificrim.mod.entity.jaeger.GipsyDangerEntity;
import com.pacificrim.mod.entity.jaeger.ChernoAlphaEntity;
import com.pacificrim.mod.entity.kaiju.LeatherbackEntity;
import com.pacificrim.mod.entity.kaiju.OtachiEntity;
import com.pacificrim.mod.entity.kaiju.SlatternEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.registries.DeferredRegister;
import net.neoforged.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = 
        DeferredRegister.createEntityTypes(PacificRimMod.MOD_ID);

    // Егери (Mark-1 to Mark-5)
    public static final RegistryObject<EntityType<GipsyDangerEntity>> GIPSY_DANGER = 
        ENTITY_TYPES.register("gipsy_danger", () -> EntityType.Builder.of(GipsyDangerEntity::new, MobCategory.MISC)
            .sized(4.0f, 12.0f)
            .clientTrackingRange(128)
            .build("gipsy_danger"));

    public static final RegistryObject<EntityType<ChernoAlphaEntity>> CHERNO_ALPHA = 
        ENTITY_TYPES.register("cherno_alpha", () -> EntityType.Builder.of(ChernoAlphaEntity::new, MobCategory.MISC)
            .sized(3.5f, 10.0f)
            .clientTrackingRange(128)
            .build("cherno_alpha"));

    // Кайдзю (Категории 1-5)
    public static final RegistryObject<EntityType<LeatherbackEntity>> LEATHERBACK = 
        ENTITY_TYPES.register("leatherback", () -> EntityType.Builder.of(LeatherbackEntity::new, MobCategory.MONSTER)
            .sized(5.0f, 8.0f)
            .clientTrackingRange(128)
            .build("leatherback"));

    public static final RegistryObject<EntityType<OtachiEntity>> OTACHI = 
        ENTITY_TYPES.register("otachi", () -> EntityType.Builder.of(OtachiEntity::new, MobCategory.MONSTER)
            .sized(6.0f, 7.0f)
            .clientTrackingRange(128)
            .build("otachi"));

    public static final RegistryObject<EntityType<SlatternEntity>> SLATTERN = 
        ENTITY_TYPES.register("slattern", () -> EntityType.Builder.of(SlatternEntity::new, MobCategory.MONSTER)
            .sized(8.0f, 12.0f)
            .clientTrackingRange(128)
            .build("slattern"));

    public static void register(IEventBus modEventBus) {
        ENTITY_TYPES.register(modEventBus);
    }
}
