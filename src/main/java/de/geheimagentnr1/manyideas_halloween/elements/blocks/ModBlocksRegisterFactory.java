package de.geheimagentnr1.manyideas_halloween.elements.blocks;

import de.geheimagentnr1.manyideas_halloween.ManyIdeasHalloween;
import de.geheimagentnr1.manyideas_core.core.elements.blocks.BlocksRegisterFactory;
import de.geheimagentnr1.manyideas_core.core.registry.RegistryEntry;
import de.geheimagentnr1.manyideas_halloween.elements.blocks.halloween.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.jetbrains.annotations.NotNull;

import java.util.List;


@SuppressWarnings( { "StaticNonFinalField", "PublicField", "unused" } )
public class ModBlocksRegisterFactory extends BlocksRegisterFactory {
	
	//TODO:
	// B - Block Textur fertig
	// C - Cullface korrekt
	// P - Partikel fertig
	// F - Funktion fertig
	// I - Item fertig
	// N - Name und Registierungsname vorhanden und fertig
	// R - Rezept fertig
	// L - Loottable fertig
	// T - Tags fertig
	
	//Halloween
	
	public static AutumnLeavesCarpet AUTUMN_LEAVES_CARPET;
	
	public static Gravestone GRAVESTONE;
	
	public static HayBundle HAY_BUNDLE;
	
	public static Pitchfork PITCHFORK;
	
	public static PumpkinLantern PUMPKIN_LANTERN;
	
	public static Scarecrow SCARECROW;
	
	public static Skeleton SKELETON;
	
	public static SpiderPlushi SPIDER_PLUSHI;
	
	public static Spiderweb SPIDERWEB;
	
	public static WreathWheat WREATH_WEATH;
	
	@NotNull
	@Override
	protected String getModId() {
		
		return ManyIdeasHalloween.MODID;
	}
	
	@SubscribeEvent
	public void registerEvent( @NotNull RegisterEvent event ) {
		
		doRegisterEvent( event );
	}
	
	@NotNull
	@Override
	protected List<RegistryEntry<Block>> blocks() {
		
		return List.of(//BCPFINRLT
			RegistryEntry.create( AutumnLeavesCarpet.registry_name, new AutumnLeavesCarpet() ),//BCPFINRLT
			RegistryEntry.create( Gravestone.registry_name, new Gravestone() ),//BCPFINRLT
			RegistryEntry.create( HayBundle.registry_name, new HayBundle() ),//BCPFINRLT
			RegistryEntry.create( Pitchfork.registry_name, new Pitchfork() ),//BCPFINRLT
			RegistryEntry.create( PumpkinLantern.registry_name, new PumpkinLantern() ),//BCPFINRLT
			RegistryEntry.create( Scarecrow.registry_name, new Scarecrow() ),//BCPFINRLT
			RegistryEntry.create( Skeleton.registry_name, new Skeleton() ),//BCPFINRLT
			RegistryEntry.create( SpiderPlushi.registry_name, new SpiderPlushi() ),//BCPFINRLT
			RegistryEntry.create( Spiderweb.registry_name, new Spiderweb() ),//BCPFINRLT
			RegistryEntry.create( WreathWheat.registry_name, new WreathWheat() )//BCPFINRLT
		);
	}
}
