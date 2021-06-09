package sf.ssf.sfort.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MushroomStewItem.class)
public class MushStew extends Item{
	public MushStew(Settings settings) {
		super(settings);
	}
	@Inject(method="finishUsing", at=@At("HEAD"), cancellable = true)
	private void use(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> info) {
		ItemStack itemStack = super.finishUsing(stack, world, user);
		info.setReturnValue(new ItemStack(Items.BOWL));
		if (!stack.isEmpty() && user instanceof PlayerEntity) {
			if (!((PlayerEntity) user).getAbilities().creativeMode) {
				((PlayerEntity) user).getInventory().insertStack(new ItemStack(Items.BOWL));
			}
			info.setReturnValue(itemStack);
		}
		info.cancel();
	}
}
