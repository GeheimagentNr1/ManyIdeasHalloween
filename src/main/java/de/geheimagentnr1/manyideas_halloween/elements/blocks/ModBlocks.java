package de.geheimagentnr1.manyideas_halloween.elements.blocks;

import de.geheimagentnr1.manyideas_halloween.ManyIdeasHalloween;
import de.geheimagentnr1.manyideas_halloween.elements.blocks.halloween.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ObjectHolder;


@SuppressWarnings( { "StaticNonFinalField", "PublicField", "PublicStaticArrayField", "unused" } )
public class ModBlocks {
	
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
	
	public static final Block[] BLOCKS = new Block[] {//BCPFINRLT
		new AutumnLeavesCarpet(),//BCPFINRLT
		new Gravestone(),//BCPFINRLT
		new HayBundle(),//BCPFINRLT
		new Pitchfork(),//BCPFINRLT
		new PumpkinLantern(),//BCPFINRLT
		new Scarecrow(),//BCPFINRLT
		new Skeleton(),//BCPFINRLT
		new SpiderPlushi(),//BCPFINRLT
		new Spiderweb(),//BCPFINRLT
		new WreathWheat(),//BCPFINRLT
	};
	
	//Halloween
	
	@ObjectHolder( ManyIdeasHalloween.MODID + ":" + AutumnLeavesCarpet.registry_name )
	public static AutumnLeavesCarpet AUTUMN_LEAVES_CARPET;
	
	@ObjectHolder( ManyIdeasHalloween.MODID + ":" + Gravestone.registry_name )
	public static Gravestone GRAVESTONE;
	
	@ObjectHolder( ManyIdeasHalloween.MODID + ":" + HayBundle.registry_name )
	public static HayBundle HAY_BUNDLE;
	
	@ObjectHolder( ManyIdeasHalloween.MODID + ":" + Pitchfork.registry_name )
	public static Pitchfork PITCHFORK;
	
	@ObjectHolder( ManyIdeasHalloween.MODID + ":" + PumpkinLantern.registry_name )
	public static PumpkinLantern PUMPKIN_LANTERN;
	
	@ObjectHolder( ManyIdeasHalloween.MODID + ":" + Scarecrow.registry_name )
	public static Scarecrow SCARECROW;
	
	@ObjectHolder( ManyIdeasHalloween.MODID + ":" + Skeleton.registry_name )
	public static Skeleton SKELETON;
	
	@ObjectHolder( ManyIdeasHalloween.MODID + ":" + SpiderPlushi.registry_name )
	public static SpiderPlushi SPIDER_PLUSHI;
	
	@ObjectHolder( ManyIdeasHalloween.MODID + ":" + Spiderweb.registry_name )
	public static Spiderweb SPIDERWEB;
	
	@ObjectHolder( ManyIdeasHalloween.MODID + ":" + WreathWheat.registry_name )
	public static WreathWheat WREATH_WEATH;
}
