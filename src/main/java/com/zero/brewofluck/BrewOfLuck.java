package com.zero.brewofluck;

import com.zero.brewofluck.items.ModItems;
import com.zero.brewofluck.loot.GlobalLootModifiers;
import com.zero.brewofluck.potions.ModPotions;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BrewOfLuck.MODID)
public class BrewOfLuck
{
    public static final String MODID = "brew_of_luck";
    //private static final Logger LOGGER = LogUtils.getLogger();

    public BrewOfLuck(IEventBus modEventBus)
    {

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);


        ModItems.register(modEventBus);
        ModPotions.register(modEventBus);
        GlobalLootModifiers.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        NeoForge.EVENT_BUS.register(ModEvents.class);
        modEventBus.register(ModClientEvents.class);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        //modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);


    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
    }
}
