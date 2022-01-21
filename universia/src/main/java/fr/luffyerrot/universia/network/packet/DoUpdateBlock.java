package fr.luffyerrot.universia.network.packet;

import fr.luffyerrot.universia.TileEntity.TileEntityImprimante;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class DoUpdateBlock implements IMessage {
	
	private BlockPos pos;
	private int selection;
	
	public DoUpdateBlock() {}
	
	public DoUpdateBlock(BlockPos pos, int select) {
		this.pos = pos;
		this.selection = select;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.pos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
		this.selection = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(pos.getX());
		buf.writeInt(pos.getY());
		buf.writeInt(pos.getZ());
		buf.writeInt(selection);
	}

	public static class Handler implements IMessageHandler<DoUpdateBlock, IMessage> {

		@Override
		public IMessage onMessage(DoUpdateBlock message, MessageContext ctx) {
			if(ctx.side == Side.SERVER) {
				TileEntity tile = ctx.getServerHandler().player.world.getTileEntity(message.pos);
				TileEntityImprimante imprimante = (TileEntityImprimante)tile;
				imprimante.setSelection(message.selection);
				ctx.getServerHandler().player.world.notifyBlockUpdate(message.pos, ctx.getServerHandler().player.world.getBlockState(message.pos), ctx.getServerHandler().player.world.getBlockState(message.pos), 1);;
			}
			return null;
		}
	}
}
