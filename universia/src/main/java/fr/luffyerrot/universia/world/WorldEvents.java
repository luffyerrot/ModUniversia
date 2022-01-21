package fr.luffyerrot.universia.world;

import fr.luffyerrot.universia.init.ModBlocks;
import fr.luffyerrot.universia.init.ModItems;
import fr.luffyerrot.universia.init.ModPotions;
import net.minecraft.block.BlockCarrot;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockPotato;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class WorldEvents {
	
	@SubscribeEvent
	public static void playerEvent(PlayerTickEvent event) {

		for (int i = 0; i < event.player.inventory.mainInventory.size(); i++) {
			ItemStack item = event.player.inventory.mainInventory.get(i);
			if (item.getItem() == ModItems.taser) {
				if (item.isItemDamaged()) {
					item.setItemDamage(item.getItemDamage() - 1);
				}
			}
		}
		
		if(event.player.isPotionActive(ModPotions.DROGUE_EFFECT)) {
			event.player.cameraPitch = (float)Math.random() * 5;
			event.player.cameraPitch = (float)-Math.random() * 5;
			event.player.motionX += (float)Math.random() / 5;
			event.player.motionX -= (float)Math.random() / 5;
			event.player.motionZ += (float)Math.random() / 5;
			event.player.motionZ -= (float)Math.random() / 5;
		}
	}

	@SubscribeEvent
	public static void PlayerInteractEvent(PlayerInteractEvent e) {

		if (!e.getWorld().isRemote) {
			if (e.getWorld().getBlockState(e.getPos()).getBlock() == Blocks.CARROTS && ((BlockCarrot)Blocks.CARROTS).isMaxAge(e.getWorld().getBlockState(e.getPos()))) {
				e.getWorld().setBlockState(e.getPos(), Blocks.CARROTS.getDefaultState());
				e.getWorld().spawnEntity(new EntityItem(e.getWorld(), e.getPos().getX() + 0.5, e.getPos().getY() + 0.5, e.getPos().getZ() + 0.5, new ItemStack (Items.CARROT, 2)));
			} else if (e.getWorld().getBlockState(e.getPos()).getBlock() == Blocks.WHEAT && ((BlockCrops)Blocks.WHEAT).isMaxAge(e.getWorld().getBlockState(e.getPos()))) {
				e.getWorld().setBlockState(e.getPos(), Blocks.WHEAT.getDefaultState());
				e.getWorld().spawnEntity(new EntityItem(e.getWorld(), e.getPos().getX() + 0.5, e.getPos().getY() + 0.5, e.getPos().getZ() + 0.5, new ItemStack (Items.WHEAT, 1)));
			} else if (e.getWorld().getBlockState(e.getPos()).getBlock() == Blocks.POTATOES && ((BlockPotato)Blocks.POTATOES).isMaxAge(e.getWorld().getBlockState(e.getPos()))) {
				e.getWorld().setBlockState(e.getPos(), Blocks.POTATOES.getDefaultState());
				e.getWorld().spawnEntity(new EntityItem(e.getWorld(), e.getPos().getX() + 0.5, e.getPos().getY() + 0.5, e.getPos().getZ() + 0.5, new ItemStack (Items.POTATO, 2)));
			}
		}
	}	
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public static void onBlockDrop(BlockEvent.HarvestDropsEvent e) {
		if (e.getState().getBlock() == Blocks.CACTUS || e.getState().getBlock() == Blocks.CARROTS || 
				e.getState().getBlock() == Blocks.POTATOES || e.getState().getBlock() == Blocks.BEETROOTS || e.getState().getBlock() == Blocks.WHEAT || e.getState().getBlock() == Blocks.REEDS || 
				e.getState().getBlock() == Blocks.CHORUS_FLOWER || e.getState().getBlock() == Blocks.CHORUS_PLANT || 
				e.getState().getBlock() == ModBlocks.fraise_crop || e.getState().getBlock() == ModBlocks.weed_crop || e.getState().getBlock() == ModBlocks.bulbe_crop || e.getState().getBlock() == ModBlocks.coca_crop){
			if (!(e.getHarvester().getHeldItemMainhand().getItem() == ModItems.wood_faucille || e.getHarvester().getHeldItemMainhand().getItem() == ModItems.stone_faucille ||
					e.getHarvester().getHeldItemMainhand().getItem() == ModItems.iron_faucille || e.getHarvester().getHeldItemMainhand().getItem() == ModItems.gold_faucille ||
					e.getHarvester().getHeldItemMainhand().getItem() == ModItems.diamond_faucille || e.getHarvester().getHeldItemMainhand().getItem() == ModItems.torbenite_faucille)) {

				e.getDrops().clear();
			}
		}
	}
}
