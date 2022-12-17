package com.debugagent.ch02.patterns.singleton;

public abstract class PlatformSingleton {
    private static final PlatformSingleton INSTANCE;

    static {
        if(System.getProperty("os.name").toLowerCase().contains("mac")) {
            INSTANCE = new Mac();
        } else {
            INSTANCE = new Windows();
        }
    }

    public PlatformSingleton getInstance() {
        return INSTANCE;
    }

    public abstract void platformMethod();

    static class Mac extends PlatformSingleton {
        @Override
        public void platformMethod() {
            // mac implementation
        }
    }

    static class Windows extends PlatformSingleton {
        @Override
        public void platformMethod() {
            // windows implementation
        }
    }
}
