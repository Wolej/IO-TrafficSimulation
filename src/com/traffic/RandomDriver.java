package com.traffic;

import java.util.List;

public class RandomDriver extends DriverWithPersonality implements Driver {

    public RandomDriver() {

    }

    public Field chooseField(List<Field> fields) {
        return fields.get(0);
    }

    public float getAngerLevel() {
        return 0.0f;
    }
}
