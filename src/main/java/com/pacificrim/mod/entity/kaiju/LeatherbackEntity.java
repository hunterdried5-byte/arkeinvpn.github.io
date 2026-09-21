package com.pacificrim.mod.entity.kaiju;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;

public class LeatherbackEntity extends Mob {
    // Кайдзю Категории 4, электромагнитный монстр
    private int emCharge = 0;
    private boolean emPulseActive = false;
    
    public LeatherbackEntity(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }

    public void addEMCharge(int charge) {
        this.emCharge = Math.min(100, this.emCharge + charge);
    }

    public int getEMCharge() {
        return this.emCharge;
    }

    public void activateEMPulse() {
        if (this.emCharge >= 50) {
            this.emPulseActive = true;
            this.emCharge -= 50;
            // ЭМИ эффект - отключение техники вокруг
        }
    }

    public boolean isEMPulseActive() {
        return this.emPulseActive;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        // ИИ цели для Лезербека
        // - Атака Егерей
        // - Генерация ЭМИ
        // - Разрушение зданий
    }
}
