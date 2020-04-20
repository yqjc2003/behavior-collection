package com.chen.behavior;

import com.chen.behavior.serivce.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTests {

    @Autowired
    private TestService testService;

    @Test
    public void contextLoads() {
        testService.testMethod("test val");
    }

}
