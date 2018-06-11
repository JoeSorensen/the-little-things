package com.drjoe.vanillapp.items.registration;

import com.drjoe.vanillapp.items.ItemAvadaKedavara;
import com.drjoe.vanillapp.items.base.ItemPlusPlus;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import static com.drjoe.vanillapp.reference.ReferencesPlusPlus.ITEM_AVADA_KEDAVARA;
import static com.drjoe.vanillapp.reference.ReferencesPlusPlus.MOD_ID;

@Mod.EventBusSubscriber
public class ItemsPlusPlus
{
	@GameRegistry.ObjectHolder(MOD_ID + ":" + ITEM_AVADA_KEDAVARA)
	public static final ItemAvadaKedavara AVADA_KEDAVARA = new ItemAvadaKedavara();
	
	private static final ItemPlusPlus[] ITEMS =
	  {
	    AVADA_KEDAVARA
	  };
	
	@SubscribeEvent
	protected static void registerItems(RegistryEvent.Register<Item> event)
	{
		final IForgeRegistry<Item> registry = event.getRegistry();
		registry.registerAll(ITEMS);
	}
	
	@SubscribeEvent
	protected static void registerItemRenderers(ModelRegistryEvent event)
	{
		for (ItemPlusPlus item : ITEMS)
		{
			item.registerItemRenderer();
		}
	}
}