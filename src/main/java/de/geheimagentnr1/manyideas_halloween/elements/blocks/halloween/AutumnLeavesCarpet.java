package de.geheimagentnr1.manyideas_halloween.elements.blocks.halloween;

import de.geheimagentnr1.manyideas_halloween.elements.block_state_properties.ModBlockStateProperties;
import de.geheimagentnr1.minecraft_forge_api.elements.blocks.BlockItemInterface;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CarpetBlock;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class AutumnLeavesCarpet extends CarpetBlock implements BlockItemInterface {
	
	
	@NotNull
	public static final String registry_name = "autumn_leaves_carpet";
	
	
	public AutumnLeavesCarpet() {
		
		super(
			BlockBehaviour.Properties.of()
				.mapColor( MapColor.COLOR_ORANGE )
				.strength( 0.1F )
				.sound( SoundType.GRASS )
				.noOcclusion()
		);
	}
	
	@Nullable
	@Override
	public BlockState getStateForPlacement( @NotNull BlockPlaceContext context ) {
		
		return defaultBlockState().setValue(
			BlockStateProperties.HORIZONTAL_FACING,
			context.getHorizontalDirection().getOpposite()
		).setValue( ModBlockStateProperties.FIVE_VARIANTS, context.getLevel().getRandom().nextInt( 5 ) );
	}
	
	protected void createBlockStateDefinition( @NotNull StateDefinition.Builder<Block, BlockState> builder ) {
		
		builder.add( BlockStateProperties.HORIZONTAL_FACING, ModBlockStateProperties.FIVE_VARIANTS );
	}
	
	@NotNull
	@Override
	public Item getBlockItem( @NotNull Block block, @NotNull Item.Properties properties ) {
		
		Item item = BlockItemInterface.super.getBlockItem( block, properties );
		ComposterBlock.COMPOSTABLES.put( item, 0.0375F );
		return item;
	}
}
