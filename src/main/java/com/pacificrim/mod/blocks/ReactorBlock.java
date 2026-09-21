package com.pacificrim.mod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.FurnaceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class ReactorBlock extends FurnaceBlock {
    public ReactorBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        // Логика активации реактора при установке
        if (!level.isClientSide) {
            level.updateNeighbourForOutputSignal(pos, this);
        }
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        super.onRemove(state, level, pos, newState, isMoving);
        // Логика безопасного отключения реактора
        if (!level.isClientSide && !newState.is(state.getBlock())) {
            // Взрыв при неправильном демонтаже (опционально)
            // level.explode(null, pos.getX(), pos.getY(), pos.getZ(), 5.0f, Level.ExplosionInteraction.TNT);
        }
    }
}
