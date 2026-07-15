package com.daboxen.chemlineabbreviator.machines;

import com.gregtechceu.gtceu.api.blockentity.BlockEntityCreationInfo;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;

import java.util.ArrayList;
import java.util.List;

public class ChemlineAbbreviatorMachine extends WorkableElectricMultiblockMachine {
    public ChemlineAbbreviatorMachine(BlockEntityCreationInfo info) {
        super(info);
    }

    public List<String> currentRecipeTypes = new ArrayList<>();

    @Override
    public void createStructurePatterns() {
        super.createStructurePatterns();
    }
}