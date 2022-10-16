package de.geheimagentnr1.manyideas_halloween.elements.blocks.halloween;

import de.geheimagentnr1.manyideas_core.elements.blocks.BlockRenderTypeInterface;
import de.geheimagentnr1.manyideas_core.elements.blocks.template_blocks.multi_block.MultiBlock;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeMemory;
import de.geheimagentnr1.manyideas_core.util.voxel_shapes.VoxelShapeVector;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;


public class HayBundle extends MultiBlock implements BlockRenderTypeInterface {
	
	
	public static final String registry_name = "hay_bundle";
	
	private static final VoxelShape TOP_SHAPE = VoxelShapeMemory.createVoxelShape(
		VoxelShapeVector.create( 4.5, 0, 4.5, 11.5, 13, 11.5 )
	);
	
	private static final VoxelShape BOTTOM_SHAPE = VoxelShapeMemory.createVoxelShape(
		VoxelShapeVector.create( 4.5, 0, 4.5, 11.5, 16, 11.5 )
	);
	
	public HayBundle() {
		
		super(
			BlockBehaviour.Properties.of( Material.GRASS, MaterialColor.COLOR_YELLOW )
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
		
		if( state.getValue( Y_SIZE ) == 1 ) {
			return TOP_SHAPE;
		} else {
			return BOTTOM_SHAPE;
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
	
	@Override
	public Item getBlockItem( Item.Properties _properties ) {
		
		return createBlockItem( this, _properties, registry_name );
	}
	
	@Override
	public RenderType getRenderType() {
		
		return RenderType.cutout();
	}
}
