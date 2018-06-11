package com.drjoe.vanillapp.main;

import com.drjoe.vanillapp.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import static com.drjoe.vanillapp.reference.ReferencesPlusPlus.*;

@Mod(modid = MOD_ID, name = MOD_NAME, version = MOD_VERSION)
public class VanillaPlusPlus
{
	@Mod.Instance
	private static VanillaPlusPlus _instance;
	
	@SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY)
	protected static CommonProxy proxy;
	
	/** <p> The logger used for outputting information to the console. </p> */
	private static Logger logger;
	
	@Mod.EventHandler
	public void preInitialize(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		
		System.out.println(MOD_NAME + " Pre-Initialization"); // TODO: remove, this is a test
		
		proxy.preInitialize(event);
	}
	
	@Mod.EventHandler
	public void initialize(FMLInitializationEvent event)
	{
		System.out.println(MOD_NAME + " Initialization"); // TODO: remove, this is a test
		
		proxy.initialize(event);
	}
	
	@Mod.EventHandler
	public void postInitialize(FMLPostInitializationEvent event)
	{
		System.out.println(MOD_NAME + " Post-Initialization"); // TODO: remove, this is a test
		
		proxy.postInitialize(event);
	}
}