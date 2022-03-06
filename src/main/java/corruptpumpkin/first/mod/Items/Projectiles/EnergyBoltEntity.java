package corruptpumpkin.first.mod.Items.Projectiles;

import corruptpumpkin.first.mod.FirstMod;
import corruptpumpkin.first.mod.Packets.EntitySpawnPacket;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

import static net.minecraft.entity.EntityGroup.UNDEAD;

public class EnergyBoltEntity extends ThrownItemEntity {
    public EnergyBoltEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }
    public EnergyBoltEntity(World world, LivingEntity owner) {
        super(FirstMod.EnergyBoltEntityType, owner, world); // null will be changed later
    }

    public EnergyBoltEntity(World world, double x, double y, double z) {
        super(FirstMod.EnergyBoltEntityType, x, y, z, world); // null will be changed later
    }

    @Override
    protected Item getDefaultItem() {
        return FirstMod.ENERGY_BOLT_ITEM;
    }

    protected void onEntityHit(EntityHitResult entityHitResult) { // called on entity hit.
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity(); // sets a new Entity instance as the EntityHitResult (victim)
        entity.damage(DamageSource.thrownProjectile(this, this.getOwner()), 1); // deals damage

        if (entity instanceof LivingEntity livingEntity && !(entity instanceof PlayerEntity)) { // checks if entity is an instance of LivingEntity (meaning it is not a boat or minecart)

            livingEntity.addStatusEffect((new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 3))); // applies a status effect
            livingEntity.playSound(SoundEvents.ENTITY_LIGHTNING_BOLT_IMPACT, 2F, 5F); // plays a sound for the entity hit only
        }
    }

    protected void onCollision(HitResult hitResult) { // called on collision with a block
        super.onCollision(hitResult);
        if (!this.world.isClient) { // checks if the world is client
            this.world.sendEntityStatus(this, (byte)3); // particle?
            this.kill(); // kills the projectile
        }

    }
    @Override
    public Packet<?> createSpawnPacket() {
        return EntitySpawnPacket.create(this, FirstMod.PacketID);
    }
}
