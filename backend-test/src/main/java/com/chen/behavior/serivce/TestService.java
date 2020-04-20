package com.chen.behavior.serivce;

import com.chen.behavior.annotation.LogBehavior;
import com.chen.behavior.annotation.LogModule;
import org.springframework.stereotype.Service;

/**
 * 测试类
 *
 * @author jingchen
 * @since 2020-04-20
 */
@Service
@LogModule("测试")
public class TestService {

    @LogBehavior(action = "testMethodAction", description = "描述")
    public String testMethod(String val) {
        return "hello! " + val;
    }
}
