package com.debugagent.testing.tests;

import com.debugagent.testing.MyObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MyTest {
    @Test
    public void testMyMethod() {
        MyObject myObj = new MyObject();
        Assertions.assertEquals(42, myObj.myMethod());
    }
}
