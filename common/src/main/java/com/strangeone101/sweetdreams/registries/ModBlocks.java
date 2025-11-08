package com.strangeone101.sweetdreams.registries;

import com.strangeone101.sweetdreams.blocks.AbstractDreamBlock;
import dev.architectury.registry.registries.DeferredSupplier;
import net.minecraft.world.level.block.Block;

public class ModBlocks {

    public static DeferredSupplier<Block> EXAMPLE_DAYDREAM_BLOCK = ModRegistries.BLOCKS.register("daydream/example_block",
            () -> new Block(Block.Properties.of()
                    .strength(1.5f)
            )
    );

    public static DeferredSupplier<Block> EXAMPLE_NIGHTMARE_BLOCK = ModRegistries.BLOCKS.register("nightmare/example_block",
            () -> new Block(Block.Properties.of()
                    .strength(1.5f)
            )
    );

    public static DeferredSupplier<Block> EXAMPLE_DREAM_BLOCK = ModRegistries.BLOCKS.register("dream/example_block",
        () -> new AbstractDreamBlock(Block.Properties.of().strength(1.5f), EXAMPLE_DAYDREAM_BLOCK, EXAMPLE_NIGHTMARE_BLOCK)
    );

    public static void register() {
        ModRegistries.BLOCKS.register();
    }
}
