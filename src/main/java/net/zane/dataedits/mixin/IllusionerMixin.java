package net.zane.dataedits.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.structure.WoodlandMansionGenerator;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WoodlandMansionGenerator.Piece.class)
public class IllusionerMixin {
    @Inject(method = "handleMetadata", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/MobEntity;setPersistent()V"), cancellable = true)
    private void trySetIllusioner(String metadata, BlockPos pos, ServerWorldAccess world, Random random, BlockBox boundingBox, CallbackInfo ci) {

        if (metadata.equals("Mage") && random.nextFloat() < 0.4f) {
            MobEntity illusioner = EntityType.ILLUSIONER.create(world.toServerWorld());
            illusioner.setPersistent();
            illusioner.refreshPositionAndAngles(pos, 0.0f, 0.0f);
            illusioner.initialize(world, world.getLocalDifficulty(illusioner.getBlockPos()), SpawnReason.STRUCTURE, null, null);
            world.spawnEntityAndPassengers(illusioner);

            if (random.nextFloat() < 0.8f) {
                ci.cancel();
            }
        }
    }
}
