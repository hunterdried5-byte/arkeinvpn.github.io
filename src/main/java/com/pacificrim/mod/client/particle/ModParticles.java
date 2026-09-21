package com.pacificrim.mod.client.particle;

import com.pacificrim.mod.PacificRimMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.registries.RegistryObject;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = 
        DeferredRegister.createParticleTypes(PacificRimMod.MOD_ID);

    // 8 типов микрочастиц для фильма "Тихоокеанский рубеж"
    
    // Частицы Егерей
    public static final RegistryObject<SimpleParticleType> JAEGERS_EXHAUST = 
        PARTICLE_TYPES.register("jaegers_exhaust", () -> new SimpleParticleType(true));
    
    public static final RegistryObject<SimpleParticleType> PLASMA_TRAIL = 
        PARTICLE_TYPES.register("plasma_trail", () -> new SimpleParticleType(true));
    
    // Частицы Дрейфа
    public static final RegistryObject<SimpleParticleType> DRIFT_CONNECTION = 
        PARTICLE_TYPES.register("drift_connection", () -> new SimpleParticleType(true));
    
    // Частицы Кайдзю
    public static final RegistryObject<SimpleParticleType> KAIJU_SLIME = 
        PARTICLE_TYPES.register("kaiju_slime", () -> new SimpleParticleType(true));
    
    public static final RegistryObject<SimpleParticleType> BLUE_BLOOD = 
        PARTICLE_TYPES.register("blue_blood", () -> new SimpleParticleType(true));
    
    // ЭМИ и боевые эффекты
    public static final RegistryObject<SimpleParticleType> EMP_WAVE = 
        PARTICLE_TYPES.register("emp_wave", () -> new SimpleParticleType(true));
    
    public static final RegistryObject<SimpleParticleType> SWORD_SPARKS = 
        PARTICLE_TYPES.register("sword_sparks", () -> new SimpleParticleType(true));
    
    public static final RegistryObject<SimpleParticleType> PLASMA_EXPLOSION = 
        PARTICLE_TYPES.register("plasma_explosion", () -> new SimpleParticleType(true));

    public static void register(IEventBus modEventBus) {
        PARTICLE_TYPES.register(modEventBus);
    }
}
