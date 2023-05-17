package com.debugagent.extensions.java.lang.Integer;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.math.BigDecimal;

@Extension
public class IntegerExt {
    public static BigDecimal plus(@This Integer t, BigDecimal arg) {
        return arg.plus(BigDecimal.valueOf(t.longValue()));
    }
}
