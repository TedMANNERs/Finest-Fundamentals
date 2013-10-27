package com.binarytenshi.fundamentals.core.handler;

import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import codechicken.nei.forge.IContainerTooltipHandler;

import com.binarytenshi.fundamentals.core.Formula;
import com.binarytenshi.fundamentals.core.helper.FormulaHelper;

/**
 * Handles displaying tooltips over all items. <br>
 * Is used to display chemical formulas over all items.
 * 
 * @author BinaryTENSHi
 */
public class FormulaTooltipHandler implements IContainerTooltipHandler {

    @Override
    public List<String> handleItemTooltip(GuiContainer gui, ItemStack itemstack, List<String> currenttip) {
        Formula formula = FormulaHelper.getFormula(itemstack.getItem().getUnlocalizedName(itemstack));

        if (formula != null) {
            currenttip.add(formula.getFormula());
        }

        return currenttip;
    }

    @Override
    public List<String> handleTooltipFirst(GuiContainer gui, int mousex, int mousey, List<String> currenttip) {
        return currenttip;
    }
}
