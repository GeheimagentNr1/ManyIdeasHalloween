package de.geheimagentnr1.manyideas_halloween;


import de.geheimagentnr1.manyideas_halloween.elements.blocks.ModBlocksRegisterFactory;
import de.geheimagentnr1.manyideas_halloween.elements.creative_mod_tabs.ModCreativeModeTabRegisterFactory;
import de.geheimagentnr1.minecraft_forge_api.AbstractMod;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;


@Mod( ManyIdeasHalloween.MODID )
public class ManyIdeasHalloween extends AbstractMod {
	
	
	@NotNull
	public static final String MODID = "manyideas_halloween";
	
	@NotNull
	@Override
	public String getModId() {
		
		return MODID;
	}
	
	@Override
	protected void initMod() {
		
		ModBlocksRegisterFactory modBlocksRegisterFactory = registerEventHandler( new ModBlocksRegisterFactory() );
		registerEventHandler( new ModCreativeModeTabRegisterFactory( modBlocksRegisterFactory ) );
	}
}
