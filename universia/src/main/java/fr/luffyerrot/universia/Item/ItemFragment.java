package fr.luffyerrot.universia.Item;

import com.google.common.base.Predicate;
import fr.luffyerrot.universia.init.ModBlocks;
import fr.luffyerrot.universia.init.ModItems;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionUtils;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemFragment extends Item {


    @SuppressWarnings({ "unchecked", "rawtypes" })
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        List<EntityAreaEffectCloud> list = worldIn.<EntityAreaEffectCloud>getEntitiesWithinAABB(EntityAreaEffectCloud.class, playerIn.getEntityBoundingBox().grow(2.0D), new Predicate<EntityAreaEffectCloud>()
        {
            public boolean apply(@Nullable EntityAreaEffectCloud p_apply_1_)
            {
                return p_apply_1_ != null && p_apply_1_.isEntityAlive() && p_apply_1_.getOwner() instanceof EntityDragon;
            }
        });
        ItemStack itemstack = playerIn.getHeldItem(handIn);

        if (!list.isEmpty())
        {
            EntityAreaEffectCloud entityareaeffectcloud = list.get(0);
            entityareaeffectcloud.setRadius(entityareaeffectcloud.getRadius() - 0.5F);
            worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ITEM_BOTTLE_FILL_DRAGONBREATH, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            return new ActionResult(EnumActionResult.SUCCESS, this.turnBottleIntoItem(itemstack, playerIn, new ItemStack(Items.DRAGON_BREATH)));
        }
        else
        {
            RayTraceResult raytraceresult = this.rayTrace(worldIn, playerIn, true);

            if (raytraceresult == null)
            {
                return new ActionResult(EnumActionResult.PASS, itemstack);
            }
            else
            {
                if (raytraceresult.typeOfHit == RayTraceResult.Type.BLOCK)
                {
                    BlockPos blockpos = raytraceresult.getBlockPos();

                    if (!worldIn.isBlockModifiable(playerIn, blockpos) || !playerIn.canPlayerEdit(blockpos.offset(raytraceresult.sideHit), raytraceresult.sideHit, itemstack))
                    {
                        return new ActionResult(EnumActionResult.PASS, itemstack);
                    }

                    if (worldIn.getBlockState(blockpos).getBlock() == ModBlocks.flint_stone)
                    {
                        worldIn.playSound(playerIn, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.BLOCK_ANVIL_USE, SoundCategory.NEUTRAL, 1.0F, 1.0F);
                        return new ActionResult(EnumActionResult.SUCCESS, this.turnBottleIntoItem(itemstack, playerIn, PotionUtils.addPotionToItemStack(new ItemStack(ModItems.shard_torbenite), PotionTypes.WATER)));
                    }
                }
                return new ActionResult(EnumActionResult.PASS, itemstack);
            }
        }
    }

    protected ItemStack turnBottleIntoItem(ItemStack p_185061_1_, EntityPlayer player, ItemStack stack)
    {
        p_185061_1_.shrink(1);
        player.addStat(StatList.getObjectUseStats(this));

        if (p_185061_1_.isEmpty())
        {
            return stack;
        }
        else
        {
            if (!player.inventory.addItemStackToInventory(stack))
            {
                player.dropItem(stack, false);
            }

            return p_185061_1_;
        }
    }
}

