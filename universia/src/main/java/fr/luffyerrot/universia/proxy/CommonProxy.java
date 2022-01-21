package fr.luffyerrot.universia.proxy;

import fr.luffyerrot.universia.network.PacketHandler;
import fr.luffyerrot.universia.utils.Reference;

public class CommonProxy{

    public void preInit(){
    	PacketHandler.registerMessages(Reference.MODID);
    }

    public void init(){

    }

    public void postInit(){

    }

	public void render() {
		
	}
}
