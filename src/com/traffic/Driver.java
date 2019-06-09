package com.traffic;

import java.util.List;

public interface Driver {
    Field chooseField(List<Field> fields);
    void passedField();
    void passedIntersection();
    void trafficJammed();
    float getAngerLevel();
}
