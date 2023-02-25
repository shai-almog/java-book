package com.debugagent.testing.tests;

import com.debugagent.testing.MyObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BeforeTest {
    private MyObject myObj;

    @BeforeEach
    public void setUp() {
        myObj = new MyObject();
    }

    @Test
    public void testMyMethod() {
        Assertions.assertEquals(42, myObj.myMethod());
    }
}
