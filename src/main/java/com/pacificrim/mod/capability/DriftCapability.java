package com.pacificrim.mod.capability;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.common.util.LazyOptional;
import net.neoforged.neoforge.attachments.IAttachmentHolder;
import net.neoforged.neoforge.attachments.AttachmentSerializer;
import net.neoforged.neoforge.attachments.IAttachment;

/**
 * Система Дрейфа - нейронная синхронизация пилотов Егерей
 * Из фильма "Тихоокеанский рубеж"
 */
public class DriftCapability implements IAttachment, INBTSerializable<CompoundTag> {
    
    private int driftCompatibility = 0; // 0-100%
    private boolean isSyncing = false;
    private boolean driftReady = false;
    private int neuralHandshakes = 0;
    private double ponsLevel = 0.0; // Уровень подключения Pons
    
    public DriftCapability() {}
    
    // Проверка совместимости пилотов
    public void startDriftSync() {
        this.isSyncing = true;
        this.driftCompatibility = 0;
    }
    
    // Обновление прогресса синхронизации
    public void updateSyncProgress(int progress) {
        if (this.isSyncing) {
            this.driftCompatibility = Math.min(100, progress);
            
            if (this.driftCompatibility >= 85) {
                this.driftReady = true;
                this.isSyncing = false;
            }
        }
    }
    
    // Завершение Дрейфа
    public void completeDrift() {
        this.isSyncing = false;
        if (this.driftCompatibility >= 85) {
            this.driftReady = true;
            this.neuralHandshakes++;
        }
    }
    
    // Сброс Дрейфа
    public void resetDrift() {
        this.isSyncing = false;
        this.driftReady = false;
        this.driftCompatibility = 0;
    }
    
    // Геттеры
    public int getDriftCompatibility() {
        return this.driftCompatibility;
    }
    
    public boolean isSyncing() {
        return this.isSyncing;
    }
    
    public boolean isDriftReady() {
        return this.driftReady;
    }
    
    public int getNeuralHandshakes() {
        return this.neuralHandshakes;
    }
    
    public double getPonsLevel() {
        return this.ponsLevel;
    }
    
    public void setPonsLevel(double level) {
        this.ponsLevel = Math.min(1.0, Math.max(0.0, level));
    }
    
    // Серилизация для сохранения
    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        tag.putInt("DriftCompatibility", this.driftCompatibility);
        tag.putBoolean("IsSyncing", this.isSyncing);
        tag.putBoolean("DriftReady", this.driftReady);
        tag.putInt("NeuralHandshakes", this.neuralHandshakes);
        tag.putDouble("PonsLevel", this.ponsLevel);
        return tag;
    }
    
    // Десериализация при загрузке
    @Override
    public void deserializeNBT(CompoundTag tag) {
        this.driftCompatibility = tag.getInt("DriftCompatibility");
        this.isSyncing = tag.getBoolean("IsSyncing");
        this.driftReady = tag.getBoolean("DriftReady");
        this.neuralHandshakes = tag.getInt("NeuralHandshakes");
        this.ponsLevel = tag.getDouble("PonsLevel");
    }
}
