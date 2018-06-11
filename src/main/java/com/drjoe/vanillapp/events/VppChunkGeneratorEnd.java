package com.drjoe.vanillapp.events;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.ChunkGeneratorEnd;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class VppChunkGeneratorEnd
{
	/** <p> INCOMPLETE
	 * We care about when this event is raised after a chunk is generated in
	 * {@link net.minecraft.world.gen.ChunkGeneratorEnd#populate(int, int)}.
	 * It may also be worth looking into {@link net.minecraft.world.end.DragonFightManager#generateGateway(BlockPos)},
	 * which plays an event in World.eventListeners, with the event type parameter set to 3000.
	 * </p> */
	@SuppressWarnings("UnusedAssignment")
	@SubscribeEvent
	public static void onChunkPopulate(PopulateChunkEvent event)
	{
		// Don't process on the client side
		if (event.getWorld().isRemote)
			return;
		
		// Check if the chunk being generated is an End dimension chunk
		// NOTE: event#getGen() is more efficient than event#getGenerator(), which returns the resulting value of event#getGen()
		if (event.getGen() instanceof ChunkGeneratorEnd)
		{
			// Get the chunk coordinates and loop through each block, checking to see if it is an end gateway
			int chunkX = event.getChunkX();
			int chunkZ = event.getChunkZ();
			for (int x = chunkX; x < chunkX + 16; x++)
			{
				for (int y = 0; y < 256; y++)
				{
					for (int z = chunkZ; z < chunkZ + 16; z++)
					{
						if (event.getWorld().getBlockState(new BlockPos(x, y, z)).getBlock() == Blocks.END_GATEWAY)
						{
							System.out.println("End gateway located at " + x + ", " + y + ", " + z);
							// TODO: Alter end gateeway structure
						}
					}
				}
			}
		}
	}
}