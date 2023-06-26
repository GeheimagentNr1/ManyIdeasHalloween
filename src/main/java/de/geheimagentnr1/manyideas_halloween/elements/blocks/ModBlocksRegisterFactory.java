package de.geheimagentnr1.manyideas_halloween.elements.blocks;

import de.geheimagentnr1.manyideas_halloween.ManyIdeasHalloween;
import de.geheimagentnr1.manyideas_halloween.elements.blocks.halloween.*;
import de.geheimagentnr1.minecraft_forge_api.elements.blocks.BlocksRegisterFactory;
import de.geheimagentnr1.minecraft_forge_api.registry.RegistryEntry;
import de.geheimagentnr1.minecraft_forge_api.registry.RegistryKeys;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ObjectHolder;
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
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasHalloween.MODID + ":" + AutumnLeavesCarpet.registry_name )
	public static AutumnLeavesCarpet AUTUMN_LEAVES_CARPET;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasHalloween.MODID + ":" + Gravestone.registry_name )
	public static Gravestone GRAVESTONE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasHalloween.MODID + ":" + HayBundle.registry_name )
	public static HayBundle HAY_BUNDLE;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasHalloween.MODID + ":" + Pitchfork.registry_name )
	public static Pitchfork PITCHFORK;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasHalloween.MODID + ":" + PumpkinLantern.registry_name )
	public static PumpkinLantern PUMPKIN_LANTERN;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasHalloween.MODID + ":" + Scarecrow.registry_name )
	public static Scarecrow SCARECROW;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasHalloween.MODID + ":" + Skeleton.registry_name )
	public static Skeleton SKELETON;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasHalloween.MODID + ":" + SpiderPlushi.registry_name )
	public static SpiderPlushi SPIDER_PLUSHI;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasHalloween.MODID + ":" + Spiderweb.registry_name )
	public static Spiderweb SPIDERWEB;
	
	@ObjectHolder( registryName = RegistryKeys.BLOCKS,
		value = ManyIdeasHalloween.MODID + ":" + WreathWheat.registry_name )
	public static WreathWheat WREATH_WEATH;
	
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
