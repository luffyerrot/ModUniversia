package fr.luffyerrot.universia.network.packet;

import java.lang.reflect.Field;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PacketReturnImprimante implements IMessage {

	private boolean messageValid;
	
	private int selection;

	private String className;
	private String selectionFieldName;
	
	public PacketReturnImprimante() {
		this.messageValid = false;
	}
	
	public PacketReturnImprimante(int selection, String className, String selectionFieldName) {
		this.selection = selection;
		this.className = className;
		this.selectionFieldName = selectionFieldName;
		this.messageValid = true;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		try {
			this.selection = buf.readInt();
			this.className = ByteBufUtils.readUTF8String(buf);
			this.selectionFieldName = ByteBufUtils.readUTF8String(buf);
		} catch (IndexOutOfBoundsException ioe) {
			System.out.println("erreur : " + ioe.getMessage());
			return;
		}
		this.messageValid = true;
	}

	@Override
	public void toBytes(ByteBuf buf) {
		if(!this.messageValid) {
			return;
		}
		buf.writeInt(this.selection);
		ByteBufUtils.writeUTF8String(buf, this.className);
		ByteBufUtils.writeUTF8String(buf, this.selectionFieldName);
	}
	
	public static class Handler implements IMessageHandler<PacketReturnImprimante, IMessage> {

		@Override
		public IMessage onMessage(PacketReturnImprimante message, MessageContext ctx) {
			if(!message.messageValid && ctx.side != Side.CLIENT) {
				return null;
			}
			Minecraft.getMinecraft().addScheduledTask(() -> processMessage(message));
			return null;
		}
		
		@SuppressWarnings("rawtypes")
		void processMessage(PacketReturnImprimante message) {
			try {
				Class clazz = Class.forName(message.className);
				Field selectionField = clazz.getDeclaredField(message.selectionFieldName);
				selectionField.setInt(clazz, message.selection);
			} catch (Exception e) {
				System.out.println("erreur : " + e.getMessage());
			}
		}
		
	}
}
