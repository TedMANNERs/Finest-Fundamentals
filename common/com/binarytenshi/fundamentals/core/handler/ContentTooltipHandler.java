package com.binarytenshi.fundamentals.core.handler;

import java.util.List;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.item.ItemStack;
import codechicken.nei.forge.IContainerTooltipHandler;

/**
 * Handles displaying tooltips over all items. <br>
 * Will be used to display chemical formulas over vanilla items.
 * 
 * @author BinaryTENSHi
 *
 */
public class ContentTooltipHandler implements IContainerTooltipHandler {

    @Override
    public List<String> handleTooltipFirst(GuiContainer gui, int mousex, int mousey, List<String> currenttip) {
        return currenttip;
    }

    @Override
    public List<String> handleItemTooltip(GuiContainer gui, ItemStack itemstack, List<String> currenttip) {
        // TODO: Add formula to vanilla items
        return currenttip;
    }
}
