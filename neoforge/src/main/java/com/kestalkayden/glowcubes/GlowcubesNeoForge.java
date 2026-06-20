package com.kestalkayden.glowcubes;

import java.util.function.Supplier;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** NeoForge entrypoint: registers the glowcube blocks/items and a dedicated creative tab holding them. */
@Mod(Glowcubes.MOD_ID)
public final class GlowcubesNeoForge {

    public static final Logger LOGGER = LoggerFactory.getLogger(Glowcubes.MOD_ID);

    public static final DeferredRegister<CreativeModeTab> TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Glowcubes.MOD_ID);

    public static final Supplier<CreativeModeTab> GLOWCUBES_TAB = TABS.register("glowcubes",
        // builder(Row, int) is a soft vanilla deprecation (legacy creative-menu positioning) with no
        // no-arg replacement in 26.2; modded tabs are appended regardless of the row/column.
        () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
            .title(Component.translatable("itemGroup.glowcubes.glowcubes"))
            .icon(() -> new ItemStack(GlowcubesBlocks.ICON_ITEM.get()))
            .displayItems((params, output) -> {
                for (var item : GlowcubesBlocks.GLOWCUBE_ITEMS) output.accept(item.get());
            })
            .build());

    public GlowcubesNeoForge(IEventBus modBus) {
        LOGGER.info("Initializing Glow Cubes (NeoForge)");

        GlowcubesBlocks.BLOCKS.register(modBus);
        GlowcubesBlocks.ITEMS.register(modBus);
        TABS.register(modBus);
    }
}
