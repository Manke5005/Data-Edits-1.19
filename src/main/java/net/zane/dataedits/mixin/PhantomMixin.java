package net.zane.dataedits.mixin;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.FlyingEntity;
import net.minecraft.entity.mob.PhantomEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

    @Mixin(PhantomEntity.class)
    public class PhantomMixin extends FlyingEntity {
        protected PhantomMixin(EntityType<? extends FlyingEntity> entityType, net.minecraft.world.World world) {
            super(entityType, world);
        }

        @Nullable
        @Override
        public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityTag) {
            EntityAttributeInstance instance = this.getAttributes().getCustomInstance(EntityAttributes.GENERIC_MAX_HEALTH);
            if (instance != null) {
                instance.setBaseValue(24.0D);
                this.setHealth(this.getMaxHealth());
            }
            return super.initialize(world, difficulty, spawnReason, entityData, entityTag);
        }
    }
