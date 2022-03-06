package corruptpumpkin.first.mod.Functionalities;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CreeperHiss2 extends Item {

	public CreeperHiss2(Settings settings) {
		super(settings);
	}
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        System.out.println("Hello");
        playerEntity.playSound(SoundEvents.ENTITY_CREEPER_PRIMED, 1.0F, 1.0F);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}