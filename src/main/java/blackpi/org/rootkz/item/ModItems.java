package blackpi.org.rootkz.item;

import blackpi.org.rootkz.Rootkz;
import blackpi.org.rootkz.block.ModBlocks;
import blackpi.org.rootkz.sound.ModSounds;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import java.util.List;
import java.util.function.Function;
import net.minecraft.item.consume.UseAction;


public class ModItems {



    public static final FoodComponent CANNABIS_FOOD_COMPONENT = new FoodComponent.Builder()
            .alwaysEdible()
            .build();


    public static final ConsumableComponent CANNABIS_CONSUMABLE_COMPONENT = ConsumableComponents.food()


            .consumeEffect(new ApplyEffectsConsumeEffect(
                    List.of( // Lista de StatusEffectInstance
                            new StatusEffectInstance(StatusEffects.SLOWNESS, 30 * 20, 1),    // 30 segundos de lentitud (Nivel II)
                            new StatusEffectInstance(StatusEffects.HUNGER, 45 * 20, 0),      // 45 segundos de hambre ("munchies")
                            new StatusEffectInstance(StatusEffects.GLOWING, 60 * 20, 0),     // 60 segundos de brillo (euforia)
                            new StatusEffectInstance(StatusEffects.LEVITATION, 15 * 20, 0),   // 3 segundos de levitación
                            new StatusEffectInstance(StatusEffects.JUMP_BOOST, 5 * 20, 3),   // 5 segundos de salto exagerado
                            new StatusEffectInstance(StatusEffects.SPEED, 10 * 20, 1),      // 10 segundos de velocidad
                            new StatusEffectInstance(Rootkz.WEED, 10*20,1)
                    ),

                    1.0f
            ))
            .consumeEffect(new ApplyEffectsConsumeEffect(
                    List.of(
                            new StatusEffectInstance(StatusEffects.NAUSEA, 20 * 20, 0),
                            new StatusEffectInstance(StatusEffects.BLINDNESS, 5 * 20, 0),
                            new StatusEffectInstance(StatusEffects.WEAKNESS, 40 * 20, 0),
                            new StatusEffectInstance(StatusEffects.DARKNESS, 15 * 20, 0)

                    ), 0.1f // Probabilidad del 10% de un maltrip
            ))
            .sound(ModSounds.JOINT_SMOKE)
            .consumeParticles(false)
            .useAction(UseAction.TOOT_HORN)
            .finishSound(ModSounds.COF)
            .build();

    public static final Item WEED_SEED = register(
            "weed_seed",
            settings -> new BlockItem(ModBlocks.WEED_CROP, settings),
            new Item.Settings().useItemPrefixedTranslationKey() // Clave para 1.21.4+
    );

    public static  final Item BUD = register(
            "bud",
            Item::new,
            new Item.Settings()
    );

    public static  final Item JOINT = register(
            "joint",
            Item::new,
            new Item.Settings().food(CANNABIS_FOOD_COMPONENT, CANNABIS_CONSUMABLE_COMPONENT)
    );


    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Rootkz.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static final Item DUB_SONG_DISC = register("dub_song_disc", Item::new, new Item.Settings().jukeboxPlayable(ModSounds.DUB_SONG_KEY).maxCount(1) );

    public static void registerModItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(WEED_SEED);
            entries.add(BUD);
            entries.add(JOINT);
            entries.add(DUB_SONG_DISC);
        });

    }
}
