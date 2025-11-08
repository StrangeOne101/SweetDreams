package com.strangeone101.sweetdreams.registries;

import com.strangeone101.sweetdreams.SweetDreamsMod;
import dev.architectury.registry.registries.DeferredRegister;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModRegistries {


    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(SweetDreamsMod.MOD_ID, Registries.ITEM);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(SweetDreamsMod.MOD_ID, Registries.BLOCK);


    public static void register() {
        // Force initialization
        ModItems.register();
    }
}
