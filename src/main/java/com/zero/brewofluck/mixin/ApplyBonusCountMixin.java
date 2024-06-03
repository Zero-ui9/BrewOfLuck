package com.zero.brewofluck.mixin;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(value = ApplyBonusCount.class, priority = 1001)
public class ApplyBonusCountMixin {

    @ModifyVariable(method = "Lnet/minecraft/world/level/storage/loot/functions/ApplyBonusCount;run(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/level/storage/loot/LootContext;)Lnet/minecraft/world/item/ItemStack;",
            at = @At(value = "INVOKE_ASSIGN", ordinal = 2),
            ordinal = 0
    )
    int limeAuraModifier(int i, ItemStack pStack, LootContext pContext) {
        Entity entity = pContext.getParamOrNull(LootContextParams.THIS_ENTITY);
        if (entity instanceof LivingEntity mob) {
            if (mob.hasEffect(MobEffects.LUCK)) {
                int amp = mob.getEffect(MobEffects.LUCK).getAmplifier() + 1;
                i += amp;
            }
            if (mob.hasEffect(MobEffects.UNLUCK)) {
                int amp = mob.getEffect(MobEffects.UNLUCK).getAmplifier() + 1;
                i -= amp;
                if (i < 0) {
                    i = 0;
                }
            }
        }
        return i;
    }
}