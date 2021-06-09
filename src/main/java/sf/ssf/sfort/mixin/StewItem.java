package sf.ssf.sfort.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.MushroomStewItem;
import net.minecraft.item.SuspiciousStewItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

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
