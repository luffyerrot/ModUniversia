package fr.luffyerrot.universia.init;

import fr.luffyerrot.universia.universiaMod;
import fr.luffyerrot.universia.Entity.EntityBalle;
import fr.luffyerrot.universia.Entity.EntityBottle;
import fr.luffyerrot.universia.utils.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntity {

	public static void registerEntities() {
		registerProjectile("bottle", Reference.BOTTLE, EntityBottle.class, ModItems.bierevide);
		registerProjectile("balle", Reference.BALLE, EntityBalle.class, ModItems.balle);
	}
	
	@SuppressWarnings("unused")
	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, universiaMod.instance, range, 1, true, color1, color2);
	}
	
	@SuppressWarnings("unused")
	private static void registerEntity(String name, Class<? extends Entity> entity, int id) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MODID + ":" + name), entity, name, id, universiaMod.instance, 64, 20, true);
	}
	
	private static void registerProjectile(String name, int id, Class<? extends Entity> entity, Item item) {
		EntityRegistry.registerModEntity(new ResourceLocation(name), entity, name, id, universiaMod.instance, 64, 10, true);
	}
}
