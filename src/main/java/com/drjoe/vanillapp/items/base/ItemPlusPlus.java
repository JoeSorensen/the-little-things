package com.drjoe.vanillapp.items.base;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import static com.drjoe.vanillapp.reference.ReferencesPlusPlus.MOD_ID;

public class ItemPlusPlus extends Item implements IItemPlusPlus
{
	public ItemPlusPlus(String name, CreativeTabs creativeTab)
	{
		setRegistryName(MOD_ID + ":" + name);
		setUnlocalizedName(name);
		
		if (creativeTab != null)
		{
			setCreativeTab(creativeTab);
		}
	}
	
	@SuppressWarnings("ConstantConditions")
	@SideOnly(Side.CLIENT)
	@Override
	public void registerItemRenderer()
	{
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}
}