package com.kestalkayden.glowcubes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

/**
 * Shared, loader-agnostic glowcube definitions: the mod id, the ordered list of block names, and the
 * common block properties. Pure vanilla API — no Fabric/NeoForge imports — so it lives in {@code
 * common} and is compiled into both loader jars plus the standalone {@code :common} purity check.
 * The per-loader {@code GlowcubesBlocks} classes consume this to register the 17 blocks identically.
 */
public final class Glowcubes {

    public static final String MOD_ID = "glowcubes";

    private Glowcubes() {}

    /** The 17 glowcube registry/asset names in creative-tab order: the undyed base, then DyeColor
     *  order (white, orange, …, black). Registry ids are {@code glowcubes:<name>}. */
    public static List<String> names() {
        List<String> names = new ArrayList<>(1 + DyeColor.values().length);
        names.add("glowcube");
        for (DyeColor color : DyeColor.values()) {
            names.add(color.getName() + "_glowcube");
        }
        return names;
    }

    /** Block properties shared by every glowcube — a glass-soft, full-cube, always-on light-13 source.
     *  Returns a fresh instance each call; the caller appends {@code .setId(...)} for its registry key. */
    public static BlockBehaviour.Properties properties() {
        return BlockBehaviour.Properties.of()
            .strength(0.3F)
            .sound(SoundType.GLASS)
            .mapColor(MapColor.GLOW_LICHEN)
            .lightLevel(state -> 13)
            .noOcclusion();
    }
}
