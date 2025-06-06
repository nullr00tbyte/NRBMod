// WeedCropBlock.java
package blackpi.org.rootkz.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.function.Supplier;

public class WeedCropBlock extends CropBlock {
    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            // Etapa 0: Pequeño brote (2px)
            Block.createCuboidShape(6.0, 0.0, 6.0, 10.0, 2.0, 10.0),

            // Etapa 1-2: Base más ancha, altura media
            Block.createCuboidShape(4.0, 0.0, 4.0, 12.0, 5.0, 12.0),
            Block.createCuboidShape(3.0, 0.0, 3.0, 13.0, 8.0, 13.0),
            // Etapa 3-4: Forma de pirámide
            Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 10.0, 14.0),
            Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 12.0, 15.0),
            // Etapa 5-6: Capas superiores más estrechas
            Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 14.0, 15.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 16.0),
            // Etapa 7 (madura): Forma espesa con "cogollos"
            VoxelShapes.union(
                    Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 8.0, 15.0),
                    Block.createCuboidShape(4.0, 8.0, 4.0, 12.0, 16.0, 12.0)
            )
    };

    private final Supplier<ItemConvertible> seedSupplier;

    public WeedCropBlock(Settings settings, Supplier<ItemConvertible> seedSupplier) {
        super(settings);
        this.seedSupplier = seedSupplier;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return seedSupplier.get();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[state.get(getAgeProperty())];
    }
}