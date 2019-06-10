package com.traffic;

import java.util.List;
import java.util.Random;

public class RandomDriver extends DriverWithPersonality {
    private Random rng;

    public RandomDriver() {
        rng = new Random();
    }

    public Field chooseField(List<Field> fields) {
        return fields.get(rng.nextInt(fields.size()));
    }
}
