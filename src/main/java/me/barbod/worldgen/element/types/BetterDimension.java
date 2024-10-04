package me.barbod.worldgen.element.types;

import me.barbod.worldgen.minecraft.IntProvider;
import net.mcreator.element.GeneratableElement;
import net.mcreator.workspace.elements.ModElement;

import java.awt.*;

@SuppressWarnings("unused")
public class BetterDimension extends GeneratableElement {

    public boolean ultraWarm;
    public boolean isNatural;
    public boolean isPiglinSafe;
    public boolean doesRespawnAnchorWork;
    public boolean doesBedWork;
    public boolean hasRaid;
    public boolean hasSkylight;
    public boolean hasCeiling;
    public boolean hasFog;
    public int coordinateScale; // Not implemented
    public int ambientLight; // Not implemented

    public Color airColor;

    public boolean isTimeFixed;
    public int fixedTime;

    public String effect; // Not implemented
    public String infiniburn; // Not implemented

    public int logicalHeight;
    public int minY;
    public int height;

    public boolean hasCloud;
    public boolean cloudHeight;

    public String skyType;

    public IntProvider monsterSpawnLightLevel;

    public BetterDimension(ModElement element) {
        super(element);
    }
}
