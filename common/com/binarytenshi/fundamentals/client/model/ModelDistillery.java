package com.binarytenshi.fundamentals.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import com.binarytenshi.fundamentals.lib.Models;

/**
 * Distillery model
 * 
 * @author BinaryTENSHi
 */
public class ModelDistillery extends ModelBase {

    private final IModelCustom modelDistillery;

    public ModelDistillery() {
        modelDistillery = AdvancedModelLoader.loadModel(Models.DISTILLERY);
    }

    public void render() {
        modelDistillery.renderAll();
    }

    public void renderPart(String partName) {
        modelDistillery.renderPart(partName);
    }
}
