package com.debugagent.extensions.java.lang.String;

import com.debugagent.extensions.Sizable;
import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

@Extension
public abstract class StringExt implements Sizable {
    public static int size(@This String str) {
        return str.length();
    }
}
