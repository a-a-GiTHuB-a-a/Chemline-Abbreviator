package com.daboxen.chemlineabbreviator.machines;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.ibm.icu.text.MessagePattern;

import static com.daboxen.chemlineabbreviator.AbbreviatorMod.LOGGER;
import static com.daboxen.chemlineabbreviator.AbbreviatorMod.REGISTRATE;
import static com.daboxen.chemlineabbreviator.recipes.ChemlineRecipeTypes.*;
import static com.gregtechceu.gtceu.common.data.GTBlocks.*;

public class MachineHelper {
    public static final MultiblockMachineDefinition ChemicalProcessingHelper = REGISTRATE
            .multiblock("chemical_processing_helper", ChemlineAbbreviatorMachine::new)
            .langValue("Chemical Processing Helper")
            .rotationState(RotationState.ALL)
            .recipeType(CHEMLINE_ABBREVIATOR_RECIPES)
            .appearanceBlock(COMPUTER_CASING)
            .pattern(definition -> FactoryBlockPattern.start(/*FRONT, UP, RIGHT*/)
                    .aisle("OOOOO", "OCCCO", "OCECO", "OCCCO", "OOVOO")
                    .aisle(" HHH ", " CHC ", " CWC ", " CHC ", " HVH ")
                    .aisle(" HHH ", " CHC ", " CWC ", " CHC ", " HVH ")
                    .aisle(" HHH ", " CHC ", " CWC ", " CHC ", " HVH ")
                    .aisle(" HHH ", " CHC ", " CWC ", " CHC ", " HVH ")
                    .aisle(" HHH ", " CHC ", " CWC ", " CHC ", " HVH ")
                    .aisle("IIIII", "IMMMI", "IMAMI", "IMMMI", "IIVII")
                    .where('A', Predicates.controller(Predicates.blocks(definition.get())))
                    .where('E', Predicates.abilities(PartAbility.INPUT_ENERGY)) //add lasers later?
                    .where('H', Predicates.blocks(COMPUTER_CASING.get()))
                    .where('O', Predicates.blocks(COMPUTER_CASING.get())
                            .or(Predicates.abilities(PartAbility.EXPORT_ITEMS))
                            .or(Predicates.abilities(PartAbility.EXPORT_FLUIDS)))
                    .where('I', Predicates.blocks(COMPUTER_CASING.get())
                            .or(Predicates.abilities(PartAbility.IMPORT_ITEMS))
                            .or(Predicates.abilities(PartAbility.IMPORT_FLUIDS)))
                    .where(' ', Predicates.any())
                    .where('C', Predicates.blocks(HIGH_POWER_CASING.get()))
                    .where('M', Predicates.blocks(HIGH_POWER_CASING.get())
                            .or(Predicates.abilities(PartAbility.MAINTENANCE).setExactLimit(1)))
                    .where('V', Predicates.blocks(COMPUTER_HEAT_VENT.get()))
                    .where('W', Predicates.blocks(SUPERCONDUCTING_COIL.get()))
                    .build())
            .workableCasingModel(GTCEu.id("block/casings/hpca/high_power_casing"),
                    GTCEu.id("block/multiblock/data_bank/overlay_front"))
            .register();

    public static void init() {
        LOGGER.info("Adding custom multis…");
    }
}
