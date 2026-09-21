package com.pacificrim.mod.blocks;

import com.pacificrim.mod.PacificRimMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.registries.DeferredRegister;
import net.neoforged.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PacificRimMod.MOD_ID);

    // Блоки ресурсов Кайдзю
    public static final RegistryObject<Block> KAIJU_BONE_BLOCK = registerBlock("kaiju_bone_block", 
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK).strength(5.0f, 10.0f)));
    
    public static final RegistryObject<Block> KAIJU_ORGAN_BLOCK = registerBlock("kaiju_organ_block", 
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SLIME_BLOCK).strength(3.0f)));
    
    public static final RegistryObject<Block> BLUE_KAIJU_BLOOD_BLOCK = registerBlock("blue_kaiju_blood_block", 
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.LAPIS_BLOCK).strength(4.0f)));

    // Блоки Егерей
    public static final RegistryObject<Block> KAIJU_ALLOY_BLOCK = registerBlock("kaiju_alloy_block", 
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).strength(6.0f, 15.0f)));
    
    public static final RegistryObject<Block> JAEGERS_CORE_BLOCK = registerBlock("jaegers_core_block", 
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.BEACON).strength(10.0f, 20.0f).lightLevel(state -> 15)));
    
    public static final RegistryObject<Block> REACTOR_BLOCK = registerBlock("reactor_block", 
        () -> new ReactorBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FURNACE).strength(8.0f, 20.0f).lightLevel(state -> 12)));

    // Технические блоки
    public static final RegistryObject<Block> DRIFT_CHAMBER_BLOCK = registerBlock("drift_chamber_block", 
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OBSIDIAN).strength(15.0f, 50.0f)));
    
    public static final RegistryObject<Block> LAUNCH_PAD_BLOCK = registerBlock("launch_pad_block", 
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.HEAVY_CORE).strength(10.0f, 30.0f)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
