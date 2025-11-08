package com.strangeone101.sweetdreams.mixin.client;

import com.strangeone101.sweetdreams.blocks.AbstractDreamBlock;
import com.strangeone101.sweetdreams.item.AbstractDreamItem;
import net.minecraft.client.renderer.ItemModelShaper;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ItemModelShaper.class)
public class ItemModelShaperMixin {

    @ModifyArg(
            method = "getIndex",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/item/Item;getId(Lnet/minecraft/world/item/Item;)I")
    )
    private static Item getIndex(Item key) {
        if (key instanceof AbstractDreamItem dreamItem) {

            //TODO Check which dream type the player is in and return the appropriate model
            return dreamItem.getDaydreamItem().get();
        }
        return key;
    }
}
