package fr.luffyerrot.universia.Entity;

import fr.luffyerrot.universia.init.ModBlocks;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityBottle extends EntityThrowable {

	public EntityBottle(World worldIn) {
		super(worldIn);
	}
	
	public EntityBottle(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}
	
	public EntityBottle(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	@Override
	protected void onImpact(RayTraceResult result) {

		if (!this.world.isRemote) {
			setDead();
			 if (result.entityHit != null) {
				if (result.entityHit instanceof EntityLivingBase) {
					EntityLivingBase entity = (EntityLivingBase)result.entityHit;
					entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.thrower), 2.0F);
					entity.addPotionEffect(new PotionEffect(MobEffects.POISON, 40, 1));
					world.playSound(null, entity.getPosition(), SoundEvents.BLOCK_GLASS_HIT, SoundCategory.PLAYERS, 1.0F, 1.0F);
				}
			} else {
				if (world.getBlockState(new BlockPos(result.getBlockPos().getX(), result.getBlockPos().getY() + 1, result.getBlockPos().getZ())).getBlock() == Blocks.AIR) {

					world.setBlockState(new BlockPos(result.getBlockPos().getX(), result.getBlockPos().getY() + 1, result.getBlockPos().getZ()), Blocks.FIRE.getDefaultState(), 11);
				}
				if (world.getBlockState(new BlockPos(result.getBlockPos().getX(), result.getBlockPos().getY() + 1, result.getBlockPos().getZ())).getBlock() == ModBlocks.essence) {

					world.setBlockState(new BlockPos(result.getBlockPos().getX(), result.getBlockPos().getY() + 2, result.getBlockPos().getZ()), Blocks.FIRE.getDefaultState(), 11);
				}
				
				world.playSound(null, result.getBlockPos(), SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.PLAYERS, 1.0F, 1.0F);
			}
		}
	}
}
