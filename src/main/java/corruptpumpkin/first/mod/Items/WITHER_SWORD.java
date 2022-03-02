package CorruptPumpkin.First.Mod.Items;
import CorruptPumpkin.First.Mod.Items.Materials.WITHERSWORDMATERIAL;
import CorruptPumpkin.First.Mod.modinit.fmEnchants;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class WITHER_SWORD extends SwordItem {
    public WITHER_SWORD(Settings settings) {
        super(WITHERSWORDMATERIAL.INSTANCE, 8, -2.4f, new Item.Settings().group(ItemGroup.COMBAT));
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        // formatted red text
        tooltip.add( new TranslatableText("item.miscaddons.WitherSwordToolTip").formatted(Formatting.RED, Formatting.ITALIC) );
    }
    public boolean postHit(ItemStack itemStack, LivingEntity enemy, LivingEntity user) {
        int witherLevel = EnchantmentHelper.getLevel(fmEnchants.WITHER_ENCHANT, itemStack);
        enemy.addStatusEffect(new StatusEffectInstance(
                StatusEffects.WITHER,
                200 + 100 * (witherLevel - ((witherLevel - 1) / 2)),
                witherLevel, // 0, 1, 2, 3
                true,
                true,
                true));



        return true;
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 60, 2));
        playerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 60, 2));
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }



}
