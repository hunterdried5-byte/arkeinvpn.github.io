package com.pacificrim.mod.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ChainSwordItem extends Item {
    public ChainSwordItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            // Логика атаки цепным мечом - мощный удар по области
            double range = 4.0;
            double damage = 15.0;
            
            level.getEntitiesOfClass(net.minecraft.world.entity.Entity.class, 
                player.getBoundingBox().inflate(range))
                .forEach(entity -> {
                    if (entity != player && !(entity instanceof Player)) {
                        entity.hurt(level.damageSources().playerAttack(player), (float) damage);
                        // Отбрасывание
                        entity.push(
                            (entity.getX() - player.getX()) * 0.5,
                            0.3,
                            (entity.getZ() - player.getZ()) * 0.5
                        );
                    }
                });
        }
        
        // Создание частиц искр на клиенте
        if (level.isClientSide) {
            for (int i = 0; i < 20; i++) {
                double offsetX = (level.random.nextDouble() - 0.5) * 3;
                double offsetY = (level.random.nextDouble() - 0.5) * 3;
                double offsetZ = (level.random.nextDouble() - 0.5) * 3;
                
                level.addParticle(
                    net.minecraft.core.particles.ParticleTypes.SPARK,
                    player.getX() + offsetX,
                    player.getY() + 1 + offsetY,
                    player.getZ() + offsetZ,
                    0, 0, 0
                );
            }
        }
        
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
