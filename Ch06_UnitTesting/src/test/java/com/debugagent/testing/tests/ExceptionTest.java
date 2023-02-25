package com.debugagent.testing.tests;

import com.debugagent.testing.MyObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionTest {
    @Test
    public void testMyMethodThrowsException() {
        MyObject myObj = new MyObject();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            myObj.myMethodThatThrowsException();
        });
    }
}
