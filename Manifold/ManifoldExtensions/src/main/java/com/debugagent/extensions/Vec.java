package com.debugagent.extensions;

import manifold.ext.rt.api.ComparableUsing;

public class Vec implements Comparable<Vec>, ComparableUsing<Vec> {
    private float x, y, z;

    public Vec(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec plus(Vec other) {
        return new Vec(x + other.x, y + other.y, z + other.z);
    }

    public Vec plus(float other) {
        return new Vec(x + other, y + other, z + other);
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    @Override
    public int compareTo(Vec o) {
        return Double.compare(magnitude(), o.magnitude());
    }
}
