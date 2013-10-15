package com.binarytenshi.fundamentals.core.helper;

import java.util.HashMap;
import java.util.Map.Entry;

import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;

import com.binarytenshi.fundamentals.Fundamentals;
import com.binarytenshi.fundamentals.core.Element;
import com.binarytenshi.fundamentals.core.Formula;
import com.binarytenshi.fundamentals.item.FundamentalsItem;

/**
 * Handles all chemical {@link Formula} for non {@link FundamentalsItem}.
 * 
 * @author BinaryTENSHi
 */
public class FormulaHelper {

    private static HashMap<String, Formula> formulaMap = new HashMap<String, Formula>();

    public static void generateFormulas() {
        for (Object obj : CraftingManager.getInstance().getRecipeList()) {
            IRecipe recipe = (IRecipe) obj;

            //TODO: get recipe ingredients and generate formula
        }
    }

    /**
     * Returns the formula for the given unlocalized name
     * 
     * @param name
     *            unlocalized name of the item or block
     * @return {@link Formula} for given name <br/>
     *         null if not found
     */
    public static Formula getFormula(String name) {
        for (Entry<String, Formula> entry : formulaMap.entrySet()) {
            if (entry.getKey().equals(name)) {
                return entry.getValue();
            }
        }

        return null;
    }

    /**
     * Registers a formula to a given unlocalized name
     * 
     * @param name
     *            unlocalized name
     * @param formula
     *            {@link Formula} to register
     */
    public static void registerFormula(String name, Formula formula) {
        if (!formulaMap.keySet().contains(name)) {
            formulaMap.put(name, formula);
        }

        Fundamentals.logger.warning("Attempt to register a formula to same unlocalized name twice.");
    }

    public static void registerIC2Items() {
        registerFormula(ic2.api.item.Items.getItem("smallIronDust").getUnlocalizedName(), new Formula(Element.FE));
    }
}
