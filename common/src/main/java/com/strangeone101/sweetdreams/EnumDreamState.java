package com.strangeone101.sweetdreams;

import dev.architectury.platform.Platform;
import net.fabricmc.api.EnvType;

public enum EnumDreamState {

    DAYDREAM,
    NIGHTMARE,
    NONE;

    public boolean isDreaming() {
        return this != NONE;
    }

    public static EnumDreamState getState() {
        //Check if we are on a client
        if (Platform.getEnv() == EnvType.SERVER) {
            return NONE;
        }

        //TODO: Implement dream state checking
        return DAYDREAM;
    }
}
