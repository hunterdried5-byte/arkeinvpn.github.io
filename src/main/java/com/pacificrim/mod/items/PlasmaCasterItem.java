package com.pacificrim.mod.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PlasmaCasterItem extends Item {
    public PlasmaCasterItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            // Логика выстрела плазменной пушкой
            double damage = 25.0;
            double range = 50.0;
            
            // Получаем направление взгляда игрока
            var lookVector = player.getViewVector(1.0f);
            
            // Проверяем попадания по прямой
            for (double dist = 0; dist < range; dist += 2.0) {
                double x = player.getX() + lookVector.x * dist;
                double y = player.getEyeY() + lookVector.y * dist;
                double z = player.getZ() + lookVector.z * dist;
                
                level.getEntitiesOfClass(net.minecraft.world.entity.Entity.class, 
                    net.minecraft.world.phys.AABB.ofSize(x, y, z, 2.0, 2.0, 2.0))
                    .forEach(entity -> {
                        if (entity != player && !(entity instanceof Player)) {
                            entity.hurt(level.damageSources().playerAttack(player), (float) damage);
                            // Поджигание
                            entity.setSecondsOnFire(5);
                            // Отбрасывание
                            entity.push(lookVector.x * 2, 0.5, lookVector.z * 2);
                        }
                    });
            }
        }
        
        // Создание частиц плазмы на клиенте
        if (level.isClientSide) {
            var lookVector = player.getViewVector(1.0f);
            for (int i = 0; i < 30; i++) {
                double dist = i * 1.5;
                double x = player.getEyeX() + lookVector.x * dist;
                double y = player.getEyeY() + lookVector.y * dist;
                double z = player.getEyeZ() + lookVector.z * dist;
                
                double spreadX = (level.random.nextDouble() - 0.5) * 0.5;
                double spreadY = (level.random.nextDouble() - 0.5) * 0.5;
                double spreadZ = (level.random.nextDouble() - 0.5) * 0.5;
                
                level.addParticle(
                    net.minecraft.core.particles.ParticleTypes.END_ROD,
                    x + spreadX, y + spreadY, z + spreadZ,
                    lookVector.x * 0.1, lookVector.y * 0.1, lookVector.z * 0.1
                );
            }
        }
        
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
