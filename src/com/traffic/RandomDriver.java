package com.traffic;

import java.util.List;

public class RandomDriver implements Driver {
    private Personality personality;

    public RandomDriver() {

    }

    public RandomDriver(Personality personality) {
        this.personality = personality;
    }

    public Field chooseField(List<Field> fields) {
        return fields.get(0);
    }
    public void passedField() {

    }
    public void passedIntersection() {

    }
    public void trafficJammed() {

    }
    public float getAngerLevel() {
        return 0.0f;
    }
}
