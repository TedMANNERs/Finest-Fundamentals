package com.binarytenshi.fundamentals.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import com.binarytenshi.fundamentals.lib.Models;

/**
 * Chemical table model
 * 
 * @author BinaryTENSHi
 */
public class ModelChemicalTable extends ModelBase {

    private final IModelCustom modelChemicalTable;

    public ModelChemicalTable() {
        modelChemicalTable = AdvancedModelLoader.loadModel(Models.CHEMICALTABLE);
    }

    public void render() {
        modelChemicalTable.renderAll();
    }

    public void renderPart(String partName) {
        modelChemicalTable.renderPart(partName);
    }
}
