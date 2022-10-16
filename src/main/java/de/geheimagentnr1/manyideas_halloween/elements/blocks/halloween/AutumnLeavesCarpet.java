package de.geheimagentnr1.manyideas_halloween.elements.blocks.halloween;

import de.geheimagentnr1.manyideas_core.elements.blocks.BlockItemInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.BlockRenderTypeInterface;
import de.geheimagentnr1.manyideas_halloween.elements.block_state_properties.ModBlockStateProperties;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;


public class AutumnLeavesCarpet extends CarpetBlock implements BlockItemInterface, BlockRenderTypeInterface {
	
	
	public static final String registry_name = "autumn_leaves_carpet";
	
	
	public AutumnLeavesCarpet() {
		
		super(
			Properties.of( Material.LEAVES )
				.strength( 0.1F )
				.sound( SoundType.GRASS )
				.noOcclusion()
		);
		setRegistryName( registry_name );
	}
	
	public BlockState getStateForPlacement( BlockPlaceContext context ) {
		
		return defaultBlockState().setValue(
			BlockStateProperties.HORIZONTAL_FACING,
			context.getHorizontalDirection().getOpposite()
		).setValue( ModBlockStateProperties.FIVE_VARIANTS, context.getLevel().getRandom().nextInt( 5 ) );
	}
	
	protected void createBlockStateDefinition( StateDefinition.Builder<Block, BlockState> builder ) {
		
		builder.add( BlockStateProperties.HORIZONTAL_FACING, ModBlockStateProperties.FIVE_VARIANTS );
	}
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		Item item = createBlockItem( this, _properties, registry_name );
		ComposterBlock.COMPOSTABLES.put( item, 0.0375F );
		return item;
	}
	
	@Override
	public RenderType getRenderType() {
		
		return RenderType.cutout();
	}
}
