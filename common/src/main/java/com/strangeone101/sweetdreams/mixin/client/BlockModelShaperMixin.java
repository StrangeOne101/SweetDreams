package com.strangeone101.sweetdreams.mixin.client;

import com.strangeone101.sweetdreams.blocks.AbstractDreamBlock;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BlockModelShaper.class)
public class BlockModelShaperMixin {

    @ModifyArg(
            method = "getBlockModel",
            at = @At(value = "INVOKE",
                    target = "Ljava/util/Map;get(Ljava/lang/Object;)Ljava/lang/Object;")
    )
    public Object getBlockModelInject(Object key) {
        if (((BlockState)key).getBlock() instanceof AbstractDreamBlock dreamBlock) {

            //TODO Check which dream type the player is in and return the appropriate model
            return dreamBlock.getDaydreamState((BlockState) key);
        }
        return key;
    }
}
