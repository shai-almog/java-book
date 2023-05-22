package com.debugagent.extensions;

import manifold.ext.rt.api.Jailbreak;
import manifold.ext.rt.api.Self;

import java.util.Date;

public class JailBreaker {
    public static void main(String[] argv) {
        @Jailbreak String exposedString = "Exposed...";
        exposedString.value[2] = '0';
        System.out.println(exposedString);

        @Jailbreak String str = null;
        str.isASCII(new byte[] { 111, (byte)222 });

        Date d = new Date();
        long t = d.jailbreak().fastTime;
    }
}
