package me.barbod.worldgen.minecraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IntProvider {
    private static final Logger LOGGER = LogManager.getLogger(IntProvider.class);

    private int min;
    private int max;

    public IntProvider(int min, int max) {
        boolean v = validate(min, max);
        this.min = v ? min : 0;
        this.max = v ? max : 0;
    }

    public int min() {
        return min;
    }

    public void setMin(int min) {
        if (validate(min, this.max))
            this.min = min;
    }

    public int max() {
        return max;
    }

    public void setMax(int max) {
        if (validate(this.min, max))
            this.max = max;
    }

    private boolean validate(int min, int max) {
        if (min > max) {
            LOGGER.error("minimum value ({}) cannot be bigger than maximum value ({})", min, max);
            return false;
        }

        return true;
    }
}