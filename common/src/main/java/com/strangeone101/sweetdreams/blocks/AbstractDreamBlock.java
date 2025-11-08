package com.strangeone101.sweetdreams.blocks;

import com.strangeone101.sweetdreams.EnumDreamState;
import dev.architectury.registry.registries.DeferredSupplier;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

import java.util.HashMap;
import java.util.Map;

public class AbstractDreamBlock extends Block {

    protected DeferredSupplier<Block> daydreamBlock;
    protected DeferredSupplier<Block> nightdreamBlock;

    protected Map<BlockState, BlockState> dayDreamStates;
    protected Map<BlockState, BlockState> nightDreamStates;

    public AbstractDreamBlock(Properties properties, DeferredSupplier<Block> daydreamBlock, DeferredSupplier<Block> nightdreamBlock) {
        super(properties);

        this.daydreamBlock = daydreamBlock;
        this.nightdreamBlock = nightdreamBlock;
    }

    public DeferredSupplier<Block> getDaydreamBlock() {
        return daydreamBlock;
    }

    public DeferredSupplier<Block> getNightdreamBlock() {
        return nightdreamBlock;
    }

    public BlockState getDaydreamState(BlockState currentState) {
        if (dayDreamStates == null) {
            initializeStateMaps();
        }
        return dayDreamStates.get(currentState);
    }

    @Override
    protected RenderShape getRenderShape(BlockState blockState) {
        switch (EnumDreamState.getState()) {
            case DAYDREAM -> {
                return this.daydreamBlock.get().getRenderShape(blockState);
            }
            case NIGHTMARE -> {
                return this.nightdreamBlock.get().getRenderShape(blockState);
            }
            default -> {
                return super.getRenderShape(blockState);
            }
        }
    }

    @Override
    public float getSpeedFactor() {
        switch (EnumDreamState.getState()) {
            case DAYDREAM -> {
                return this.daydreamBlock.get().getSpeedFactor();
            }
            case NIGHTMARE -> {
                return this.nightdreamBlock.get().getSpeedFactor();
            }
            default -> {
                return super.getSpeedFactor();
            }
        }
    }

    @Override
    public float getExplosionResistance() {
        switch (EnumDreamState.getState()) {
            case DAYDREAM -> {
                return this.daydreamBlock.get().getExplosionResistance();
            }
            case NIGHTMARE -> {
                return this.nightdreamBlock.get().getExplosionResistance();
            }
            default -> {
                return super.getExplosionResistance();
            }
        }
    }

    @Override
    public float getJumpFactor() {
        switch (EnumDreamState.getState()) {
            case DAYDREAM -> {
                return this.daydreamBlock.get().getJumpFactor();
            }
            case NIGHTMARE -> {
                return this.nightdreamBlock.get().getJumpFactor();
            }
            default -> {
                return super.getJumpFactor();
            }
        }
    }

    @Override
    public MutableComponent getName() {
        switch (EnumDreamState.getState()) {
            case DAYDREAM -> {
                return this.daydreamBlock.get().getName();
            }
            case NIGHTMARE -> {
                return this.nightdreamBlock.get().getName();
            }
            default -> {
                return super.getName();
            }
        }
    }

    @Override
    protected int getLightBlock(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos) {
        switch (EnumDreamState.getState()) {
            case DAYDREAM -> {
                return this.daydreamBlock.get().getLightBlock(blockState, blockGetter, blockPos);
            }
            case NIGHTMARE -> {
                return this.nightdreamBlock.get().getLightBlock(blockState, blockGetter, blockPos);
            }
            default -> {
                return super.getLightBlock(blockState, blockGetter, blockPos);
            }
        }
    }

    /**
     * Caches the blockstates for easy conversion
     */
    private void initializeStateMaps() {
        this.dayDreamStates = new HashMap<>();
        this.nightDreamStates = new HashMap<>();

        for (BlockState state : this.getStateDefinition().getPossibleStates()) {
            this.dayDreamStates.put(state, this.daydreamBlock.get().withPropertiesOf(state));
            this.nightDreamStates.put(state, this.nightdreamBlock.get().withPropertiesOf(state));
        }
    }


}
