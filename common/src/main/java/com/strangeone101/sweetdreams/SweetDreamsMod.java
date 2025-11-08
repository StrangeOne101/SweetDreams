package com.strangeone101.sweetdreams;

import com.strangeone101.sweetdreams.registries.ModRegistries;

public final class SweetDreamsMod {
    public static final String MOD_ID = "sweet_dreams";

    public static void init() {
        ModRegistries.register();
    }
}
