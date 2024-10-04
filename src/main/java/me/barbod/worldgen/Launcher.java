package me.barbod.worldgen;

import net.mcreator.plugin.JavaPlugin;
import net.mcreator.plugin.Plugin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Launcher extends JavaPlugin {
    public static final Logger LOGGER = LogManager.getLogger("Better WorldGen");

    public Launcher(Plugin plugin) {
        super(plugin);

        LOGGER.info("Better WorldGen plugin was loaded");
    }
}
