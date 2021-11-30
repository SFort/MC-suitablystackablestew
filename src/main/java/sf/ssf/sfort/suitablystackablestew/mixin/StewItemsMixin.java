package sf.ssf.sfort.suitablystackablestew.mixin;

import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(value = Items.class, priority = 1221)
public class StewItemsMixin {
	//mushroom
	@ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 0),
			slice = @Slice(
					from = @At(value = "NEW", target = "Lnet/minecraft/item/StewItem;", ordinal = 0),
					to = @At(value = "NEW", target = "Lnet/minecraft/item/StewItem;", ordinal = 1)
			)
	)
	private static int new_size_stew0(int i) {
		return 16;
	}
	//rabbit
	@ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 0),
			slice = @Slice(
					from = @At(value = "NEW", target = "Lnet/minecraft/item/StewItem;", ordinal = 1),
					to = @At(value = "NEW", target = "Lnet/minecraft/item/StewItem;", ordinal = 2)
			)
	)
	private static int new_size_stew1(int i) {
		return 16;
	}
	//beetroot
	@ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 0),
			slice = @Slice(
					from = @At(value = "NEW", target = "Lnet/minecraft/item/StewItem;", ordinal = 2),
					to = @At("TAIL")
			)
	)
	private static int new_size_stew2(int i) {
		return 16;
	}
	@ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item$Settings;maxCount(I)Lnet/minecraft/item/Item$Settings;", ordinal = 0),
			slice = @Slice(
					from = @At(value = "NEW", target = "Lnet/minecraft/item/SuspiciousStewItem;", ordinal = 0),
					to = @At("TAIL")
			)
	)
	private static int new_size_stew3(int i) {
		return 16;
	}
}
