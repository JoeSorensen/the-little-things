package com.drjoe.vanillapp.items;

import com.drjoe.vanillapp.items.base.ItemPlusPlus;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentBase;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import static com.drjoe.vanillapp.reference.ReferencesPlusPlus.ITEM_AVADA_KEDAVARA;

public class ItemAvadaKedavara extends ItemPlusPlus
{
	public ItemAvadaKedavara()
	{
		super(ITEM_AVADA_KEDAVARA, null);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
	{
		if (!world.isRemote)
		{
			RayTraceResult rtr = Minecraft.getMinecraft().objectMouseOver;
			if (rtr.entityHit instanceof EntityLiving)
			{
				double x = rtr.entityHit.posX + 0.5D;
				double y = rtr.entityHit.posY + 0.5D;
				double z = rtr.entityHit.posZ + 0.5D;
				
				EntityLightningBolt lightning = new EntityLightningBolt(world, x, y, z, false);
				world.addWeatherEffect(lightning);
				
				rtr.entityHit.setCustomNameTag("Harry Potter");
				player.sendMessage(new TextComponentTranslation("kill.harry.potter"));
			}
		}
		
		return new ActionResult<>(EnumActionResult.PASS, player.getHeldItem(hand));
	}
}