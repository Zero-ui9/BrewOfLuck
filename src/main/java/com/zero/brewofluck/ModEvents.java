package com.zero.brewofluck;

import com.zero.brewofluck.items.ModItems;
import com.zero.brewofluck.potions.ModPotions;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.entity.living.LootingLevelEvent;

public class ModEvents {

    @SubscribeEvent
    public static void luckEffectLooting(LootingLevelEvent event) {
        if (event.getDamageSource().getEntity() instanceof LivingEntity mob) {
            int looting = event.getLootingLevel();
            if (mob.hasEffect(MobEffects.LUCK)) {
                int amp = mob.getEffect(MobEffects.LUCK).getAmplifier() + 1;
                looting += amp;
            }
            if (mob.hasEffect(MobEffects.UNLUCK)) {
                int amp = mob.getEffect(MobEffects.UNLUCK).getAmplifier() + 1;
                looting -= amp;
                if (looting < 0) {
                    looting = 0;
                }
            }
            event.setLootingLevel(looting);
        }
    }

    // Using some method to listen to the event
    @SubscribeEvent
    public static void registerBrewingRecipes(RegisterBrewingRecipesEvent event) {
        // Gets the builder to add recipes to
        PotionBrewing.Builder builder = event.getBuilder();

        // Will add brewing recipes for all container potions (e.g. potion, splash potion, lingering potion)
        builder.addMix(Potions.AWKWARD, ModItems.CLOVER.get(), Potions.LUCK);
        builder.addMix(Potions.LUCK, Items.REDSTONE, ModPotions.LUCK_BOOST);
        builder.addMix(Potions.LUCK, Items.RABBIT_FOOT, ModPotions.LUCK_AMP_1);
        builder.addMix(ModPotions.LUCK_BOOST, Items.RABBIT_FOOT, ModPotions.LUCK_AMP_1);
        builder.addMix(ModPotions.LUCK_AMP_1, Items.GLOWSTONE_DUST, ModPotions.LUCK_AMP_2);
        builder.addMix(Potions.LUCK, Items.FERMENTED_SPIDER_EYE, ModPotions.UNLUCK);
        builder.addMix(ModPotions.LUCK_BOOST, Items.FERMENTED_SPIDER_EYE, ModPotions.UNLUCK_BOOST);
        builder.addMix(ModPotions.LUCK_AMP_1, Items.FERMENTED_SPIDER_EYE, ModPotions.UNLUCK_AMP_1);
        builder.addMix(ModPotions.LUCK_AMP_2, Items.FERMENTED_SPIDER_EYE, ModPotions.UNLUCK_AMP_2);
        builder.addMix(ModPotions.UNLUCK, Items.REDSTONE, ModPotions.UNLUCK_BOOST);
        builder.addMix(ModPotions.UNLUCK, Items.RABBIT_FOOT, ModPotions.UNLUCK_AMP_1);
        builder.addMix(ModPotions.UNLUCK_BOOST, Items.RABBIT_FOOT, ModPotions.UNLUCK_AMP_1);
        builder.addMix(ModPotions.UNLUCK_AMP_1, Items.GLOWSTONE_DUST, ModPotions.LUCK_AMP_2);
    }

}
