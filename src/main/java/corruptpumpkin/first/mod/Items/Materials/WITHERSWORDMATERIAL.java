package CorruptPumpkin.First.Mod.Items.Materials;

import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class WITHERSWORDMATERIAL implements ToolMaterial {
    public static final WITHERSWORDMATERIAL INSTANCE = new WITHERSWORDMATERIAL();
    @Override
    public int getDurability() {
        return 1500;
    }
    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getMiningLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 13;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Items.BLAZE_POWDER);}

}
