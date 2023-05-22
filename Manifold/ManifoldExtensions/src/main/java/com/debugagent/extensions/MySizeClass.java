package com.debugagent.extensions;

import manifold.ext.rt.api.Self;

public class MySizeClass {
    int size = 5;

    public int size() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean equals(@Self Object o) {
        return o != null && ((MySizeClass)o).size == size;
    }
}
