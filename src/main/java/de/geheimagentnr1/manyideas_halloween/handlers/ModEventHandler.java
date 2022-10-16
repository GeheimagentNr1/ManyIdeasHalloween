package de.geheimagentnr1.manyideas_halloween.handlers;

import de.geheimagentnr1.manyideas_core.util.BlockRegistrationHelper;
import de.geheimagentnr1.manyideas_halloween.ManyIdeasHalloween;
import de.geheimagentnr1.manyideas_halloween.elements.blocks.ModBlocks;
import de.geheimagentnr1.manyideas_halloween.elements.item_groups.ModItemGroups;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;


@SuppressWarnings( "unused" )
@Mod.EventBusSubscriber( modid = ManyIdeasHalloween.MODID, bus = Mod.EventBusSubscriber.Bus.MOD )
public class ModEventHandler {
	
	
	@OnlyIn( Dist.CLIENT )
	@SubscribeEvent
	public static void handleClientSetupEvent( FMLClientSetupEvent event ) {
		
		BlockRegistrationHelper.registerBlockRenderTypes( ModBlocks.BLOCKS );
	}
	
	@SubscribeEvent
	public static void handleBlockRegistryEvent( RegistryEvent.Register<Block> event ) {
		
		event.getRegistry().registerAll( ModBlocks.BLOCKS );
	}
	
	@SubscribeEvent
	public static void handleItemRegistryEvent( RegistryEvent.Register<Item> event ) {
		
		Item.Properties properties = new Item.Properties().tab( ModItemGroups.MANYIDEAS_HALLOWEEN_ITEM_GROUP );
		
		BlockRegistrationHelper.registerBlockItems( event, ModBlocks.BLOCKS, properties );
	}
}
