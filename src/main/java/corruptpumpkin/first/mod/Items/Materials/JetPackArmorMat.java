package corruptpumpkin.first.mod.Items.Materials;

import corruptpumpkin.first.mod.Items.RegisterItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class JetPackArmorMat implements ArmorMaterial {
    private static final int[] BASE_DURABILITY = new int[] {1, 500, 2, 1};
    private static final int[] PROTECTION_VALUES = new int[] {1, 2, 3, 1};

    public JetPackArmorMat(Item.Settings group) {
    }

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()];
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION_VALUES[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_ELYTRA;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RegisterItems.CUSTOM_MATERIAL);
    }

    @Override
    public String getName() {
        // Must be all lowercase
        return "jetpackarmormat";
    }

    @Override
    public float getToughness() {
        return 1.0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.0F;
    }
}