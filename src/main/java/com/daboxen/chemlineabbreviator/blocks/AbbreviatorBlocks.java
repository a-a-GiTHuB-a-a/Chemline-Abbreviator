package com.daboxen.chemlineabbreviator.blocks;

import com.daboxen.chemlineabbreviator.AbbreviatorMod;
import com.gregtechceu.gtceu.common.data.models.GTModels;
import com.gregtechceu.gtceu.data.lang.LangHandler;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.tterrag.registrate.providers.RegistrateLangProvider;
import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.daboxen.chemlineabbreviator.AbbreviatorMod.REGISTRATE;

public class AbbreviatorBlocks {
    public static Map<String, String> blockLangReplacements = new HashMap<>();

    public static final BlockEntry<Block> ODITRIVA_CASING = createNamedCasingBlock("Omnidirectional Trivalent Router Casing", "oditriva_casing", AbbreviatorMod.id("block/casing/oditriva"));

    public static void init() {

    }

    public static void genLang(RegistrateLangProvider provider) {
        for (Map.Entry<String, String> entry : blockLangReplacements.entrySet()) {
            LangHandler.replace(provider, entry.getKey(), entry.getValue());
        }
    }

    public static BlockEntry<Block> createNamedCasingBlock(String name, String id, ResourceLocation texture) {
        String langID = "block.chemlineabbreviator.%s".formatted(id);
        blockLangReplacements.put(langID, name);
        return createCasingBlock(id, texture);
    }

    /**
     * code taken from GTCEu
     */
    public static BlockEntry<Block> createCasingBlock(String name, ResourceLocation texture) {
        return createCasingBlock(name, Block::new, texture, () -> Blocks.IRON_BLOCK,
                () -> RenderType::solid);
    }

    /**
     * code taken from GTCEu
     */
    public static BlockEntry<Block> createCasingBlock(String name,
                                                      NonNullFunction<BlockBehaviour.Properties, Block> blockSupplier,
                                                      ResourceLocation texture,
                                                      NonNullSupplier<? extends Block> properties,
                                                      Supplier<Supplier<RenderType>> type) {
        return REGISTRATE.block(name, blockSupplier)
                .initialProperties(properties)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
                .addLayer(type)
                .exBlockstate(GTModels.cubeAllModel(texture))
                .tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH)
                .item(BlockItem::new)
                .build()
                .register();
    }
}