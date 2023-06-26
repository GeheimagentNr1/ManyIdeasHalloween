package de.geheimagentnr1.manyideas_halloween.elements.block_state_properties;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;


public class ModBlockStateProperties {
	
	
	@NotNull
	public static final IntegerProperty FIVE_VARIANTS = IntegerProperty.create( "variants", 0, 4 );
}
