package com.binarytenshi.fundamentals.core.helper;

import java.lang.reflect.Field;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map.Entry;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

import com.binarytenshi.fundamentals.Fundamentals;
import com.binarytenshi.fundamentals.core.Element;
import com.binarytenshi.fundamentals.core.Formula;
import com.binarytenshi.fundamentals.item.FundamentalsItem;
import com.binarytenshi.fundamentals.lib.Reference;

/**
 * Handles all chemical {@link Formula} for non {@link FundamentalsItem}.
 * 
 * @author BinaryTENSHi
 */
public class FormulaHelper {

    private static HashMap<String, Formula> formulaMap = new HashMap<String, Formula>();

    public static void generateFormulas() {
        for (Object recipe : CraftingManager.getInstance().getRecipeList()) {
            int i = 0;
            Formula formula = new Formula();
            String resultName = null;

            if (Reference.DEBUG_MODE) {
                Fundamentals.logger.info(recipe.toString() + ":");

                for (Field f : recipe.getClass().getDeclaredFields()) {
                    try {
                        f.setAccessible(true);
                        Fundamentals.logger.info("FIELD: " + f.getName() + ", VALUE: " + f.get(recipe).toString());

                        if (f.get(recipe) instanceof Object[]) {
                            for (Object o : (Object[]) f.get(recipe)) {
                                Fundamentals.logger.info(" > INGR: " + o.toString());
                            }
                        }

                    } catch (Exception e) {
                    }
                }

                Fundamentals.logger.info("---------------------------------");
            }

            do {
                try {
                    Field field = recipe.getClass().getDeclaredFields()[i++];
                    field.setAccessible(true);

                    Object fieldValue = field.get(recipe);

                    if (fieldValue instanceof Object[]) {
                        Object[] ingredients = (Object[]) fieldValue;

                        for (Object ingredient : ingredients) {
                            String name = ((ItemStack) ingredient).getItem().getUnlocalizedNameInefficiently(((ItemStack) ingredient));

                            Formula ingredientFormula = FormulaHelper.getFormula(name);
                            if (ingredientFormula != null) {
                                formula.combine(ingredientFormula, 1);
                            }
                        }
                    }

                    if (fieldValue instanceof ItemStack) {
                        ItemStack result = (ItemStack) fieldValue;
                        resultName = result.getItem().getUnlocalizedNameInefficiently(result);
                    }

                } catch (ArrayIndexOutOfBoundsException ex) {
                    if (!formula.getElements().isEmpty() && resultName != null) {
                        FormulaHelper.registerFormula(resultName, formula);
                    }

                    break;
                } catch (Exception ex) {
                }
            } while (true);
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
            Fundamentals.logger.warning("Attempted to register a formula to same unlocalized name twice: " + name + ";" + formula.getFormula());
            return;
        }

        Fundamentals.logger.info("Registering: " + name + ";" + formula.getFormula());

        formulaMap.put(name, formula);
    }

    public static void registerIC2Items() {
        registerFormula(Item.ingotIron.getUnlocalizedName(), new Formula(new SimpleEntry<Element, Integer>(Element.FE, 9)));

        registerFormula(ic2.api.item.Items.getItem("smallIronDust").getUnlocalizedName(), new Formula(Element.FE));
        registerFormula(ic2.api.item.Items.getItem("plateiron").getUnlocalizedName(), new Formula(new SimpleEntry<Element, Integer>(Element.FE, 9)));
    }
}
