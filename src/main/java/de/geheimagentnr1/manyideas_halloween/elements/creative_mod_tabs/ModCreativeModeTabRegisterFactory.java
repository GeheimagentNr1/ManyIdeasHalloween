package de.geheimagentnr1.manyideas_halloween.elements.creative_mod_tabs;

import de.geheimagentnr1.manyideas_core.core.elements.creative_mod_tabs.CreativeModeTabFactory;
import de.geheimagentnr1.manyideas_core.core.elements.creative_mod_tabs.CreativeModeTabRegisterFactory;
import de.geheimagentnr1.manyideas_halloween.elements.blocks.ModBlocksRegisterFactory;
import lombok.RequiredArgsConstructor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;


@RequiredArgsConstructor
public class ModCreativeModeTabRegisterFactory extends CreativeModeTabRegisterFactory {
	
	
	@NotNull
	private final ModBlocksRegisterFactory modBlocksRegisterFactory;
	
	@SubscribeEvent
	public void registerEvent( @NotNull RegisterEvent event ) {
		
		doRegisterEvent( event );
	}
	
	@NotNull
	@Override
	protected List<CreativeModeTabFactory> factories() {
		
		return List.of(
			new ManyIdeasHalloweenCreativeModeTabFactory( modBlocksRegisterFactory )
		);
	}
}
