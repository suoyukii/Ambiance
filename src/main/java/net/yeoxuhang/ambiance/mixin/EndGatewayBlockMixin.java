package net.yeoxuhang.ambiance.mixin;

import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EndGatewayBlock;
import net.yeoxuhang.ambiance.client.particle.option.TrialOption;
import net.yeoxuhang.ambiance.config.AmbianceConfig;
import net.yeoxuhang.ambiance.util.MthHelper;
import net.yeoxuhang.ambiance.util.ParticlesUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Random;

@Mixin(EndGatewayBlock.class)
public class EndGatewayBlockMixin {

    @ModifyArg(method = "animateTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;addParticle(Lnet/minecraft/core/particles/ParticleOptions;DDDDDD)V"))
    public ParticleOptions animateTick(ParticleOptions particleOptions) {
        if (AmbianceConfig.enableEndGetaway){
            int randomColor = MthHelper.createRandomColor(2842463, 4759492);
            return TrialOption.create((int)(Math.random() * 2.0) + 60, 1F, 2.5F, AmbianceConfig.enderEndGetawaySize / 10, randomColor, 0.7F);
        } else return ParticleTypes.PORTAL;
    }
}
