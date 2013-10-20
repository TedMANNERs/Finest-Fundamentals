package com.binarytenshi.fundamentals.core.helper;

import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map.Entry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;

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

        //TODO: get IC2 recipes

        for (Object obj : CraftingManager.getInstance().getRecipeList()) {

            Formula formula = new Formula();

            if (obj instanceof ShapedRecipes) {
                ShapedRecipes recipe = (ShapedRecipes) obj;

                for (ItemStack stack : recipe.recipeItems) {
                    if (stack != null) {
                        String name = stack.getItem().getUnlocalizedName();
                        Fundamentals.logger.info(name);
                        Formula form = FormulaHelper.getFormula(name);

                        if (form != null) {
                            formula.combine(form, recipe.getRecipeOutput().stackSize);
                        }
                    }
                }

                if (formula.getElements().size() != 0) {
                    FormulaHelper.registerFormula(recipe.getRecipeOutput().getUnlocalizedName(), formula);
                }

                Fundamentals.logger.info("-------------------------------");
            } else if (obj instanceof ShapelessRecipes) {
                ShapelessRecipes recipe = (ShapelessRecipes) obj;

                for (Object obj2 : recipe.recipeItems.toArray()) {
                    ItemStack stack = (ItemStack) obj2;

                    if (stack != null) {
                        Fundamentals.logger.info(stack.getItem().getUnlocalizedName());
                    }
                }

                Fundamentals.logger.info("-------------------------------");
            }
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
        if (formulaMap.keySet().contains(name)) {
            Fundamentals.logger.warning("Attempted to register a formula to same unlocalized name twice.");
            Fundamentals.logger.warning("> " + name + ";" + formula.getFormula());
            return;
        }

        Fundamentals.logger.info("Registering: ");
        Fundamentals.logger.info("> " + name + ";" + formula.getFormula());

        formulaMap.put(name, formula);
    }

    public static void registerIC2Items() {
        registerFormula(Item.ingotIron.getUnlocalizedName(), new Formula(new SimpleEntry<Element, Integer>(Element.FE, 9)));

        registerFormula(ic2.api.item.Items.getItem("smallIronDust").getUnlocalizedName(), new Formula(Element.FE));
    }
}
