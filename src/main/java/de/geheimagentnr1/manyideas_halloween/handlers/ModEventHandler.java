package de.geheimagentnr1.manyideas_halloween.handlers;

import de.geheimagentnr1.manyideas_core.util.BlockRegistrationHelper;
import de.geheimagentnr1.manyideas_halloween.ManyIdeasHalloween;
import de.geheimagentnr1.manyideas_halloween.elements.blocks.ModBlocks;
import de.geheimagentnr1.manyideas_halloween.elements.item_groups.ModItemGroups;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;


@SuppressWarnings( "unused" )
@Mod.EventBusSubscriber( modid = ManyIdeasHalloween.MODID, bus = Mod.EventBusSubscriber.Bus.MOD )
public class ModEventHandler {
	
	
	@OnlyIn( Dist.CLIENT )
	@SubscribeEvent
	public static void handleClientSetupEvent( FMLClientSetupEvent event ) {
		
		BlockRegistrationHelper.registerBlockRenderTypes( ModBlocks.BLOCKS );
	}
	
	@SubscribeEvent
	public static void handleBlockRegistryEvent( RegisterEvent event ) {
		
		if( event.getRegistryKey().equals( ForgeRegistries.Keys.BLOCKS ) ) {
			event.register(
				ForgeRegistries.Keys.BLOCKS,
				registerHelper -> ModBlocks.BLOCKS.forEach( registryEntry -> registerHelper.register(
					registryEntry.getRegistryName(),
					registryEntry.getValue()
				) )
			);
		}
	}
	
	@SubscribeEvent
	public static void handleItemRegistryEvent( RegisterEvent event ) {
		
		if( event.getRegistryKey().equals( ForgeRegistries.Keys.ITEMS ) ) {
			Item.Properties properties = new Item.Properties().tab( ModItemGroups.MANYIDEAS_HALLOWEEN_ITEM_GROUP );
			BlockRegistrationHelper.registerBlockItems( event, ModBlocks.BLOCKS, properties );
		}
	}
}
