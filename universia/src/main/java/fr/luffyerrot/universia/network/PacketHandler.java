package fr.luffyerrot.universia.network;

import fr.luffyerrot.universia.network.packet.PacketGetImprimante;
import fr.luffyerrot.universia.network.packet.PacketReturnImprimante;
import fr.luffyerrot.universia.network.packet.DoUpdateBlock;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {
	
	public static SimpleNetworkWrapper INSTANCE;
	
	private static int ID = 0;
	
	private static int nextID() {
		return ID++;
	}
	
	public static void registerMessages(String channelName) {
		INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);
		
		//server packets
		INSTANCE.registerMessage(DoUpdateBlock.Handler.class, DoUpdateBlock.class, nextID(), Side.SERVER);
		INSTANCE.registerMessage(PacketGetImprimante.Handler.class, PacketGetImprimante.class, nextID(), Side.SERVER);
		
		//client packets
		INSTANCE.registerMessage(PacketReturnImprimante.Handler.class, PacketReturnImprimante.class, nextID(), Side.CLIENT);
	}
}
