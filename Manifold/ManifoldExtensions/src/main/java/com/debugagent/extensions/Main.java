package com.debugagent.extensions;

import java.io.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> strings = List.of("1", "2", "3");
        List<Integer> numbers = strings.map(Integer::parseInt).toList();

        var str = "https://debugagent.com";
        str = str.removePrefix("https://");
        try(InputStream i = new FileInputStream("myFile") ;
            OutputStream o = new FileOutputStream("other")) {
            i.copyTo(o);
        }

        String[] arr = strings.toArray(new String[0]);
        if(arr.isEmpty()) {
            // ...
        }

        Sizable s = str;
        Sizable v = strings;
        s.size();
        //Sizable z = new MySizeClass();
        //z.size();
    }
}