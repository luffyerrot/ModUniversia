package fr.luffyerrot.universia.Events;

import fr.luffyerrot.universia.init.ModBlocks;
import fr.luffyerrot.universia.init.ModEntity;
import fr.luffyerrot.universia.init.ModFluids;
import fr.luffyerrot.universia.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RegisteringEvent {

    @SubscribeEvent
    public void onItemRegister(RegistryEvent.Register<Item> e){

        ModItems.init();
        ModEntity.registerEntities();
        e.getRegistry().registerAll(ModItems.getItems());
    }

    @SubscribeEvent
    public void onBlockRegister(RegistryEvent.Register<Block> e){

    	ModFluids.registerFluids();
        ModBlocks.init();
    }
}
