package com.debugagent.ch03.language;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class TryWithResources {
    public static void main(String[] args) throws IOException {
        // Using try with resources
        try(var input = new FileInputStream("pom.xml")) {
            System.out.println(new String(input.readAllBytes()));
        }

        // Old way
        InputStream input = null;
        try {
            input = new FileInputStream("pom.xml");
            System.out.println(new String(input.readAllBytes()));
        } finally {
            try {
                if(input != null) {
                    input.close();
                }
            } catch (IOException exception) {}
        }
    }
}
