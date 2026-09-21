package com.pacificrim.mod;

import com.mojang.logging.LogUtils;
import com.pacificrim.mod.blocks.ModBlocks;
import com.pacificrim.mod.entity.ModEntities;
import com.pacificrim.mod.items.ModItems;
import com.pacificrim.mod.client.particle.ModParticles;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.slf4j.Logger;

@Mod(PacificRimMod.MOD_ID)
public class PacificRimMod {
    public static final String MOD_ID = "pacificrim";
    private static final Logger LOGGER = LogUtils.getLogger();

    public PacificRimMod(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        
        // Регистрация всего контента мода
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntities.register(modEventBus);
        ModParticles.register(modEventBus);
        
        LOGGER.info("Pacific Rim Mod загружен! Добро пожаловать в войну против Кайдзю.");
        LOGGER.info("Доступные Егери: Gipsy Danger, Cherno Alpha");
        LOGGER.info("Доступные Кайдзю: Leatherback, Otachi, Slattern");
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            LOGGER.info("Инициализация механик Тихоокеанской войны...");
            LOGGER.info("Система Дрейфа готова к синхронизации пилотов");
        });
    }

    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                LOGGER.info("Клиентская настройка частиц и рендеринга Егерей...");
                LOGGER.info("Загрузка 8 типов микрочастиц: выхлоп, плазма, дрейф, слизь, кровь, ЭМИ, искры, взрывы");
            });
        }
    }
}
