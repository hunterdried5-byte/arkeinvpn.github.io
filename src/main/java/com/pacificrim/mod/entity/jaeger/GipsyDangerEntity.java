package com.pacificrim.mod.entity.jaeger;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;

public class GipsyDangerEntity extends Mob {
    // Mark-3 Егерь, основной герой фильма
    private int driftCompatibility = 0;
    private boolean nuclearMode = false;
    
    public GipsyDangerEntity(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }

    public void setDriftCompatibility(int compatibility) {
        this.driftCompatibility = Math.min(100, Math.max(0, compatibility));
    }

    public int getDriftCompatibility() {
        return this.driftCompatibility;
    }

    public void activateNuclearMode() {
        this.nuclearMode = true;
        // Увеличение силы и скорости в ядерном режиме
        this.setSpeed((float) (this.getSpeed() * 1.5));
    }

    public boolean isNuclearModeActive() {
        return this.nuclearMode;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        // ИИ цели для Гипси Дэнжер
        // - Защита пилотов
        // - Атака Кайдзю
        // - Патрулирование зоны
    }
}
