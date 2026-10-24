package dev.hidedurability.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.hidedurability.Config;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(GuiGraphics.class)
public abstract class GuiGraphicsMixin {

    /**
     * En 1.21.1 la barra se dibuja dentro de renderItemDecorations, solo si
     * stack.isBarVisible() es true. Hacemos que devuelva false cuando está
     * activada la opción; el resto de decoraciones (cantidad, cooldown, etc.) no se tocan.
     */
    @WrapOperation(
            method = "renderItemDecorations(Lnet/minecraft/client/gui/Font;Lnet/minecraft/world/item/ItemStack;IILjava/lang/String;)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isBarVisible()Z")
    )
    private boolean hidedurabilitybar$hideBar(ItemStack stack, Operation<Boolean> original) {
        if (Config.shouldHideBar()) {
            return false;
        }
        return original.call(stack);
    }
}
