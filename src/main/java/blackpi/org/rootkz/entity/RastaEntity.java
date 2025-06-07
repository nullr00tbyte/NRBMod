package blackpi.org.rootkz.entity;

import blackpi.org.rootkz.item.ModItems;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.DefaultAttributeRegistry;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class RastaEntity extends WanderingTraderEntity {
    public RastaEntity(EntityType<? extends WanderingTraderEntity> type, World world) {
        super(type, world);
    }

    @Override
    protected void afterUsing(TradeOffer offer) {

    }

    @Override
    protected void fillRecipes() {
        // Trade 1: 5 carbones por 1 esmeralda (versión corregida)
        this.getOffers().add(new TradeOffer(
                new TradedItem(Items.EMERALD, 25),
                new ItemStack(ModItems.WEED_SEED, 1),
                16, 2, 0.05f
        ));
        this.getOffers().add(new TradeOffer(
                        new TradedItem(Items.EMERALD, 20),
                        new ItemStack(ModItems.DUB_SONG_DISC, 1),
                        16, 2, 0.05f
                )
        );
        this.getOffers().add(new TradeOffer(
                        new TradedItem(Items.GOLD_INGOT, 5),
                        new ItemStack(ModItems.JOINT, 10),
                        16, 2, 0.05f
                )
        );
        this.getOffers().add(new TradeOffer(
                        new TradedItem(Items.EMERALD, 1),
                        new ItemStack(Items.PAPER, 10),
                        16, 2, 0.05f
                )
        );
    }


    public static DefaultAttributeContainer.Builder createVillagerAttributes() {
        return MobEntity.createMobAttributes().add(EntityAttributes.MOVEMENT_SPEED, (double)0.5F);
    }

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }
}