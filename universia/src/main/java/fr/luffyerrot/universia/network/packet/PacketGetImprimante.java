package fr.luffyerrot.universia.network.packet;

import fr.luffyerrot.universia.TileEntity.TileEntityImprimante;
import fr.luffyerrot.universia.network.PacketHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PacketGetImprimante implements IMessage{

	private boolean messageValid;
	
	private BlockPos pos;
	private EnumFacing side;
	
	private String className;
	private String selectionFieldName;
	
	public PacketGetImprimante() {
		this.messageValid = false;
	}
	
	public PacketGetImprimante(BlockPos pos, EnumFacing side, String className, String selectionFieldName) {
		this.pos = pos;
		this.side = side;
		this.className = className;
		this.selectionFieldName = selectionFieldName;
		this.messageValid = true;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		try {
			this.pos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
			this.side = EnumFacing.byName(ByteBufUtils.readUTF8String(buf));
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
		if (!this.messageValid) {
			return;
		}
		buf.writeInt(pos.getX());
		buf.writeInt(pos.getY());
		buf.writeInt(pos.getZ());
		ByteBufUtils.writeUTF8String(buf, this.side.getName2());
		ByteBufUtils.writeUTF8String(buf, this.className);
		ByteBufUtils.writeUTF8String(buf, this.selectionFieldName);
	}

	public static class Handler implements IMessageHandler<PacketGetImprimante, IMessage> {

		@Override
		public IMessage onMessage(PacketGetImprimante message, MessageContext ctx) {
			if(!message.messageValid && ctx.side != Side.SERVER) {
				return null;
			}
			FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> processMessage(message, ctx)); 
			return null;
		}
		
		void processMessage(PacketGetImprimante message, MessageContext ctx) {
			TileEntityImprimante te = (TileEntityImprimante)ctx.getServerHandler().player.getServerWorld().getTileEntity(message.pos);
			if (te == null) {
				return;
			}
			PacketHandler.INSTANCE.sendTo(new PacketReturnImprimante(te.getSelection(), message.className, message.selectionFieldName), ctx.getServerHandler().player);
		}
	}
}
