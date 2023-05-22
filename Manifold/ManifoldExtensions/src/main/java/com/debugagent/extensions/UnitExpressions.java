package com.debugagent.extensions;

import manifold.science.measures.Force;
import manifold.science.measures.Length;

import static manifold.science.util.UnitConstants.*;

public class UnitExpressions {
    public static void main(String[] argv) {
        float speed = 100;
        Length distance = speed mph * 3 hr;
        Force force = 5kg * 9.807 m/s/s;
        if(force == 49.035 N) {
            // true
        }
    }
}
