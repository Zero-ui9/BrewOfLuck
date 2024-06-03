package com.zero.brewofluck.loot;

import com.mojang.serialization.MapCodec;
import com.zero.brewofluck.BrewOfLuck;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GlobalLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLM =
            DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, BrewOfLuck.MODID);

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<AddItemModifier>> ADD_ITEM = GLM.register("add_item", () -> AddItemModifier.CODEC);

    public static void register(IEventBus eventBus) {
        GLM.register(eventBus);
    }
}
