package sf.ssf.sfort.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Items.class)
public class StewItem{
	@Redirect(method = "<clinit>",
			at = @At(value = "NEW", target = "Lnet/minecraft/item/MushroomStewItem;"))
	private static MushroomStewItem thisStew(Item.Settings settings) {
		return new MushroomStewItem(settings.maxCount(16));
	}
	@Redirect(method = "<clinit>",
			at = @At(value = "NEW", target = "Lnet/minecraft/item/SuspiciousStewItem;"))
	private static SuspiciousStewItem thisSuspStew(Item.Settings settings) {
		return new SuspiciousStewItem(settings.maxCount(16));
	}
}
