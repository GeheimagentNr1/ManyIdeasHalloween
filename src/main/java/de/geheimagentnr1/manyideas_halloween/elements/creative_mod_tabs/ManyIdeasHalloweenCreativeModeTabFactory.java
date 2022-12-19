package de.geheimagentnr1.manyideas_halloween.elements.creative_mod_tabs;

import de.geheimagentnr1.manyideas_core.elements.blocks.BlockItemInterface;
import de.geheimagentnr1.manyideas_core.elements.creative_mod_tabs.CreativeModeTabFactory;
import de.geheimagentnr1.manyideas_halloween.ManyIdeasHalloween;
import de.geheimagentnr1.manyideas_halloween.elements.blocks.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;


public class ManyIdeasHalloweenCreativeModeTabFactory implements CreativeModeTabFactory {
	
	
	@Override
	public String getModId() {
		
		return ManyIdeasHalloween.MODID;
	}
	
	@Override
	public String getRegistryName() {
		
		return ManyIdeasHalloween.MODID;
	}
	
	@Override
	public Item getDisplayItem() {
		
		return ModBlocks.PUMPKIN_LANTERN.asItem();
	}
	
	@Override
	public List<ItemStack> getDisplayItems() {
		
		return ModBlocks.BLOCKS.stream()
			.filter( registryEntry -> registryEntry.getValue() instanceof BlockItemInterface )
			.map( registryEntry -> new ItemStack( registryEntry.getValue() ) )
			.toList();
	}
}
