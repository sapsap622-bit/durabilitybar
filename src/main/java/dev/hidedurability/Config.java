package dev.hidedurability;

import net.neoforged.neoforge.common.ModConfigSpec;

public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue HIDE_BAR = BUILDER
            .comment("Si es true, no se dibuja la barra de durabilidad sobre los ítems.")
            .translation("hidedurabilitybar.configuration.hideDurabilityBar")
            .define("hideDurabilityBar", true);

    public static final ModConfigSpec SPEC = BUILDER.build();

    /** Seguro de llamar en cualquier momento: si la config aún no cargó, no oculta nada. */
    public static boolean shouldHideBar() {
        return SPEC.isLoaded() && HIDE_BAR.get();
    }
}
