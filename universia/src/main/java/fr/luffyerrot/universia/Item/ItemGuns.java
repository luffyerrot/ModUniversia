package fr.luffyerrot.universia.Item;

import fr.luffyerrot.universia.universiaMod;
import net.minecraft.item.Item;

public class ItemGuns extends Item {

    public ItemGuns(String name) {
        super();
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(universiaMod.creativeTabGuns);
    }
}
