package com.zero.brewofluck.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.zero.brewofluck.items.ModItems;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;


public class AddItemModifier extends LootModifier {

    public static final MapCodec<AddItemModifier> CODEC = RecordCodecBuilder.mapCodec(inst -> codecStart(inst).apply(inst, AddItemModifier::new));

    public AddItemModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    public ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        generatedLoot.add(new ItemStack(ModItems.CLOVER.get(), 1));
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
