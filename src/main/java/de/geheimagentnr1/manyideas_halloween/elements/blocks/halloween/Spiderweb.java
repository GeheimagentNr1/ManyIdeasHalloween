package de.geheimagentnr1.manyideas_halloween.elements.blocks.halloween;

import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import de.geheimagentnr1.manyideas_halloween.elements.block_state_properties.ModBlockStateProperties;
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
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class Spiderweb extends Block implements BlockItemInterface {
	
	
	@NotNull
	public static final String registry_name = "spiderweb";
	
	@NotNull
	private static final VoxelShapeMemory VARIANT_0_SHAPE = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 7, 3, 11, 16, 12 )
	);
	
	@NotNull
	private static final VoxelShapeMemory VARIANT_1_SHAPE = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 5, 7, 16, 16, 16 )
	);
	
	@NotNull
	private static final VoxelShapeMemory VARIANT_2_SHAPE = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 7, 3, 7, 16, 16, 16 )
	);
	
	@NotNull
	private static final VoxelShapeMemory VARIANT_3_SHAPE = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 0, 0, 7, 16, 16, 11 )
	);
	
	@NotNull
	private static final VoxelShapeMemory VARIANT_4_SHAPE = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 1, 0, 8, 16, 16, 16 )
	);
	
	public Spiderweb() {
		
		super(
			BlockBehaviour.Properties.of()
				.mapColor( MapColor.WOOL )
				.strength( 4.0F )
				.sound( SoundType.STONE )
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
		
		Direction facing = state.getValue( BlockStateProperties.HORIZONTAL_FACING );
		return switch( state.getValue( ModBlockStateProperties.FIVE_VARIANTS ) ) {
			case 0 -> VARIANT_0_SHAPE.getShapeFromHorizontalFacing( facing );
			case 1 -> VARIANT_1_SHAPE.getShapeFromHorizontalFacing( facing );
			case 2 -> VARIANT_2_SHAPE.getShapeFromHorizontalFacing( facing );
			case 3 -> VARIANT_3_SHAPE.getShapeFromHorizontalFacing( facing );
			case 4 -> VARIANT_4_SHAPE.getShapeFromHorizontalFacing( facing );
			default -> Shapes.block();
		};
	}
	
	@NotNull
	@Override
	public VoxelShape getCollisionShape(
		@NotNull BlockState state,
		@NotNull BlockGetter level,
		@NotNull BlockPos pos,
		@NotNull CollisionContext context ) {
		
		return Shapes.empty();
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
}
