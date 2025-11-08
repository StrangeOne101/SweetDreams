package com.strangeone101.sweetdreams.registries;

import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.world.item.Item;

import static com.strangeone101.sweetdreams.registries.ModRegistries.ITEMS;

public class ModItems {

    public static final RegistrySupplier<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties()));

    public static void register() {
        ITEMS.register();
    }
}
