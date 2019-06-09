package com.traffic;

import java.util.List;

public class Line {
    private List<Field> fields;
    private Intersection startInter;
    private Intersection finalInter;

    public Field getFirstField() {
        return fields.get(0);
    }

    public Field getLastField() {
        return fields.get(fields.size() - 1);
    }

    public int howManyWaiting(Intersection intersection) {
        if (intersection != finalInter) {
            return 0;
        } else {
            int res = 0;
            for (Field f : fields) {
                if (!f.isEmpty())
                    res++;
            }
            return res;
        }
    }
}
