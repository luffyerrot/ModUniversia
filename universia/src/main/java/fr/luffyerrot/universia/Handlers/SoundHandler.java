package fr.luffyerrot.universia.Handlers;

import fr.luffyerrot.universia.utils.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundHandler {

    public static SoundEvent IMPRIMANTE_ON, IMPRIMANTE_END, TASER_SHOT, TASER_HIT, TASER_HIT_ENTITY;

    public static void registerSounds(){

        IMPRIMANTE_ON = registerSound("block.imprimante.on");
        IMPRIMANTE_END = registerSound("block.imprimante.end");
        TASER_SHOT = registerSound("item.taser.taser1");
        TASER_HIT_ENTITY = registerSound("item.taser.taser2");
        TASER_HIT = registerSound("item.taser.taser3");
    }

    private static SoundEvent registerSound(String name){

        ResourceLocation location = new ResourceLocation(Reference.MODID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
