package de.geheimagentnr1.manyideas_halloween.elements.blocks.halloween;

import de.geheimagentnr1.manyideas_core.elements.blocks.BlockItemInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.BlockRenderTypeInterface;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import de.geheimagentnr1.manyideas_halloween.elements.block_state_properties.ModBlockStateProperties;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
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


public class Skeleton extends Block implements BlockItemInterface, BlockRenderTypeInterface {
	
	
	public static final String registry_name = "skeleton";
	
	private static final VoxelShapeMemory VARIANT_0_SHAPE = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 4, 0, 24, 12, 8, 32 ),
		VoxelShapeVector.create( 12, 0, 12, 14, 2, 24 ),
		VoxelShapeVector.create( 2, 0, 12, 4, 2, 24 ),
		VoxelShapeVector.create( 9, 0, 0, 11, 2, 12 ),
		VoxelShapeVector.create( 5, 0, 0, 7, 2, 12 ),
		VoxelShapeVector.create( 4, 0, 12, 12, 4, 24 )
	);
	
	private static final VoxelShapeMemory VARIANT_1_SHAPE = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( -0.5, 0, 0, 16.5, 5, 25 ),
		VoxelShapeVector.create( 1.5, 0, 22.5, 13, 8, 34 )
	);
	
	private static final VoxelShapeMemory VARIANT_2_SHAPE = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 2.5, 0, 2.5, 13.5, 8, 13.5 ),
		VoxelShapeVector.create( 8.5, 8, 4.5, 13, 9, 10 ),
		VoxelShapeVector.create( 7, 7, 7, 9, 13, 9 )
	);
	
	private static final VoxelShapeMemory VARIANT_3_SHAPE = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 4, 24, 4, 12, 32, 12 ),
		VoxelShapeVector.create( 12, 11, 8, 14, 23, 10 ),
		VoxelShapeVector.create( 2, 11, 8, 4, 23, 10 ),
		VoxelShapeVector.create( 9, 0, 8, 11, 12, 10 ),
		VoxelShapeVector.create( 5, 0, 8, 7, 12, 10 ),
		VoxelShapeVector.create( 4, 12, 7, 12, 24, 11.5 )
	);
	
	private static final VoxelShapeMemory VARIANT_4_SHAPE = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( -0.5, 0, 0, 16.5, 2, 12 ),
		VoxelShapeVector.create( 4, 1, 11, 13, 17.5, 16 ),
		VoxelShapeVector.create( 2, 2, 6, 14, 14.5, 12.5 ),
		VoxelShapeVector.create( 4, 13, 0.5, 12, 24, 11 )
	);
	
	public Skeleton() {
		
		super(
			BlockBehaviour.Properties.of()
				.mapColor( MapColor.SAND )
				.strength( 1.01F )
				.sound( SoundType.BONE_BLOCK )
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
		
		return createBlockItem( this, _properties, registry_name );
	}
	
	@Override
	public RenderType getRenderType() {
		
		return RenderType.cutout();
	}
}
