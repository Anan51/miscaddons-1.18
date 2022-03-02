package corruptpumpkin.first.mod.Packets;
import corruptpumpkin.first.mod.Items.JetPack;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;

public class JetPackFlyingPacket {
    public static Identifier PACKET_ID = new Identifier("miscaddons", "jetpack_flying_packet");

    public static void registerPacket() {
        ServerPlayNetworking.registerGlobalReceiver(PACKET_ID,
                (minecraftServer, serverPlayer, packetListener, buf, packetSender) -> {
                    minecraftServer.execute(() -> {
                        if(serverPlayer == null) {
                            return;
                        }

                        ItemStack itemStack = JetPack.getJetpack(serverPlayer);
                        if(!itemStack.isEmpty()) {
                            boolean isFlying = buf.readByte() != 0;
                            NbtCompound tag = itemStack.getOrCreateNbt();
                            tag.putBoolean("isFlying", isFlying);
                        }
                    });
                });
    }
}
