package corruptpumpkin.first.mod.Items;

import corruptpumpkin.first.mod.FirstMod;
import corruptpumpkin.first.mod.Items.Materials.JetPackArmorMat;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class RegisterItems {

    public static final ArmorMaterial JETPACKARMOR = new JetPackArmorMat(new Item.Settings().group(FirstMod.MISC_ADDON_GROUP));
    public static final Item CUSTOM_MATERIAL = new Item(new Item.Settings().group(FirstMod.MISC_ADDON_GROUP));
    // If you made a new material, this is where you would note it.

    public static final Item JETPACK = new JetPack(JETPACKARMOR, EquipmentSlot.CHEST, new Item.Settings().group(FirstMod.MISC_ADDON_GROUP));


    public static void register() {

        Registry.register(Registry.ITEM, new Identifier("miscaddons", "jetpack"), JETPACK);

    }
}