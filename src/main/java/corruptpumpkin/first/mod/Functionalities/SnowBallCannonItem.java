package corruptpumpkin.first.mod.Functionalities;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class SnowBallCannonItem extends Item {

    public SnowBallCannonItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        if (playerEntity.getItemUseTime() < 60) {
            if (!world.isClient()) {
                SnowballEntity snowball = new SnowballEntity(world, playerEntity);
                snowball.setPos(playerEntity.getX(), playerEntity.getY() + 1.62, playerEntity.getZ());
                snowball.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getHeadYaw(), 0.0f, 3.0f, 0.0f);

                world.spawnEntity(snowball);
            }
        } else {
            playerEntity.stopUsingItem();
        }



        return super.use(world, playerEntity, hand);
    }
}

