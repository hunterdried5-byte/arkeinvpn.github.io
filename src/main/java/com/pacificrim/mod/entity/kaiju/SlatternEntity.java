package com.pacificrim.mod.entity.kaiju;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;

public class SlatternEntity extends Mob {
    // Кайдзю Категории 5, босс-монстр из Бездны
    private int toxicityLevel = 0;
    private boolean enraged = false;
    
    public SlatternEntity(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }

    public void addToxicity(int amount) {
        this.toxicityLevel = Math.min(100, this.toxicityLevel + amount);
        if (this.toxicityLevel >= 80) {
            this.enraged = true;
        }
    }

    public int getToxicityLevel() {
        return this.toxicityLevel;
    }

    public boolean isEnraged() {
        return this.enraged;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        // ИИ цели для Слэттерн
        // - Босс атаки
        // - Призыв меньших Кайдзю
        // - Токсичные атаки
        // - Разрушение всего на пути
    }
}
