package de.geheimagentnr1.manyideas_halloween.elements.creative_mod_tabs;

import de.geheimagentnr1.manyideas_halloween.ManyIdeasHalloween;
import de.geheimagentnr1.manyideas_core.core.elements.creative_mod_tabs.CreativeModeTabFactory;
import de.geheimagentnr1.manyideas_core.core.registry.RegistryEntry;
import de.geheimagentnr1.manyideas_halloween.elements.blocks.ModBlocksRegisterFactory;
import de.geheimagentnr1.manyideas_halloween.elements.blocks.halloween.PumpkinLantern;
import lombok.RequiredArgsConstructor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.List;


@RequiredArgsConstructor
public class ManyIdeasHalloweenCreativeModeTabFactory implements CreativeModeTabFactory {
	
	
	@NotNull
	private final ModBlocksRegisterFactory modBlocksRegisterFactory;
	
	@NotNull
	@Override
	public String getRegistryName() {
		
		return ManyIdeasHalloween.MODID;
	}
	
	@NotNull
	@Override
	public ItemLike getIconItem() {
		
		return modBlocksRegisterFactory.getBlocks().stream()
			.filter( entry -> entry.getValue() instanceof PumpkinLantern )
			.findFirst()
			.map( entry -> (ItemLike) entry.getValue() )
			.orElse( Items.CARVED_PUMPKIN );
	}
	
	@NotNull
	@Override
	public List<RegistryEntry<Item>> getDisplayItems() {
		
		// The block items are already added via getDisplayBlocks(), adding them twice crashes NeoForge 26.2+
		return List.of();
	}
	
	@NotNull
	@Override
	public List<RegistryEntry<Block>> getDisplayBlocks() {
		
		return modBlocksRegisterFactory.getBlocks();
	}
}
