package de.geheimagentnr1.manyideas_halloween.elements.blocks.halloween;

import de.geheimagentnr1.manyideas_core.elements.block_state_properties.EveryDirectionFacing;
import de.geheimagentnr1.manyideas_core.elements.block_state_properties.ModBlockStateProperties;
import de.geheimagentnr1.manyideas_core.elements.blocks.BlockItemInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.BlockRenderTypeInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.EveryDirectionBlock;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.EveryDirectionFacingVoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;


public class SpiderPlushi extends EveryDirectionBlock implements BlockItemInterface, BlockRenderTypeInterface {
	
	
	public static final String registry_name = "spider_plushi";
	
	private static final EveryDirectionFacingVoxelShapeMemory SHAPE =
		EveryDirectionFacingVoxelShapeMemory.createEveryDirectionVoxelShapes(
			EveryDirectionFacing.DOWN_SOUTH,
			VoxelShapeVector.create( 5, 0, 8, 11, 5, 15 ),
			VoxelShapeVector.create( 6.5, 0.5, 5, 9.5, 3.5, 8 ),
			VoxelShapeVector.create( 5.5, 1, 3, 10.5, 4, 6 ),
			VoxelShapeVector.create( 1, 0, 3, 15, 2.5, 13 )
		);
	
	public SpiderPlushi() {
		
		super(
			BlockBehaviour.Properties.of( Material.CLOTH_DECORATION )
				.strength( 0.1F )
				.sound( SoundType.WOOL )
				.noOcclusion()
		);
		setRegistryName( registry_name );
	}
	
	@NotNull
	@Override
	public VoxelShape getShape(
		@NotNull BlockState state,
		@NotNull BlockGetter level,
		@NotNull BlockPos pos,
		@NotNull CollisionContext context ) {
		
		return SHAPE.getShapeFromEveryDirectionFacing( state.getValue( ModBlockStateProperties.EVERY_DIRECTION_FACING ) );
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
