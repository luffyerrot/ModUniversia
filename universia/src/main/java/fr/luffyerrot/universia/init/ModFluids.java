package fr.luffyerrot.universia.init;

import fr.luffyerrot.universia.Fluids.FluidLiquid;
import fr.luffyerrot.universia.utils.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids {

    public static final Fluid b6 = new FluidLiquid("b6", new ResourceLocation(Reference.MODID + ":blocks/b6_still"), new ResourceLocation(Reference.MODID + ":blocks/b6_flow"));
    public static final Fluid encre = new FluidLiquid("encre", new ResourceLocation(Reference.MODID + ":blocks/encre_still"), new ResourceLocation(Reference.MODID + ":blocks/encre_flow"));
    public static final Fluid encre_magenta = new FluidLiquid("encre_magenta", new ResourceLocation(Reference.MODID + ":blocks/encre_magenta_still"), new ResourceLocation(Reference.MODID + ":blocks/encre_magenta_flow"));
    public static final Fluid encre_cyan = new FluidLiquid("encre_cyan", new ResourceLocation(Reference.MODID + ":blocks/encre_cyan_still"), new ResourceLocation(Reference.MODID + ":blocks/encre_cyan_flow"));
    public static final Fluid encre_jaune = new FluidLiquid("encre_jaune", new ResourceLocation(Reference.MODID + ":blocks/encre_jaune_still"), new ResourceLocation(Reference.MODID + ":blocks/encre_jaune_flow"));
    public static final Fluid fluoroantimonique = new FluidLiquid("fluoroantimonique", new ResourceLocation(Reference.MODID + ":blocks/fluoroantimonique_still"), new ResourceLocation(Reference.MODID + ":blocks/fluoroantimonique_flow"));
    public static final Fluid essence = new FluidLiquid("essence", new ResourceLocation(Reference.MODID + ":blocks/essence_still"), new ResourceLocation(Reference.MODID + ":blocks/essence_flow"));

    public static void registerFluids(){

        registerFluid(b6);
        registerFluid(encre);
        registerFluid(encre_magenta);
        registerFluid(encre_cyan);
        registerFluid(encre_jaune);
        registerFluid(fluoroantimonique);
        registerFluid(essence);
    }

    public static void registerFluid(Fluid fluid){

        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);
    }
}
