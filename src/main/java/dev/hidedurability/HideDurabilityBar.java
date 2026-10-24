package dev.hidedurability;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = HideDurabilityBar.MODID, dist = Dist.CLIENT)
public class HideDurabilityBar {
    public static final String MODID = "hidedurabilitybar";

    public HideDurabilityBar(ModContainer container) {
        container.registerConfig(ModConfig.Type.CLIENT, Config.SPEC);
        // Pantalla de config automática en Mods > Hide Durability Bar > Config
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
