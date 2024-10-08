package net.zane.dataedits.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MagmaCubeEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MagmaCubeEntity.class)
public class MagmaCubeMixin extends SlimeEntity {
    public MagmaCubeMixin(EntityType<? extends SlimeEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void damage(LivingEntity target) {
        if (this.isAlive() && !target.isBlocking()
                && this.squaredDistanceTo(target) < 0.36 * this.getSize() * this.getSize()) {
            target.setOnFireFor(this.getSize());
        }
        super.damage(target);
    }
}
