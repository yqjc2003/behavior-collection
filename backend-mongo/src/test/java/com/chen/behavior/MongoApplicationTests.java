package com.chen.behavior;

import com.chen.behavior.entity.Behavior;
import com.chen.behavior.entity.Operator;
import com.chen.behavior.repository.LogMongoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Clock;
import java.time.Instant;

@SpringBootTest
class MongoApplicationTests {

    @Autowired
    private LogMongoRepository logMongoRepository;

    @Test
    void contextLoads() {
        for (long i = 0; i < 100; i++) {

            Behavior behavior = Behavior.builder()
                    .appName("应用")
                    .module("模块" + i % 10)
                    .action("行为" + i)
                    .description("描述" + i)
                    .timestamp(Clock.systemDefaultZone().millis())
                    .operator(new Operator(i, "用户" + i))
                    .build();
            logMongoRepository.save(behavior);
        }
    }

}
