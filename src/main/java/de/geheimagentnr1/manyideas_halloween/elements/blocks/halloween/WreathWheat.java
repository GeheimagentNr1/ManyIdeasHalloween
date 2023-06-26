package de.geheimagentnr1.manyideas_halloween.elements.blocks.halloween;


import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import de.geheimagentnr1.minecraft_forge_api.elements.blocks.BlockItemInterface;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class WreathWheat extends Block implements BlockItemInterface {
	
	
	@NotNull
	public static final String registry_name = "wreath_wheat";
	
	@NotNull
	private static final VoxelShapeMemory SHAPE = VoxelShapeMemory.createVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0.4, 0.4, 13.8, 15.6, 15.6, 16 )
	);
	
	public WreathWheat() {
		
		super(
			BlockBehaviour.Properties.of()
				.mapColor( MapColor.COLOR_YELLOW )
				.strength( 0.5F )
				.sound( SoundType.GRASS )
				.noOcclusion()
		);
	}
	
	@NotNull
	@Override
	public VoxelShape getShape(
		@NotNull BlockState state,
		@NotNull BlockGetter level,
		@NotNull BlockPos pos,
		@NotNull CollisionContext context ) {
		
		return SHAPE.getShapeFromFacing( state.getValue( BlockStateProperties.FACING ) );
	}
	
	@Nullable
	@Override
	public BlockState getStateForPlacement( @NotNull BlockPlaceContext context ) {
		
		return defaultBlockState().setValue(
			BlockStateProperties.FACING,
			context.getClickedFace()
		);
	}
	
	protected void createBlockStateDefinition( @NotNull StateDefinition.Builder<Block, BlockState> builder ) {
		
		builder.add( BlockStateProperties.FACING );
	}
}
