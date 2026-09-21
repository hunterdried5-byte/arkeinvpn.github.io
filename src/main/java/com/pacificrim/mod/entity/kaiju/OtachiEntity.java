package com.pacificrim.mod.entity.kaiju;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;

public class OtachiEntity extends Mob {
    // Кайдзю Категории 4, летающий монстр с кислотой
    private int acidLevel = 100;
    private boolean canFly = true;
    
    public OtachiEntity(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }

    public void setAcidLevel(int level) {
        this.acidLevel = Math.min(100, Math.max(0, level));
    }

    public int getAcidLevel() {
        return this.acidLevel;
    }

    public void spitAcid() {
        if (this.acidLevel >= 20) {
            this.acidLevel -= 20;
            // Плевок кислотой - урон и разрушение блоков
        }
    }

    public boolean canFly() {
        return this.canFly && this.acidLevel > 0;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        // ИИ цели для Отачи
        // - Полет и бомбардировка
        // - Кислотные атаки
        // - Поиск слабых мест Егерей
    }
}
