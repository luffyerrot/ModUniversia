package fr.luffyerrot.universia.Stats;

import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatBasic;
import net.minecraft.stats.StatList;
import net.minecraft.util.text.TextComponentTranslation;

public class StatListMod extends StatList {
	
    public static final StatBase TABLEASSEMBLAGE_INTERACTION = (new StatBasic("stat.tableassemblageInteraction", new TextComponentTranslation("stat.tableassemblageInteraction", new Object[0]))).registerStat();

}