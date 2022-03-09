package corruptpumpkin.first.mod.Functionalities;

import corruptpumpkin.first.mod.FirstMod;
import corruptpumpkin.first.mod.Items.Projectiles.EnergyBoltEntity;
import corruptpumpkin.first.mod.Items.Projectiles.EnergyBoltItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EggItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class EnergyBallCannonItem extends Item {

    public EnergyBallCannonItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        ItemStack itemStack = new ItemStack(FirstMod.ENERGY_BOLT_ITEM);
        if (playerEntity.getInventory().contains(itemStack)) {
            if (playerEntity.getItemUseTime() < 60) {
                if (!world.isClient()) {
                    EnergyBoltEntity snowball = new EnergyBoltEntity(world, playerEntity);
                    snowball.setPos(playerEntity.getX(), playerEntity.getY() + 1.62, playerEntity.getZ());
                    snowball.setVelocity(playerEntity, playerEntity.getPitch(), playerEntity.getHeadYaw(), 0.0f, 3.0f, 0.0f);

                    world.spawnEntity(snowball);
                }
            } else {
                playerEntity.stopUsingItem();
            }
            if (!playerEntity.getAbilities().creativeMode) {
                itemStack.decrement(1);
            }
        }




        return super.use(world, playerEntity, hand);
    }
}

