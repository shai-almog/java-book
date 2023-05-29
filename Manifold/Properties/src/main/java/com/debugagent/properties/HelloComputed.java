package com.debugagent.properties;

import manifold.ext.props.rt.api.var;

public class HelloComputed {
    @var int number;
    @var String str;

    public void setNumber(int number) {
        this.number = number - 1;
    }
}
