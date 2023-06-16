package de.geheimagentnr1.manyideas_halloween.elements.blocks.halloween;

import de.geheimagentnr1.manyideas_core.elements.blocks.BlockItemInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.BlockRenderTypeInterface;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import de.geheimagentnr1.manyideas_halloween.elements.block_state_properties.ModBlockStateProperties;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LanternBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;


public class PumpkinLantern extends LanternBlock implements BlockItemInterface, BlockRenderTypeInterface {
	
	
	public static final String registry_name = "pumpkin_lantern";
	
	private static final VoxelShape HANGING_SHAPE = VoxelShapeMemory.createVoxelShape(
		VoxelShapeVector.create( 5, 7, 4, 11, 9, 12 ),
		VoxelShapeVector.create( 4, 1, 5, 12, 9, 11 ),
		VoxelShapeVector.create( 5, 2, 3, 11, 8, 13 ),
		VoxelShapeVector.create( 3, 2, 5, 13, 8, 11 ),
		VoxelShapeVector.create( 4, 2, 4, 12, 8, 12 ),
		VoxelShapeVector.create( 4, 9, 7.5, 5, 11, 8.5 ),
		VoxelShapeVector.create( 11, 9, 7.5, 12, 11, 8.5 ),
		VoxelShapeVector.create( 5, 11, 7.5, 11, 12, 8.5 ),
		VoxelShapeVector.create( 7, 10, 7, 9, 16, 9 )
	);
	
	private static final VoxelShape STANDING_SHAPE = VoxelShapeMemory.createVoxelShape(
		VoxelShapeVector.create( 5, 6, 4, 11, 8, 12 ),
		VoxelShapeVector.create( 4, 0, 5, 12, 8, 11 ),
		VoxelShapeVector.create( 5, 1, 3, 11, 7, 13 ),
		VoxelShapeVector.create( 3, 1, 5, 13, 7, 11 ),
		VoxelShapeVector.create( 4, 1, 4, 12, 7, 12 )
	);
	
	public PumpkinLantern() {
		
		super(
			BlockBehaviour.Properties.of()
				.mapColor( MapColor.COLOR_ORANGE )
				.strength( 1.0F )
				.sound( SoundType.WOOD )
				.lightLevel( value -> 15 )
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
		
		if( state.getValue( BlockStateProperties.HANGING ) ) {
			return HANGING_SHAPE;
		} else {
			return STANDING_SHAPE;
		}
	}
	
	public BlockState getStateForPlacement( @NotNull BlockPlaceContext context ) {
		
		BlockState state = super.getStateForPlacement( context );
		if( state == null ) {
			return null;
		}
		return state.setValue(
			BlockStateProperties.HORIZONTAL_FACING,
			context.getHorizontalDirection().getOpposite()
		).setValue( ModBlockStateProperties.FIVE_VARIANTS, context.getLevel().getRandom().nextInt( 5 ) );
	}
	
	@Override
	public void animateTick(
		@NotNull BlockState state,
		@NotNull Level level,
		@NotNull BlockPos pos,
		@NotNull RandomSource randomSource ) {
		
		float randomFactor = randomSource.nextFloat();
		Vec3 position = new Vec3( 0.5, 0.5, 0.5 ).add( pos.getX(), pos.getY(), pos.getZ() );
		
		if( !state.getValue( BlockStateProperties.HANGING ) ) {
			position = position.subtract( 0, 0.0625, 0 );
		}
		if( randomFactor < 0.3F ) {
			level.addParticle( ParticleTypes.SMOKE, position.x, position.y, position.z, 0.0D, 0.0D, 0.0D );
			if( randomFactor < 0.17F ) {
				level.playLocalSound(
					position.x + 0.5D,
					position.y + 0.5D,
					position.z + 0.5D,
					SoundEvents.CANDLE_AMBIENT,
					SoundSource.BLOCKS,
					1.0F + randomSource.nextFloat(),
					randomSource.nextFloat() * 0.7F + 0.3F,
					false
				);
			}
		}
		
		level.addParticle( ParticleTypes.SMALL_FLAME, position.x, position.y, position.z, 0.0D, 0.0D, 0.0D );
	}
	
	protected void createBlockStateDefinition( @NotNull StateDefinition.Builder<Block, BlockState> builder ) {
		
		super.createBlockStateDefinition( builder );
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
