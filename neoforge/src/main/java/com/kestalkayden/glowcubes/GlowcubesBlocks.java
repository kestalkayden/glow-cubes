package com.kestalkayden.glowcubes;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

/** NeoForge block + item registration for the 17 glowcubes. */
public final class GlowcubesBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Glowcubes.MOD_ID);
    public static final DeferredRegister.Items  ITEMS  = DeferredRegister.createItems(Glowcubes.MOD_ID);

    /** All 17 glowcube block-items in creative-tab order. The static initialiser runs when this class
     *  is first referenced (the entrypoint touches BLOCKS before registering it to the mod bus). */
    public static final List<DeferredItem<BlockItem>> GLOWCUBE_ITEMS = new ArrayList<>();
    static {
        for (String name : Glowcubes.names()) {
            registerGlowcube(name);
        }
    }

    private GlowcubesBlocks() {}

    private static void registerGlowcube(String name) {
        DeferredBlock<Block> block = BLOCKS.register(name, id ->
            new Block(Glowcubes.properties().setId(ResourceKey.create(Registries.BLOCK, id))));
        GLOWCUBE_ITEMS.add(ITEMS.register(name, id ->
            new BlockItem(block.get(),
                new Item.Properties().setId(ResourceKey.create(Registries.ITEM, id)).useBlockDescriptionPrefix())));
    }
}
