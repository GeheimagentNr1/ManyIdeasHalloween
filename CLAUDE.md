# CLAUDE.md - ManyIdeas Halloween

10 gruselige Halloween-Dekorationsblöcke: Herbstlaub-Teppich, Grabstein, Heuballen, Mistgabel, hängende Kürbislaterne, Vogelscheuche, Skelett, Spinnen-Plüschtier, Spinnennetz, Weizenkranz. Mod-ID `manyideas_halloween`, Package `de.geheimagentnr1.manyideas_halloween`, Client+Server. Baut auf ManyIdeasCore auf.

Diese Datei ist auf allen `develop_*`-Branches identisch; Quelle: `../Docs/mod-claude/ManyIdeasHalloween.md` (Änderungen dort, dann `Docs/tools/sync_mod_claude_md.sh`). Versionsstand: [`../Docs/VERSIONEN.md`](../Docs/VERSIONEN.md).

## Versionen

- Jars, Branches, Ranges und Tags: [`../Docs/VERSIONEN.md`](../Docs/VERSIONEN.md). NeoForge ab `develop_1.21.1`, Forge `develop_1.18.1` - `develop_1.21` plus `develop_1.21.1_forge`.
- Core kommt als Maven-Jar `ManyIdeasCore-<mc>:${mic_version}` aus `ModdingMavenRepositories` (`custom.gradle`). Bis 1.21.1 (auch Forge) ist `<mc>` = `${minecraft_version}`, ab 1.21.2 `${mic_minecraft_version}` - bewusst getrennt, damit ein Halloween-Jar gegen das Core-Jar der niedrigsten Version kompiliert und mehrere Core-Jars abdecken kann (ein Jar 1.21.2 - 1.21.11 auf sechs Core-Jars, Bytecode identisch).
- Die 1.21.1-Releases bis 2.0.1 hatten Range bis 1.21.10, laden wegen Core aber nur auf 1.21.1.
- CurseForge-Projekt `689461`, Modrinth `ieztyjIS`.

## Abhängigkeiten

- **ManyIdeasCore** (`manyideas_core`, required) - `AbstractMod`, Registrierung, Tischsägen-Rezepttypen (`manyideas_core:table_sawing_stone|iron|diamond`).
- Keine RecipesLibrary. Forge 1.20 - 1.21.1-Forge zusätzlich MinecraftForgeAPI ([`../Docs/forge/README.md`](../Docs/forge/README.md)).

## Architektur

- `ManyIdeasHalloween` erweitert Core-`AbstractMod` (Forge 1.20+: aus MinecraftForgeAPI), registriert `ModBlocksRegisterFactory` + `ModCreativeModeTabRegisterFactory`.
- `elements/blocks/halloween/` - je Block eine Klasse (`AutumnLeavesCarpet`, `Gravestone`, `HayBundle`, `Pitchfork`, `PumpkinLantern`, `Scarecrow`, `Skeleton`, `SpiderPlushi`, `Spiderweb`, `WreathWheat`).
- `elements/block_state_properties/ModBlockStateProperties`, `elements/creative_mod_tabs/` (Blöcke über `getDisplayBlocks()`, `getDisplayItems()` leer).
- Reine Dekorationsblöcke ohne BlockEntity und ohne Netzwerk; die meiste Arbeit beim Portieren steckt in Ressourcen (Modelle, Item-Definitionen, Rezepte, Loot).

## Funktionen, Befehle, Konfiguration

Keine Befehle, keine Config. Der Herbstlaub-Teppich ist kompostierbar.

## Fallstricke

- **Registrierung ab 1.21.2:** `RegistryEntry.create( name, () -> new X() )`; Blöcke, die direkt Vanilla-Klassen erweitern, setzen die ID mit `RegistryHelper.withBlockId(..)` (siehe Core).
- **Kette der hängenden Kürbislaterne:** MC 1.21.9 benennt `block/chain` in `block/iron_chain` um. Basis-Modelle nutzen `iron_chain`; Overlay `mc_1_21_2` in `pack.mcmeta` mit `formats` **und** `min_format`/`max_format` `[34,64]` liefert für 1.21.2 - 1.21.8 die alten Modelle mit `block/chain`. Ein Overlay ab Format 65 mit `formats` verwirft der 1.21.9+-Client komplett - nur im Client-Log sichtbar. 26.x-Branches ohne Overlay.
- **Kompostierbarkeit:** NeoForge liest nur die Data-Map `data/neoforge/data_maps/item/compostables.json` (bis 26.2); ab 26.3 `Item.Properties.compostable(..)` + `data/manyideas_halloween/context_int_provider/compostable/autumn_leaves_carpet.json`.
- **Creative-Tab:** nie dieselben Items über `getDisplayBlocks()` und `getDisplayItems()` ausgeben - ab NeoForge 26.2.0.88 Absturz beim Öffnen des Kreativinventars (bis 2.0.1 betroffen).
- **26.3:** Loot-Tabellen in beiden Formaten (`conditions`/`functions` und `condition`/`modifier`).
- Rezept-JSON ab 1.21.2: Vanilla-Ingredients als String, Item-Definitionen unter `assets/manyideas_halloween/items` ab 1.21.4.

## Testen

- Allgemein: [`../Docs/testing/README.md`](../Docs/testing/README.md). Mit passendem Core-Jar in Server-Pack und Client-Instanz.
- Prüfpunkte: Kürbislaterne mit Kette auf 1.21.8 **und** 1.21.9+ (Client-Log auf verworfene Overlays/Modelle), Herbstlaub-Teppich im Komposter, Kreativinventar öffnen, Tischsägen-Rezepte, Blöcke abbauen (Drops).

## Links

- Wiki: https://github.com/GeheimagentNr1/ManyIdeasHalloween/wiki
- CurseForge: https://www.curseforge.com/minecraft/mc-mods/manyideas-halloween, Modrinth: https://modrinth.com/mod/ieztyjIS
- [`../Docs/migrations/1.21.1-to-1.21.2.md`](../Docs/migrations/1.21.1-to-1.21.2.md) 4i, [`../Docs/migrations/1.21.11-to-26.1.md`](../Docs/migrations/1.21.11-to-26.1.md), [`../Docs/migrations/BREAKING_CHANGES.md`](../Docs/migrations/BREAKING_CHANGES.md)
