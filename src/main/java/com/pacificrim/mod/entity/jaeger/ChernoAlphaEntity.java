package com.pacificrim.mod.entity.jaeger;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.Level;

public class ChernoAlphaEntity extends Mob {
    // Mark-1 Егерь, российский тяжелый танк
    private int armorIntegrity = 100;
    private boolean lightningMode = false;
    
    public ChernoAlphaEntity(EntityType<? extends Mob> entityType, Level level) {
        super(entityType, level);
    }

    public void setArmorIntegrity(int integrity) {
        this.armorIntegrity = Math.min(100, Math.max(0, integrity));
    }

    public int getArmorIntegrity() {
        return this.armorIntegrity;
    }

    public void activateLightningMode() {
        this.lightningMode = true;
        // Активация молниевых пушек
    }

    public boolean isLightningModeActive() {
        return this.lightningMode;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        // ИИ цели для Чернов Альфа
        // - Танкование урона
        // - Защита других Егерей
        // - Атака ближнего боя
    }
}
