package com.debugagent.extensions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperatorOverloading {
    public static void main(String[] argv) {
        Vec vec1 = new Vec(1, 2, 3);
        Vec vec2 = new Vec(1, 1, 1);
        Vec vec3 = vec1 + vec2;
        vec3 += 5.0f;
        vec3 = 5.0f + vec3;
        vec3 += Float.valueOf(5.0f);

        if(vec3 > vec2) {
            // vec3 is larger than vec2...
            // determined by Comparable
        }

        if(vec3 == vec1) {
            // Pointer comparison or operator?
        }

        var x = new BigDecimal(5L);
        var y = new BigDecimal(25L);
        var z = 5 + x + y;

        var list = new ArrayList<>(List.of("A", "B", "C"));
        var v = list[0];
        list[0] = "1";

        var map = new HashMap<>(Map.of("Key", "Value"));
        var key = map["Key"];
        map["Key"] = "New Value";
    }
}
