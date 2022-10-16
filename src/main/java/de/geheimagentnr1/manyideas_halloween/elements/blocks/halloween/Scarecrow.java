package de.geheimagentnr1.manyideas_halloween.elements.blocks.halloween;

import de.geheimagentnr1.manyideas_core.elements.blocks.BlockRenderTypeInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.multi_block.MultiBlock;
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
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;


public class Scarecrow extends MultiBlock implements BlockRenderTypeInterface {
	
	
	public static final String registry_name = "scarecrow";
	
	private static final VoxelShapeMemory TOP_SHAPE = VoxelShapeMemory.createHorizontalVoxelShapes(
		Direction.SOUTH,
		VoxelShapeVector.create( 7, 0, 7, 9, 3, 9 ),
		
		VoxelShapeVector.create( 4, 7, 2, 12, 9, 12.5 ),
		VoxelShapeVector.create( 4, 5, 2.5, 12, 7, 13.5 ),
		VoxelShapeVector.create( 4, 3, 3, 12, 5, 13 ),
		VoxelShapeVector.create( 4, 1, 4, 12, 3, 10 ),
		
		VoxelShapeVector.create( 1, 9, 1, 15, 11, 4 ),
		VoxelShapeVector.create( 3.5, 8, 4, 12.5, 14, 6 ),
		VoxelShapeVector.create( 3.5, 7, 6, 12.5, 14, 8 ),
		VoxelShapeVector.create( 3.5, 7, 8, 12.5, 13, 10 ),
		VoxelShapeVector.create( 3.5, 7, 10, 12.5, 12, 12 ),
		VoxelShapeVector.create( 3.5, 6, 12, 12.5, 11, 14 ),
		VoxelShapeVector.create( 1, 8, 4, 3.5, 10, 6 ),
		VoxelShapeVector.create( 12.5, 8, 4, 15, 10, 6 ),
		VoxelShapeVector.create( 1, 7, 6, 3.5, 9, 8 ),
		VoxelShapeVector.create( 12.5, 7, 6, 15, 9, 8 ),
		VoxelShapeVector.create( 1, 6, 8, 3.5, 8, 10 ),
		VoxelShapeVector.create( 12.5, 6, 8, 15, 8, 10 ),
		VoxelShapeVector.create( 1, 5, 10, 3.5, 8, 12 ),
		VoxelShapeVector.create( 12.5, 5, 10, 15, 8, 12 ),
		VoxelShapeVector.create( 1, 4.5, 12, 15, 6.5, 14.5 )
	);
	
	private static final VoxelShapeMemory BOTTOM_SHAPE = VoxelShapeMemory.createHorizontalAxisVoxelShapes(
		Direction.NORTH,
		VoxelShapeVector.create( 7, 0, 7, 9, 10, 9 ),
		VoxelShapeVector.create( 4, 8, 6, 12, 16, 10 ),
		VoxelShapeVector.create( 0, 13, 7, 16, 15, 9 )
	);
	
	public Scarecrow() {
		
		super(
			BlockBehaviour.Properties.of( Material.GRASS, MaterialColor.COLOR_YELLOW )
				.strength( 0.5F )
				.sound( SoundType.GRASS )
				.noOcclusion(),
			registry_name
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
		
		if( state.getValue( Y_SIZE ) == 1 ) {
			return TOP_SHAPE.getShapeFromHorizontalFacing( facing );
		} else {
			return BOTTOM_SHAPE.getShapeFromHorizontalAxis( facing.getAxis() );
		}
	}
	
	@Override
	protected int getXSize() {
		
		return 1;
	}
	
	@Override
	protected int getYSize() {
		
		return 2;
	}
	
	@Override
	protected int getZSize() {
		
		return 1;
	}
	
	@Override
	protected boolean[][][] hasBlockStatesAtPos() {
		
		return new boolean[][][] {
			{ { true }, { true } }
		};
	}
	
	public BlockState getStateForPlacement( BlockPlaceContext context ) {
		
		BlockState state = super.getStateForPlacement( context );
		if( state == null ) {
			return null;
		}
		return state.setValue( ModBlockStateProperties.FIVE_VARIANTS, context.getLevel().getRandom().nextInt( 5 ) );
	}
	
	protected void createBlockStateDefinition( StateDefinition.Builder<Block, BlockState> builder ) {
		
		super.createBlockStateDefinition( builder );
		builder.add( ModBlockStateProperties.FIVE_VARIANTS );
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
