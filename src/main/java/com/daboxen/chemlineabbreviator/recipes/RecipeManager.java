package com.daboxen.chemlineabbreviator.recipes;
import java.util.function.Consumer;
import net.minecraft.data.recipes.FinishedRecipe;
import static com.daboxen.chemlineabbreviator.AbbreviatorMod.LOGGER;

public class RecipeManager {
    public static void addRecipes(Consumer<FinishedRecipe> provider) {
        LOGGER.info("Adding uranium separation recipes…");
        UraniumRecipes.addRecipes(provider);
    }
}