package corruptpumpkin.first.mod.Items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract class TickingArmorItem extends ArmorItem {

    public TickingArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    public abstract ItemStack onArmorTick(ItemStack itemstack, World world, PlayerEntity entity);
}
