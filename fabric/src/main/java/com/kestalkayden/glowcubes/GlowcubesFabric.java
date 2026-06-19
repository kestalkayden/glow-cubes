package com.kestalkayden.glowcubes;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Fabric entrypoint: registers the glowcube blocks/items and a dedicated creative tab holding them. */
public class GlowcubesFabric implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger(Glowcubes.MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Glow Cubes (Fabric)");

        GlowcubesBlocks.register();

        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Glowcubes.MOD_ID, "glowcubes"),
            // builder(Row, int) is a soft vanilla deprecation (legacy creative-menu positioning) with
            // no no-arg replacement in 26.2; modded tabs are appended regardless of the row/column.
            CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                .title(Component.translatable("itemGroup.glowcubes.glowcubes"))
                .icon(() -> new ItemStack(GlowcubesBlocks.GLOWCUBE_ITEMS.get(0)))
                .displayItems((params, output) -> {
                    for (var item : GlowcubesBlocks.GLOWCUBE_ITEMS) output.accept(item);
                })
                .build());
    }
}
