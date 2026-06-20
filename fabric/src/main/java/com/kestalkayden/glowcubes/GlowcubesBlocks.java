package com.kestalkayden.glowcubes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/** Fabric block + item registration for the 17 glowcubes. */
public final class GlowcubesBlocks {

    /** All 17 glowcube block-items in creative-tab order — populated by {@link #register()}. */
    public static final List<BlockItem> GLOWCUBE_ITEMS = new ArrayList<>();

    /** The {@link Glowcubes#ICON_NAME} glowcube, used as the creative-tab icon. Set during registration. */
    public static BlockItem ICON_ITEM;

    private GlowcubesBlocks() {}

    public static void register() {
        for (String name : Glowcubes.names()) {
            registerGlowcube(name);
        }
    }

    private static void registerGlowcube(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(Glowcubes.MOD_ID, name);
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, id);
        Block block = Registry.register(BuiltInRegistries.BLOCK, id,
            new Block(Glowcubes.properties().setId(blockKey)));

        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, id);
        BlockItem item = Registry.register(BuiltInRegistries.ITEM, id,
            new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix()));
        GLOWCUBE_ITEMS.add(item);
        if (name.equals(Glowcubes.ICON_NAME)) ICON_ITEM = item;
    }
}
