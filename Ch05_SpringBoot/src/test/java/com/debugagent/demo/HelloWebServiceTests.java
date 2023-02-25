package com.debugagent.demo;

import com.debugagent.demo.rest.HelloWebService;
import com.debugagent.demo.service.HelloService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class HelloWebServiceTests {
    @Mock
    private HelloService helloService;

    @Test
    public void testWebServicePassesValueDirectlyToService() {
        Mockito.when(helloService.helloService("XYZ")).thenReturn("PASSED");
        HelloWebService helloWebService = new HelloWebService(helloService);
        Assertions.assertEquals(helloWebService.hello("XYZ"), "PASSED");
    }
}
