package com.debugagent.modules;

import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        System.out.println("Hello world!");
        logger.fine("Hi there...");
    }
}