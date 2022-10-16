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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;


public class Gravestone extends Block implements BlockItemInterface, BlockRenderTypeInterface {
	
	
	public static final String registry_name = "gravestone";
	
	//TODO: Variants
	private static final VoxelShapeMemory VARIANT_0_SHAPE = VoxelShapeMemory.createHorizontalAxisVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 1, 0, 5, 15, 2, 11 ),
		VoxelShapeVector.create( 2.5, 2, 6, 13.5, 15, 10 ),
		VoxelShapeVector.create( 3.5, 15, 6, 12.5, 16, 10 )
	);
	
	private static final VoxelShapeMemory VARIANT_1_SHAPE = VoxelShapeMemory.createHorizontalAxisVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 6, 0, 6, 10, 2, 10 ),
		VoxelShapeVector.create( 7, 2, 7, 9, 8, 9 ),
		VoxelShapeVector.create( 4, 8, 7, 12, 16, 9 ),
		VoxelShapeVector.create( 12, 11, 7, 15, 13, 9 ),
		VoxelShapeVector.create( 7, 16, 7, 9, 19, 9 ),
		VoxelShapeVector.create( 1, 11, 7, 4, 13, 9 )
	);
	
	private static final VoxelShape VARIANT_2_SHAPE = VoxelShapeMemory.createVoxelShape(
		VoxelShapeVector.create( 3, 0, 3, 13, 2, 13 ),
		VoxelShapeVector.create( 4, 2, 4, 12, 10, 12 )
	);
	
	private static final VoxelShapeMemory VARIANT_3_SHAPE = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 1, 0, 1, 15, 2, 15 ),
		VoxelShapeVector.create( 2, 2, 2, 14, 3, 15 ),
		VoxelShapeVector.create( 2, 3, 4, 14, 4, 15 ),
		VoxelShapeVector.create( 2, 4, 7, 14, 5, 14 ),
		VoxelShapeVector.create( 2, 5, 9, 14, 6, 14 ),
		VoxelShapeVector.create( 2, 6, 12, 14, 7, 14 )
	);
	
	private static final VoxelShape VARIANT_4_SHAPE = VoxelShapeMemory.createVoxelShape(
		VoxelShapeVector.create( 1, 0, 1, 15, 2, 15 ),
		VoxelShapeVector.create( 2, 2, 2, 14, 4, 14 ),
		VoxelShapeVector.create( 2.5, 4, 2.5, 13.5, 12, 13.5 )
	);
	
	public Gravestone() {
		
		super(
			Properties.of( Material.STONE )
				.strength( 2.0F, 6.0F )
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
		Direction.Axis facingAxis = facing.getAxis();
		return switch( state.getValue( ModBlockStateProperties.FIVE_VARIANTS ) ) {
			case 0 -> VARIANT_0_SHAPE.getShapeFromHorizontalAxis( facingAxis );
			case 1 -> VARIANT_1_SHAPE.getShapeFromHorizontalAxis( facingAxis );
			case 2 -> VARIANT_2_SHAPE;
			case 3 -> VARIANT_3_SHAPE.getShapeFromHorizontalFacing( facing );
			case 4 -> VARIANT_4_SHAPE;
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
