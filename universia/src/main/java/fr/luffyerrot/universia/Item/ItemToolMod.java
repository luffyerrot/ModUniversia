package fr.luffyerrot.universia.Item;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemToolMod extends ItemTool {
	
	protected float efficiency;
    protected float attackDamage;
    protected float attackSpeed;
    protected Item.ToolMaterial toolMaterial;

    protected ItemToolMod(float attackDamageIn, float attackSpeedIn, Item.ToolMaterial materialIn, Set<Block> effectiveBlocksIn) {
		super(materialIn, effectiveBlocksIn);
		this.efficiency = 4.0F;
        this.toolMaterial = materialIn;
        this.maxStackSize = 1;
        this.setMaxDamage(materialIn.getMaxUses());
        this.efficiency = materialIn.getEfficiency();
        this.attackDamage = attackDamageIn + materialIn.getAttackDamage();
        this.attackSpeed = attackSpeedIn;
        this.setCreativeTab(CreativeTabs.TOOLS);
        if (this instanceof ItemFaucille)
        {
            toolClass = "faucille";
        }
	}
    
    protected ItemToolMod(Item.ToolMaterial materialIn, Set<Block> effectiveBlocksIn) {
    	this(0.0F, 0.0F, materialIn, effectiveBlocksIn);
    }
    
    @javax.annotation.Nullable
    private String toolClass;
    
    @Override
    public int getHarvestLevel(ItemStack stack, String toolClass, @javax.annotation.Nullable net.minecraft.entity.player.EntityPlayer player, @javax.annotation.Nullable IBlockState blockState)
    {
        int level = super.getHarvestLevel(stack, toolClass,  player, blockState);
        if (level == -1 && toolClass.equals(this.toolClass))
        {
            return this.toolMaterial.getHarvestLevel();
        }
        else
        {
            return level;
        }
    }

    @Override
    public Set<String> getToolClasses(ItemStack stack)
    {
        return toolClass != null ? com.google.common.collect.ImmutableSet.of(toolClass) : super.getToolClasses(stack);
    }
}
