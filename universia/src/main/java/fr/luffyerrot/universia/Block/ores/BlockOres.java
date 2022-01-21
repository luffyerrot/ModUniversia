package fr.luffyerrot.universia.Block.ores;

import fr.luffyerrot.universia.init.ModBlocks;
import fr.luffyerrot.universia.init.ModItems;
import net.minecraft.block.BlockOre;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockOres extends BlockOre {
	
    public BlockOres(MapColor color)
    {
        super(color);
        setHarvestLevel("pickaxe", 2);
        setHardness(10F);
        setResistance(4F);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        if (this == ModBlocks.ore_torbenite) {
            return ModItems.fragment_torbenite;
        }
        if (this == ModBlocks.topaz_ore) {
            return Item.getItemFromBlock(ModBlocks.topaz_ore);
        }
        if (this == ModBlocks.saphir_ore) {
            return Item.getItemFromBlock(ModBlocks.saphir_ore);
        }
        if (this == ModBlocks.rubis_ore) {
            return Item.getItemFromBlock(ModBlocks.rubis_ore);
        }
        if (this == ModBlocks.amethyst_ore) {
            return Item.getItemFromBlock(ModBlocks.amethyst_ore);
        }
        if (this == ModBlocks.kunzite_ore) {
            return Item.getItemFromBlock(ModBlocks.kunzite_ore);
        }
        return null;
    }

    public int quantityDropped(Random random)
    {
        return 1;
    }
}