package corruptpumpkin.first.mod.Items;

import corruptpumpkin.first.mod.Items.Projectiles.BetterSnowBallEntity;
import corruptpumpkin.first.mod.Packets.JetPackFlyingPacket;
import corruptpumpkin.first.mod.mixin.entities.LivingEntityAccessor;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class JetPack extends corruptpumpkin.first.mod.Items.TickingArmorItem {


    public JetPack(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public ItemStack onArmorTick(ItemStack itemstack, World world, PlayerEntity entity) {
        NbtCompound tag = itemstack.getOrCreateNbt();
        boolean isFlying = tag.getBoolean("isFlying");
        if (world.isClient) {
            if (!entity.isOnGround() && ((LivingEntityAccessor) entity).isJumping() && !entity.getAbilities().flying && !entity.hasVehicle() && !entity.isClimbing() && !entity.isSwimming()) {
                if (!isFlying) {
                    PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
                    passedData.writeByte(1);
                    ClientPlayNetworking.send(JetPackFlyingPacket.PACKET_ID, passedData);
                    tag.putBoolean("isFlying", true);
                }
            } else if (isFlying) {
                PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
                passedData.writeByte(0);
                ClientPlayNetworking.send(JetPackFlyingPacket.PACKET_ID, passedData);
                tag.putBoolean("isFlying", false);
            }
            if(entity.isOnGround()) {
                tag.putInt("flyCounter", 200);
            }

        }
        int flyCounter = tag.getInt("flyCounter");
        isFlying = tag.getBoolean("isFlying");
        if (isFlying) {
            if (flyCounter > 0) {
                Vec3d velocity = entity.getVelocity();
                double additiveSpeed = velocity.getY() > 0 ? velocity.getY() > 0.1D ? 0.06D : 0.080D : 0.13D;
                double newYSpeed = velocity.getY() + additiveSpeed;
                entity.setVelocity(
                        velocity.getX(),
                        newYSpeed,
                        velocity.getZ()
                );

                if (newYSpeed > -0.3) {
                    entity.onLanding();
                }
                tag.putInt("flyCounter", flyCounter - 1);
                if (!world.isClient() && world.random.nextFloat() < 0.0025f) {
                    itemstack.damage(1, entity, (playerEntity) -> {
                    });
                }
            } else {
                tag.putBoolean("isFlying", false);
            }
        }
        return ItemStack.EMPTY;
    }

    public static ItemStack getJetpack(Entity entity) {
        for (ItemStack armor : entity.getArmorItems()) {
            if (armor.getItem() instanceof JetPack) {
                return armor;
            }
        }

        return ItemStack.EMPTY;
    }


    @Override
    public float getToughness() {
        return 0.5f;
    }

    public int getDefense() {
        return 3;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }
}
