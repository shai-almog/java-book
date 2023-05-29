package com.debugagent.properties;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;

public class Main {
    public static void main(String[] argv) {
        var properties = new HelloProperties();
        properties.number = 5;

        var pojo = new HelloPojo();
        pojo.number = 5;

        var time = Calendar.instance.timeInMillis;

        var scoping = new HelloScoping();
        scoping.str = "";
        //scoping.number = 4;
        //System.out.println(scoping.str);
        System.out.println(scoping.number);

        var computed = new HelloComputed();
        computed.number = 5;
        System.out.println(computed.number);

        // Won't trigger a checked exception since those are disabled
        new String(new byte[0], "UTF-8");
    }
}
