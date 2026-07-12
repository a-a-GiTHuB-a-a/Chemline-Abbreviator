package com.daboxen.chemlineabbreviator.recipes;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.recipe.GTRecipeSerializer;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
//import com.gregtechceu.gtceu.common.mui.GTGuiTextures;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeType;

import static com.daboxen.chemlineabbreviator.AbbreviatorMod.LOGGER;
import static com.daboxen.chemlineabbreviator.AbbreviatorMod.id;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.ELECTRIC;

public class ChemlineRecipeTypes {
    public static final GTRecipeType CHEMLINE_ABBREVIATOR_RECIPES = register("chemline_abbreviator", ELECTRIC)
            .setMaxIOSize(9, 9, 9, 9)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.COMPUTATION);

    public static final GTRecipeType CHEMLINE_CENTRIFUGE_RECIPES = register("centrifuge_module", ELECTRIC)
            .setMaxIOSize(2, 6, 1, 6)
            .setEUIO(IO.IN)
            .prepareBuilder(recipeBuilder -> recipeBuilder.EUt(5))
            /*.UI(builder -> builder.setProgressBar(GTGuiTextures.PROGRESS_EXTRACT)
                    .setItemSlotOverlay(IO.IN, 0, GTGuiTextures.EXTRACTOR_OVERLAY)
                    .setItemSlotOverlay(IO.IN, 1, GTGuiTextures.CANISTER_OVERLAY)
                    .setFluidSlotOverlay(IO.IN, 0, GTGuiTextures.CENTRIFUGE_OVERLAY))*/
            .setSound(GTSoundEntries.CENTRIFUGE);

    public static GTRecipeType register(String name, String group, RecipeType<?>... proxyRecipes) {
        var recipeType = new GTRecipeType(id(name), group, proxyRecipes);
        GTRegistries.register(BuiltInRegistries.RECIPE_TYPE, recipeType.registryName, recipeType);
        GTRegistries.register(BuiltInRegistries.RECIPE_SERIALIZER, recipeType.registryName, new GTRecipeSerializer());
        GTRegistries.RECIPE_TYPES.register(recipeType.registryName, recipeType);
        return recipeType;
    }

    public static void init(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        LOGGER.info("Registering recipe types…");
    }
}
