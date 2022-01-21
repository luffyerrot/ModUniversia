package fr.luffyerrot.universia.Entity;

import fr.luffyerrot.universia.Handlers.SoundHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityBalle extends EntityThrowable {

	public EntityBalle(World worldIn) {
		super(worldIn);
	}
	
	public EntityBalle(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
	}
	
	public EntityBalle(World worldIn, double x, double y, double z) {
		super(worldIn, x, y, z);
	}

	@Override
	protected void onImpact(RayTraceResult result) {

		if (!this.world.isRemote) {
			setDead();
			 if (result.entityHit != null) {
				if (result.entityHit instanceof EntityLivingBase) {
					EntityLivingBase entity = (EntityLivingBase)result.entityHit;
					entity.attackEntityFrom(DamageSource.causeThrownDamage(this, this.thrower), 0.1F);
					entity.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, 1200, 1));
					entity.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 1200, 10));
					entity.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, 1200, 10));
					entity.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 1200, 250));
					world.playSound(null, entity.getPosition(), SoundHandler.TASER_HIT_ENTITY, SoundCategory.PLAYERS, 1.0F, 1.0F);
				}
			} else {
				world.playSound(null, result.getBlockPos(), SoundHandler.TASER_HIT, SoundCategory.PLAYERS, 1.0F, 1.0F);
			}
		}
	}
}
