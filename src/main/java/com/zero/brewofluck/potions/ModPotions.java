package com.zero.brewofluck.potions;

import com.zero.brewofluck.BrewOfLuck;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModPotions {

    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, BrewOfLuck.MODID);

    public static final Holder<Potion> UNLUCK = POTIONS.register("unluck_potion", () -> new Potion(new MobEffectInstance(MobEffects.UNLUCK, 6000, 0, false, true)));
    public static final Holder<Potion> UNLUCK_BOOST = POTIONS.register("unluck_potion_long", () -> new Potion(new MobEffectInstance(MobEffects.UNLUCK, 12000, 0, false, true)));
    public static final Holder<Potion> UNLUCK_AMP_1 = POTIONS.register("unluck_potion_strong", () -> new Potion(new MobEffectInstance(MobEffects.UNLUCK, 4000, 1, false, true)));
    public static final Holder<Potion> UNLUCK_AMP_2 = POTIONS.register("unluck_potion_stronger", () -> new Potion(new MobEffectInstance(MobEffects.UNLUCK, 4000, 2, false, true)));
    public static final Holder<Potion> LUCK_BOOST = POTIONS.register("luck_potion_long", () -> new Potion(new MobEffectInstance(MobEffects.LUCK, 12000, 0, false, true)));
    public static final Holder<Potion> LUCK_AMP_1 = POTIONS.register("luck_potion_strong", () -> new Potion(new MobEffectInstance(MobEffects.LUCK, 4000, 1, false, true)));
    public static final Holder<Potion> LUCK_AMP_2 = POTIONS.register("luck_potion_stronger", () -> new Potion(new MobEffectInstance(MobEffects.LUCK, 4000, 2, false, true)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

}

