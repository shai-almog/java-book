package com.debugagent.extensions.java.math.BigDecimal;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.math.BigDecimal;

@Extension
public class BigDecimalExt {
    public static BigDecimal plus(@This BigDecimal b, int i) {
        return b.plus(BigDecimal.valueOf(i));
    }
}
