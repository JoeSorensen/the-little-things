package com.drjoe.vanillapp.items;

import com.drjoe.vanillapp.items.base.ItemPlusPlus;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import static com.drjoe.vanillapp.reference.ReferencesPlusPlus.ITEM_AVADA_KEDAVARA;

public class ItemAvadaKedavara extends ItemPlusPlus
{
	public ItemAvadaKedavara()
	{
		super(ITEM_AVADA_KEDAVARA, null);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
	{
		if (!world.isRemote)
		{
			RayTraceResult rtr = Minecraft.getMinecraft().objectMouseOver;
			if (rtr.entityHit != null && !(rtr.entityHit instanceof EntityPlayer))
			{
				rtr.entityHit.isDead = true;
			}
		}
		
		return new ActionResult<>(EnumActionResult.PASS, player.getHeldItem(hand));
	}
}