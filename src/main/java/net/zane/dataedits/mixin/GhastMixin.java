package net.zane.dataedits.mixin;


import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.GhastEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GhastEntity.class)
public class GhastMixin extends FlyingEntity {
    protected GhastMixin(EntityType<? extends FlyingEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 10;
    }

    @Nullable
    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityTag) {
        EntityAttributeInstance instance = this.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH);
        if (instance != null) {
            instance.setBaseValue(60.0D);
            this.setHealth(this.getMaxHealth());
        }
        return super.initialize(world, difficulty, spawnReason, entityData, entityTag);
    }
}
