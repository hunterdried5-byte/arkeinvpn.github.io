package com.pacificrim.mod.items;

import com.pacificrim.mod.PacificRimMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.registries.DeferredRegister;
import net.neoforged.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PacificRimMod.MOD_ID);

    // Ресурсы Кайдзю
    public static final RegistryObject<Item> KAIJU_BONE = ITEMS.register("kaiju_bone", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KAIJU_ORGAN = ITEMS.register("kaiju_organ", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KAIJU_BLOOD_BLUE = ITEMS.register("kaiju_blood_blue", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KAIJU_AMNIOTIC_FLUID = ITEMS.register("kaiju_amniotic_fluid", () -> new Item(new Item.Properties()));
    
    // Ресурсы Егерей
    public static final RegistryObject<Item> JAEGERS_CORE = ITEMS.register("jaegers_core", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KAIJU_ALLOY = ITEMS.register("kaiju_alloy", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NEURAL_LINK_CHIP = ITEMS.register("neural_link_chip", () -> new Item(new Item.Properties()));
    
    // Оружие Егерей
    public static final RegistryObject<Item> CHAIN_SWORD = ITEMS.register("chain_sword", () -> new ChainSwordItem(new Item.Properties().durability(2048)));
    public static final RegistryObject<Item> PLASMA_CASTER = ITEMS.register("plasma_caster", () -> new PlasmaCasterItem(new Item.Properties().durability(1024)));
    
    // Предметы Дрейфа
    public static final RegistryObject<Item> DRIFT_COMPATIBILITY_TEST = ITEMS.register("drift_compatibility_test", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NEURAL_HANDSHAKE_DEVICE = ITEMS.register("neural_handshake_device", () -> new Item(new Item.Properties()));
    
    // Ключи и детали
    public static final RegistryObject<Item> GIPSY_DANGER_KEY = ITEMS.register("gipsy_danger_key", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHERNO_ALPHA_KEY = ITEMS.register("cherno_alpha_key", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> REACTOR_CORE = ITEMS.register("reactor_core", () -> new Item(new Item.Properties()));
    
    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
