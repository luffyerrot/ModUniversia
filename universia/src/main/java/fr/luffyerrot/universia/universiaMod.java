package fr.luffyerrot.universia;

import fr.luffyerrot.universia.CreativeTabs.UniversiaTab;
import fr.luffyerrot.universia.CreativeTabs.UniversiaTabCTM;
import fr.luffyerrot.universia.CreativeTabs.UniversiaTabDeco;
import fr.luffyerrot.universia.CreativeTabs.UniversiaTabDrogs;
import fr.luffyerrot.universia.CreativeTabs.UniversiaTabFoodAndLife;
import fr.luffyerrot.universia.CreativeTabs.UniversiaTabGuns;
import fr.luffyerrot.universia.CreativeTabs.UniversiaTabPanneaux;
import fr.luffyerrot.universia.CreativeTabs.UniversiaTabRoad;
import fr.luffyerrot.universia.Events.RegisteringEvent;
import fr.luffyerrot.universia.Handlers.GuiHandler;
import fr.luffyerrot.universia.Handlers.SoundHandler;
import fr.luffyerrot.universia.init.ModFluids;
import fr.luffyerrot.universia.init.ModPotions;
import fr.luffyerrot.universia.proxy.CommonProxy;
import fr.luffyerrot.universia.utils.Reference;
import fr.luffyerrot.universia.world.WorldEvents;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class universiaMod {

    @Mod.Instance(Reference.MODID)
    public static universiaMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
    public static CommonProxy proxy;
    
    public static final UniversiaTab creativeTab = new UniversiaTab("all");
    public static final UniversiaTabRoad creativeTabRoad = new UniversiaTabRoad(0, "road");
    public static final UniversiaTabRoad creativeTabFullRoad = new UniversiaTabRoad(1, "road_slab");
    public static final UniversiaTabRoad creativeTabSlabRoad = new UniversiaTabRoad(2, "road_full");
    public static final UniversiaTabCTM creativeTabCTM = new UniversiaTabCTM("ctm");
    public static final UniversiaTabPanneaux creativeTabPanneaux = new UniversiaTabPanneaux("road_sign");
    public static final UniversiaTabFoodAndLife creativeTabFoodAndLife = new UniversiaTabFoodAndLife("food_heal");
    public static final UniversiaTabDrogs creativeTabDrogs = new UniversiaTabDrogs("drog");
    public static final UniversiaTabGuns creativeTabGuns = new UniversiaTabGuns("gun");
    public static final UniversiaTabDeco creativeTabDeco = new UniversiaTabDeco("deco");

    public universiaMod(){

        MinecraftForge.EVENT_BUS.register(new RegisteringEvent());
    }

    static {

        FluidRegistry.enableUniversalBucket();
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){

        ModFluids.registerFluids();
        ModPotions.registerPotions();
        proxy.preInit();
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent e){

        proxy.init();
        proxy.render();
        SoundHandler.registerSounds();
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
        MinecraftForge.EVENT_BUS.register(new WorldEvents());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {

        proxy.postInit();
    }
}