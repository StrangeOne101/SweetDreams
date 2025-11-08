package com.strangeone101.sweetdreams.item;

import com.strangeone101.sweetdreams.EnumDreamState;
import dev.architectury.registry.registries.DeferredSupplier;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class AbstractDreamItem extends Item {

    protected DeferredSupplier<Item> daydreamItem;
    protected DeferredSupplier<Item> nightdreamItem;

    public AbstractDreamItem(Properties properties, DeferredSupplier<Item> daydreamItem, DeferredSupplier<Item> nightdreamItem) {
        super(properties);
        this.daydreamItem = daydreamItem;
        this.nightdreamItem = nightdreamItem;
    }

    public DeferredSupplier<Item> getDaydreamItem() {
        return daydreamItem;
    }

    public DeferredSupplier<Item> getNightdreamItem() {
        return nightdreamItem;
    }

    @Override
    public Component getDescription() {
        return switch (EnumDreamState.getState()) {
            case DAYDREAM -> this.daydreamItem.get().getDescription();
            case NIGHTMARE -> this.nightdreamItem.get().getDescription();
            default -> super.getDescription();
        };
    }

    @Override
    public Component getName(ItemStack itemStack) {
        return switch (EnumDreamState.getState()) {
            case DAYDREAM -> this.daydreamItem.get().getName(itemStack);
            case NIGHTMARE -> this.nightdreamItem.get().getName(itemStack);
            default -> super.getName(itemStack);
        };
    }

    @Override
    public SoundEvent getBreakingSound() {
        return switch (EnumDreamState.getState()) {
            case DAYDREAM -> this.daydreamItem.get().getBreakingSound();
            case NIGHTMARE -> this.nightdreamItem.get().getBreakingSound();
            default -> super.getBreakingSound();
        };
    }

    @Override
    public SoundEvent getDrinkingSound() {
        return switch (EnumDreamState.getState()) {
            case DAYDREAM -> this.daydreamItem.get().getDrinkingSound();
            case NIGHTMARE -> this.nightdreamItem.get().getDrinkingSound();
            default -> super.getDrinkingSound();
        };
    }

    @Override
    public SoundEvent getEatingSound() {
        return switch (EnumDreamState.getState()) {
            case DAYDREAM -> this.daydreamItem.get().getEatingSound();
            case NIGHTMARE -> this.nightdreamItem.get().getEatingSound();
            default -> super.getEatingSound();
        };
    }

    @Override
    public String getDescriptionId() {
        return switch (EnumDreamState.getState()) {
            case DAYDREAM -> this.daydreamItem.get().getDescriptionId();
            case NIGHTMARE -> this.nightdreamItem.get().getDescriptionId();
            default -> super.getDescriptionId();
        };
    }
}
