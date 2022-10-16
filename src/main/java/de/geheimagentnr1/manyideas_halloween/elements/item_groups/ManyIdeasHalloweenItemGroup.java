package de.geheimagentnr1.manyideas_halloween.elements.item_groups;


import de.geheimagentnr1.manyideas_halloween.ManyIdeasHalloween;
import de.geheimagentnr1.manyideas_halloween.elements.blocks.ModBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nonnull;


public class ManyIdeasHalloweenItemGroup extends CreativeModeTab {
	
	
	//package-private
	ManyIdeasHalloweenItemGroup() {
		
		super( ManyIdeasHalloween.MODID );
	}
	
	@Nonnull
	@Override
	public ItemStack makeIcon() {
		
		return new ItemStack( ModBlocks.PUMPKIN_LANTERN );
	}
}
