package fr.luffyerrot.universia.Item;

import java.util.Set;

import com.google.common.collect.Sets;

import fr.luffyerrot.universia.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemFaucille extends ItemToolMod{
	
	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.DOUBLE_PLANT, Blocks.TALLGRASS, Blocks.CACTUS, Blocks.CARROTS, 
			Blocks.POTATOES, Blocks.BEETROOTS, Blocks.WHEAT, Blocks.LEAVES, Blocks.LEAVES2, Blocks.REEDS, Blocks.VINE, Blocks.WATERLILY, 
			Blocks.RED_FLOWER, Blocks.YELLOW_FLOWER, Blocks.CHORUS_FLOWER, Blocks.CHORUS_PLANT, ModBlocks.fraise_crop, ModBlocks.weed_crop, 
			ModBlocks.bulbe_crop);
    private static final float[] ATTACK_DAMAGES = new float[] {4.0F, 6.0F, 6.0F, 6.0F, 4.0F};
    private static final float[] ATTACK_SPEEDS = new float[] { -1.2F, -1.2F, -1.1F, -1.0F, -1.0F};

    public ItemFaucille(String name, Item.ToolMaterial material)
    {
    	super(material, EFFECTIVE_ON);
    	this.setUnlocalizedName(name);
    	this.setRegistryName(name);
    }
    
    protected ItemFaucille(Item.ToolMaterial material)
    {
        super(material, EFFECTIVE_ON);
        this.attackDamage = ATTACK_DAMAGES[material.ordinal()];
        this.attackSpeed = ATTACK_SPEEDS[material.ordinal()];
    }

    protected ItemFaucille(Item.ToolMaterial material, float damage, float speed)
    {
        super(material, EFFECTIVE_ON);
        this.attackDamage = damage;
        this.attackSpeed = speed;
    }

    public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.PLANTS && material != Material.VINE && material != Material.CACTUS && material != Material.CLOTH && material != Material.LEAVES ? super.getDestroySpeed(stack, state) : this.efficiency;
    }

}
