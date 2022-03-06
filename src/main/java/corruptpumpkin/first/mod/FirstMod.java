package corruptpumpkin.first.mod;
import CorruptPumpkin.First.Mod.FirstModEnchantments.PoisonEnchant;
import corruptpumpkin.first.mod.Functionalities.CreeperHiss2;
import corruptpumpkin.first.mod.Functionalities.EnergyBallCannonItem;
import corruptpumpkin.first.mod.Functionalities.SnowBallCannonItem;
import corruptpumpkin.first.mod.Items.Projectiles.EnergyBoltEntity;
import corruptpumpkin.first.mod.Items.Projectiles.EnergyBoltItem;
import corruptpumpkin.first.mod.Items.RegisterItems;
import CorruptPumpkin.First.Mod.FirstModEnchantments.WitherEnchant;
import CorruptPumpkin.First.Mod.Items.WITHER_SWORD;
import corruptpumpkin.first.mod.Packets.JetPackFlyingPacket;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.*;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("miscaddons");
	public static final String ModID = "miscaddons"; // This is just so we can refer to our ModID easier.
	public static final Identifier PacketID = new Identifier(FirstMod.ModID, "spawn_packet");


	public static final EntityType<EnergyBoltEntity> EnergyBoltEntityType = Registry.register(
			Registry.ENTITY_TYPE,
			new Identifier(ModID, "energy_bolt"),
			FabricEntityTypeBuilder.<EnergyBoltEntity>create(SpawnGroup.MISC, EnergyBoltEntity::new)
					.dimensions(EntityDimensions.fixed(0.25F, 0.25F)) // dimensions in Minecraft units of the projectile
					.trackRangeBlocks(4).trackedUpdateRate(10) // necessary for all thrown projectiles (as it prevents it from breaking, lol)
					.build()); // VERY IMPORTANT DONT DELETE FOR THE LOVE OF GOD PSLSSSSSS
	public static final ItemGroup MISC_ADDON_GROUP = new ItemGroup(1, "Misc_Addon_Group") {
		@Override
		public ItemStack createIcon() {
			return ItemStack.EMPTY;
		}
	};
	private static final Enchantment WITHER = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier("firstmodenchants", "wither"),
			new WitherEnchant()
	);
	private static final Enchantment POISON = Registry.register(
			Registry.ENCHANTMENT,
			new Identifier("firstmodenchants", "poison"),
			new PoisonEnchant()
	);
	public static final Item CREEPER_HEART = new CreeperHiss2(new Item.Settings().group(FirstMod.MISC_ADDON_GROUP).maxCount(1).rarity(Rarity.RARE));
	public final Item WITHER_SWORD = new WITHER_SWORD(new Item.Settings().group(FirstMod.MISC_ADDON_GROUP).rarity(Rarity.EPIC));
	public final Item SNOWBALL_CANNON = new SnowBallCannonItem(new Item.Settings().group(FirstMod.MISC_ADDON_GROUP).rarity(Rarity.EPIC).fireproof());
	public final Item ENERGYBALL_CANNON = new EnergyBallCannonItem(new Item.Settings().group(FirstMod.MISC_ADDON_GROUP).rarity(Rarity.EPIC).fireproof());
	public static final Item WITHER_BONE = new Item(new Item.Settings().group(FirstMod.MISC_ADDON_GROUP).rarity(Rarity.RARE));
	public static final Item ENERGY_BOLT_ITEM = new EnergyBoltItem(new Item.Settings().group(FirstMod.MISC_ADDON_GROUP).rarity(Rarity.RARE));
	private static final Identifier WITHER_SKELETON_LOOT_TABLE_ID = EntityType.WITHER_SKELETON.getLootTableId();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		Registry.register(Registry.ITEM, new Identifier("miscaddons", "creeper_heart"), CREEPER_HEART);
		Registry.register(Registry.ITEM, new Identifier("miscaddons", "wither_sword"), WITHER_SWORD);
		Registry.register(Registry.ITEM, new Identifier("miscaddons", "wither_bone"), WITHER_BONE);
		Registry.register(Registry.ITEM, new Identifier("miscaddons", "snowball_cannon"), SNOWBALL_CANNON);
		Registry.register(Registry.ITEM, new Identifier("miscaddons", "energyball_cannon"), ENERGYBALL_CANNON);
		Registry.register(Registry.ITEM, new Identifier("miscaddons", "energy_bolt_item"), ENERGY_BOLT_ITEM);
		JetPackFlyingPacket.registerPacket();
		LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, table, setter) -> {
			if (WITHER_SKELETON_LOOT_TABLE_ID.equals(id)) {

				FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
						.rolls(ConstantLootNumberProvider.create(1))
						.withEntry(ItemEntry.builder(FirstMod.WITHER_BONE).build())
						.withCondition(RandomChanceLootCondition.builder(0.2F).build());
				table.pool(poolBuilder);
			}
		});

		RegisterItems.register();

	}


}
