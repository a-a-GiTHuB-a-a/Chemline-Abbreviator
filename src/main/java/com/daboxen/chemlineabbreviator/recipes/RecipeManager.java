package com.daboxen.chemlineabbreviator.recipes;
import java.util.function.Consumer;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import net.minecraft.data.recipes.FinishedRecipe;
import static com.daboxen.chemlineabbreviator.AbbreviatorMod.LOGGER;
import static com.daboxen.chemlineabbreviator.recipes.ChemlineRecipeTypes.*;
import static com.gregtechceu.gtceu.api.GTValues.*;
import static com.gregtechceu.gtceu.common.data.GTRecipeTypes.*;

public class RecipeManager {
    public static void addRecipes(Consumer<FinishedRecipe> provider) {
        LOGGER.info("Adding custom recipes…");
        addUraniumRecipes(provider);
    }

    public static void addUraniumRecipes(Consumer<FinishedRecipe> provider) {
        LOGGER.info("Adding uranium separation recipes…");
        RESEARCH_STATION_RECIPES.recipeBuilder("uranium_line")
                .inputItems(GTItems.TOOL_DATA_MODULE)
                .inputItems(TagPrefix.dust, GTMaterials.Uraninite)
                .outputItems(GTItems.TOOL_DATA_MODULE.asStack())
                .CWUt(64)
                .EUt(VA[UV]);

        CHEMLINE_CENTRIFUGE_RECIPES.recipeBuilder("uranium_hexafluoride_separation")
                .copy("centrifuge/uranium_hexafluoride_separation")
                .researchWithoutRecipe("uranium_line")
                .save(provider);
    }
}