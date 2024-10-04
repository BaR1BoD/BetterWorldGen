package me.barbod.worldgen.ui.modgui;

import me.barbod.worldgen.element.types.BetterDimension;
import me.barbod.worldgen.minecraft.IntProvider;
import net.mcreator.ui.MCreator;
import net.mcreator.ui.component.JColor;
import net.mcreator.ui.component.JMinMaxSpinner;
import net.mcreator.ui.init.L10N;
import net.mcreator.ui.modgui.ModElementGUI;
import net.mcreator.ui.validation.AggregatedValidationResult;
import net.mcreator.workspace.elements.ModElement;

import javax.annotation.Nonnull;
import javax.swing.*;

public class BetterDimensionGUI extends ModElementGUI<BetterDimension> {

    private final JCheckBox ultraWarm = L10N.checkbox("elementgui.better_dimension.ultrawarm");
    private final JCheckBox isNatural = L10N.checkbox("elementgui.better_dimension.is_natural");
    private final JCheckBox isPiglinSafe = L10N.checkbox("elementgui.better_dimension.is_piglin_safe");
    private final JCheckBox doesRespawnAnchorWork = L10N.checkbox("elementgui.better_dimension.does_respawn_anchor_work");
    private final JCheckBox doesBedWork = L10N.checkbox("elementgui.better_dimension.does_bed_work");
    private final JCheckBox hasRaid = L10N.checkbox("elementgui.better_dimension.has_raid");
    private final JCheckBox hasSkyLight = L10N.checkbox("elementgui.better_dimension.hasSkyLight");
    private final JCheckBox hasCeiling = L10N.checkbox("elementgui.better_dimension.has_Ceiling");
    private final JCheckBox hasFog = L10N.checkbox("elementgui.better_dimension.has_fog");

    private final JColor airColor = new JColor(mcreator, false, false);

    private final JCheckBox isTimeFixed = L10N.checkbox("elementgui.better_dimension.is_time_fixed");
    private final JSpinner fixedTime = new JSpinner(new SpinnerNumberModel(1, 1, 24000, 1));

    private final JSpinner logicalHeight = new JSpinner(new SpinnerNumberModel(384, -1024, 1024, 1));
    private final JSpinner minY = new JSpinner(new SpinnerNumberModel(-64, -1024, 1024, 1));
    private final JSpinner height = new JSpinner(new SpinnerNumberModel(384, 0, 1024, 1));
    private final JMinMaxSpinner monsterSpawnLightLevel = new JMinMaxSpinner(0, 0, 0, 15, 1);

    public BetterDimensionGUI(MCreator mcreator, @Nonnull ModElement modElement, boolean editingMode) {
        super(mcreator, modElement, editingMode);
    }

    @Override
    protected void initGUI() {

    }

    @Override
    protected AggregatedValidationResult validatePage(int page) {
        return new AggregatedValidationResult.PASS();
    }

    @Override
    protected void openInEditingMode(BetterDimension dimension) {
        ultraWarm.setSelected(dimension.ultraWarm);
        isNatural.setSelected(dimension.isNatural);
        isPiglinSafe.setSelected(dimension.isPiglinSafe);
        doesRespawnAnchorWork.setSelected(dimension.doesRespawnAnchorWork);
        doesBedWork.setSelected(dimension.doesBedWork);
        hasRaid.setSelected(dimension.hasCeiling);
        hasSkyLight.setSelected(dimension.hasSkylight);
        hasCeiling.setSelected(dimension.hasCeiling);
        hasFog.setSelected(dimension.hasFog);

        airColor.setColor(dimension.airColor);

        isTimeFixed.setSelected(dimension.isTimeFixed);
        fixedTime.setValue(dimension.fixedTime);

        logicalHeight.setValue(dimension.logicalHeight);
        minY.setValue(dimension.minY);
        height.setValue(dimension.height);

        monsterSpawnLightLevel.setMinValue(dimension.monsterSpawnLightLevel.min());
        monsterSpawnLightLevel.setMaxValue(dimension.monsterSpawnLightLevel.max());
    }

    @Override
    public BetterDimension getElementFromGUI() {
        BetterDimension dimension = new BetterDimension(this.modElement);

        dimension.ultraWarm = ultraWarm.isSelected();
        dimension.isNatural = isNatural.isSelected();
        dimension.isPiglinSafe = isPiglinSafe.isSelected();
        dimension.doesRespawnAnchorWork = doesRespawnAnchorWork.isSelected();
        dimension.doesBedWork = doesBedWork.isSelected();
        dimension.hasRaid = hasRaid.isSelected();
        dimension.hasSkylight = hasSkyLight.isSelected();
        dimension.hasCeiling = hasCeiling.isSelected();
        dimension.hasFog = hasFog.isSelected();

        dimension.airColor = airColor.getColor();

        dimension.isTimeFixed = isTimeFixed.isSelected();
        dimension.fixedTime = (int) fixedTime.getValue();

        dimension.logicalHeight = (int) logicalHeight.getValue();
        dimension.minY = (int) minY.getValue();
        dimension.height = (int) height.getValue();

        dimension.monsterSpawnLightLevel = new IntProvider(monsterSpawnLightLevel.getIntMinValue(), monsterSpawnLightLevel.getIntMaxValue());

        return dimension;
    }
}
