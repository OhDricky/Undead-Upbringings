package name.undeadupbringings.entity.mob;

import name.undeadupbringings.SoundRegistry;
import name.undeadupbringings.entity.navigation.BoulderingNavigation;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.pathing.EntityNavigation;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Heightmap;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;

public class BoulderingEntity extends ZombieEntity {
    public BoulderingEntity(EntityType<? extends BoulderingEntity> entityType, World world) {
        super(entityType, world);
    }

    public static boolean canSpawn(EntityType<BoulderingEntity> type, ServerWorldAccess world, SpawnReason spawnReason, BlockPos pos, Random random) {
        if (pos.getY() >= world.getTopPosition(Heightmap.Type.WORLD_SURFACE, pos).getY() || pos.getY() >= 0) {
            return false;
        } else {
            return canSpawnInDark(type, world, spawnReason, pos, random);
        }
    }


    public static DefaultAttributeContainer.Builder createZombieAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.FOLLOW_RANGE, 35.0F)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.23F)
                .add(EntityAttributes.ATTACK_DAMAGE, 5.0F)
                .add(EntityAttributes.ARMOR, 3.0F)
                .add(EntityAttributes.MAX_HEALTH, 26.0F)
                .add(EntityAttributes.ATTACK_KNOCKBACK, 1.75f)
                .add(EntityAttributes.SPAWN_REINFORCEMENTS);
    }

    protected EntityNavigation createNavigation(World world) {
        return new BoulderingNavigation(this, world);
    }

    public void tick() {
        super.tick();
        if (!this.getWorld().isClient) {
            if (this.horizontalCollision) {
                Vec3d vec3d = new Vec3d(0, 0.12, 0);
                this.setVelocity(vec3d);
            }
        }

    }

    protected boolean burnsInDaylight() {
        return false;
    }

    protected SoundEvent getAmbientSound() {
        return SoundRegistry.BOULDERING_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.BOULDERING_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundRegistry.BOULDERING_DEATH;
    }

    protected SoundEvent getStepSound() {
        return SoundEvents.ENTITY_HUSK_STEP;
    }

    protected boolean canConvertInWater() {
        return true;
    }

    protected void convertInWater() {
        this.convertTo(EntityType.ZOMBIE);
        if (!this.isSilent()) {
            this.getWorld().syncWorldEvent(null, 1041, this.getBlockPos(), 0);
        }

    }

    protected ItemStack getSkull() {
        return ItemStack.EMPTY;
    }
}
