package me.barbod.worldgen;

import me.barbod.worldgen.element.PluginModElementTypeLoader;
import net.mcreator.plugin.JavaPlugin;
import net.mcreator.plugin.Plugin;
import net.mcreator.plugin.events.PreGeneratorsLoadingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Launcher extends JavaPlugin {
    public static final Logger LOGGER = LogManager.getLogger("Better WorldGen");

    public Launcher(Plugin plugin) {
        super(plugin);

        addListener(PreGeneratorsLoadingEvent.class, e -> PluginModElementTypeLoader.load());

        LOGGER.info("Better WorldGen plugin was loaded");
    }
}
