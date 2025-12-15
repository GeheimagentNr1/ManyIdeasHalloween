# AGENTS.md - ManyIdeas Halloween

## Projekt-Übersicht

**ManyIdeas Halloween** ist ein NeoForge Minecraft Mod für Minecraft 1.21.1.
- **Mod ID**: `manyideas_halloween`
- **Package**: `de.geheimagentnr1.manyideas_halloween`
- **Java Version**: 21
- **NeoForge Version**: 21.1.x

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
