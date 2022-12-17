package com.debugagent.ch02.patterns.builder;

public class Created {
    private int val1;
    private String val2;
    private boolean val3;

    private Created() {
    }

    public static Builder create() {
        return new Builder();
    }

    public static class Builder {
        Created c = new Created();

        private Builder() {}

        public Builder val1(int val1) {
            c.val1 = val1;
            return this;
        }

        public Builder val2(String val2) {
            c.val2 = val2;
            return this;
        }

        public Builder val3(boolean val3) {
            c.val3 = val3;
            return this;
        }

        public Created build() {
            if(c.val2 == null) {
                throw new IllegalStateException();
            }
            return c;
        }
    }

    public static void main(String s) {
        Created created = Created.create()
                .val1(1)
                .val2("Test")
                .val3(false).build();
    }
}
