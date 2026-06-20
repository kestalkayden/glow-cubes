# Glow Cubes

**Bright, full-block light sources in every dye color.** A small decorative-block mod for Fabric and
NeoForge on Minecraft 26.1.

## What it adds

17 glowcubes — an undyed base plus all 16 dye colors. Each is a full cube that emits **light level
13** with a translucent shell and a softly glowing inner core, so they double as clean lighting and
colorful building blocks.

- **Craft the base**: surround a glowstone dust with honeycomb (8 honeycomb + 1 glowstone dust).
- **Dye it**: combine a glowcube with any dye to get that color. Re-dye anytime.
- Glass-like (soft, breaks fast), full-block collision, no redstone or special behavior — just light.

## Requirements

- Minecraft **26.1.x**
- Java **25+**
- **Fabric:** Fabric Loader 0.18.4+, Fabric API
- **NeoForge:** 26.1.2.55-beta+

## Building from source

```bash
./gradlew buildAll            # both loaders + the common purity check
./gradlew :fabric:build       # Fabric only
./gradlew :neoforge:build     # NeoForge only
```

Output jars land in `fabric/build/libs/` and `neoforge/build/libs/`.

## Relationship to Hydrofarm

Glow Cubes is the standalone home of the glowcubes that also ship inside [Hydrofarm](https://github.com/kestalkayden/hydrofarm).
When **both** mods are installed, Hydrofarm yields: it hides its own glowcubes from creative and
disables their recipes, so you get a single, seamless set (this mod's) — no duplicates. Install this
mod alone if you just want the glowcubes without the rest of Hydrofarm.

## License

MIT — see [LICENSE](LICENSE).
