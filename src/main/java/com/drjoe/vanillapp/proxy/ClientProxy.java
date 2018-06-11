package com.drjoe.vanillapp.proxy;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
	@Override
	public void preInitialize(FMLPreInitializationEvent event)
	{
		super.preInitialize(event);
		
		// TODO: Register GUI handler if needed
		// TODO: Register OBJLoader if needed
	}
	
	@Override
	public void registerRenderers()
	{
		// DISABLED: Register TESR's
	}
}