package corruptpumpkin.first.mod.mixin.entities;

import corruptpumpkin.first.mod.Items.TickingArmorItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(PlayerInventory.class)
public class InventoryMixin {

    @Shadow
    @Final
    public DefaultedList<ItemStack> armor;

    @Shadow
    @Final
    public PlayerEntity player;

    @Inject(method = "updateItems",
            at = @At(value = "TAIL"))
    private void miscaddons_armorTick(CallbackInfo ci) {
        armor.forEach(itemStack -> {
            if(itemStack.getItem() instanceof TickingArmorItem tickingArmorItem) {
                tickingArmorItem.onArmorTick(itemStack, player.world, player);
            }
        });
    }
}
