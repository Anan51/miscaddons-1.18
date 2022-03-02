package CorruptPumpkin.First.Mod.modinit;

import CorruptPumpkin.First.Mod.FirstModEnchantments.PoisonEnchant;
import CorruptPumpkin.First.Mod.FirstModEnchantments.WitherEnchant;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class fmEnchants {
    public final static Enchantment WITHER_ENCHANT = new WitherEnchant();
    public static final Enchantment POISON_ENCHANT = new PoisonEnchant();

    public static void registerEnchantment() {
        Registry.register(
                Registry.ENCHANTMENT,
                new Identifier("firstmodenchants", "poison"),
                new PoisonEnchant());
        Registry.register(
                Registry.ENCHANTMENT,
                new Identifier("firstmodenchants", "wither"),
                new WitherEnchant());
    }
}
