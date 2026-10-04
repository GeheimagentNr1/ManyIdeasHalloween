# CLAUDE.md - ManyIdeas Halloween

## Projekt-Übersicht

**ManyIdeas Halloween** ist ein NeoForge Minecraft Mod.
- **Mod ID**: `manyideas_halloween`
- **Package**: `de.geheimagentnr1.manyideas_halloween`
- **Java Version**: 21 (`develop_26.1`/`develop_26.3`: 25, `jdk-25.0.4.7-hotspot`)
- **NeoForge Version**: je Branch, siehe Tabelle

| Branch | MC | Range | NeoForge (kompiliert gegen) | Core-Jar (`mic_minecraft_version`) | Hinweis |
|---|---|---|---|---|---|
| `develop_1.21.1` | 1.21.1 | `[1.21.1,1.21.2)` | `21.1.216` | 1.21.1 | Fix-Release 2.0.2 (Herbstlaub-Teppich kompostierbar über die Data-Map `data/neoforge/data_maps/item/compostables.json`) |
| `develop_1.21.2` | 1.21.2 - 1.21.11 | `[1.21.2,1.21.12)` | `21.2.1-beta` | 1.21.2 | Ein Jar (Bytecode identisch 1.21.2 - 1.21.11); Blöcke per Supplier + `RegistryHelper.withBlockId`, Rezept-JSON, Client-Item-Definitionen, Ketten-Overlay (siehe unten) |
| `develop_26.1` | 26.1 - 26.2 | `[26.1,26.3)` | `26.1.0.19-beta` (Java 25) | 26.1 | 26.x-Tooling, Kette direkt `minecraft:block/iron_chain` |
| `develop_26.3` | 26.3 | `[26.3,27)` | `26.3.0.36-beta` (Java 25) | 26.3 | Kompostierbarkeit als Item-Komponente (`Item.Properties.compostable(..)` + `context_int_provider/compostable/autumn_leaves_carpet.json`), Loot in beiden Formaten |

Alle 2.0.2, released 2026-10-04 (ingame getestet auf 1.21.1, 1.21.2, 1.21.8, 1.21.9, 1.21.11, 26.1, 26.2, 26.3), abhängig von ManyIdeasCore `[3.0.2,)`. Die Core-Abhängigkeit hängt an `mic_minecraft_version`, damit ein Jar mehrere Core-Jars abdecken kann. Details: [`../Docs/migrations/1.21.1-to-1.21.2.md`](../Docs/migrations/1.21.1-to-1.21.2.md) 4i, [`../Docs/migrations/1.21.11-to-26.1.md`](../Docs/migrations/1.21.11-to-26.1.md).

**Kette der hängenden Kürbislaterne (1.21.2-Jar):** MC 1.21.9 hat `block/chain` in `block/iron_chain` umbenannt. Die Modelle im Basis-Paket nutzen `iron_chain`; das Overlay `mc_1_21_2` (in `pack.mcmeta` mit `formats` **und** `min_format`/`max_format` `[34,64]`) liefert für 1.21.2 - 1.21.8 die alten Modelle mit `block/chain`. Umgekehrt (Overlay ab 65 mit `formats`) verwirft der 1.21.9+-Client das ganze Overlay - der Server meldet nichts.

**Creative-Tab:** Die Blöcke kommen über `getDisplayBlocks()`, `getDisplayItems()` ist leer. Beide gefüllt fügte jedes Item doppelt ein - ab NeoForge 26.2.0.88 Absturz beim Öffnen des Kreativinventars (bis 2.0.1 im Code, gefixt in 2.0.2).

Bietet 10 niedliche und gruselige Halloween-Dekorationsblöcke.

## Abhängigkeiten

- **ManyIdeas Core** (`manyideas_core`) - Required

## Projektstruktur

```
src/main/java/de/geheimagentnr1/manyideas_halloween/
├── ManyIdeasHalloween.java                # Haupt-Mod-Klasse (erweitert AbstractMod)
└── elements/
    ├── block_state_properties/            # Custom BlockState Properties
    │   └── ModBlockStateProperties.java
    ├── blocks/                            # Block-Definitionen
    │   └── ModBlocksRegisterFactory.java
    └── creative_mod_tabs/                 # Creative-Tab Registration
        ├── ManyIdeasHalloweenCreativeModeTabFactory.java
        └── ModCreativeModeTabRegisterFactory.java
```

## Architektur

Dieser Mod erweitert `AbstractMod` aus ManyIdeas Core:
```java
@Mod( ManyIdeasHalloween.MODID )
public class ManyIdeasHalloween extends AbstractMod {
    @Override
    protected void initMod() {
        ModBlocksRegisterFactory modBlocksRegisterFactory = registerEventHandler( new ModBlocksRegisterFactory() );
        registerEventHandler( new ModCreativeModeTabRegisterFactory( modBlocksRegisterFactory ) );
    }
}
```

## Code-Stil

- **Annotations**: `@NotNull` aus `org.jetbrains.annotations`
- **Lombok**: Projekt nutzt Lombok
- **Formatierung**: Leerzeichen nach `(` und vor `)` bei Methodenaufrufen

## Build & Test

```bash
./gradlew build
./gradlew runClient
./gradlew runServer
```

## Deployment

- **CurseForge**: `./gradlew curseforge`
- **Modrinth**: `./gradlew modrinth`

## Testing

### Java-Versionen

Verschiedene Java-Versionen sind unter `C:\Program Files\Eclipse Adoptium` installiert. Für einen Gradle-Build muss die passende Java-Version gewählt werden:

```powershell
# Java 21 für MC 1.20.5+ (NeoForge)
$env:JAVA_HOME = "C:\Program Files\Eclipse Adoptium\jdk-21.0.12.8-hotspot"
./gradlew build
```

### Unit Tests (JUnit 5)

Für reine Logik-Tests ohne Minecraft-Abhängigkeiten:

```bash
./gradlew test
```

Tests liegen unter `src/test/java/`. Ergebnisse: `build/reports/tests/test/index.html`

### NeoForge GameTest Framework

Für Integration Tests in einer echten Minecraft-Umgebung:

```bash
./gradlew runGameTestServer
```

Der triviale GameTest wurde beim 1.21.2-Port entfernt (annotationsbasierte GameTests gibt es ab 1.21.5 nicht mehr; im 1.21.1-Branch noch vorhanden).

### CI/CD (GitHub Actions)

Der Workflow `.github/workflows/build-and-test.yml` führt automatisch aus:
1. **Build**: Kompiliert den Mod
2. **Unit Tests**: Führt JUnit Tests aus
3. **GameTests**: Startet GameTestServer (optional)

### Was kann automatisiert getestet werden?

| Aspekt | Automatisiert? | Methode |
|--------|----------------|---------|
| Utility-Klassen | ✅ | JUnit |
| Config-Parsing | ✅ | JUnit |
| Commands | ✅ | GameTest |
| Block/Item-Verhalten | ✅ | GameTest |
| Multi-MC-Version | ⚠️ Pro Branch | CI Matrix |

## Referenzen

- [NeoForge Migration Primer](https://docs.neoforged.net/primer/docs/) — Dokumentiert API-Aenderungen zwischen Minecraft/NeoForge-Versionen; nuetzlich fuer die Pruefung von Breaking Changes beim Upgrade auf neue Versionen

---

## Wissensdatenbank

Versionsübergreifende Migrations- und Entwicklungs-Erkenntnisse (Breaking Changes, Fixes, Testumgebungs-Patterns) werden zentral in [`../Docs/`](../Docs/) gepflegt. Bei neuen relevanten Erkenntnissen dort ergänzen, nicht nur hier.
