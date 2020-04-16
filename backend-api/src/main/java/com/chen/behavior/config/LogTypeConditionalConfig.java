package com.chen.behavior.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author jingchen
 * @since 2020-04-16
 */
@Configuration
@Slf4j
public class LogTypeConditionalConfig {

    // @ConditionalOnProperty(name = "app.initialize.dictionary", value = "mongo")
    // @Bean
    // public ILogService initLogTypeService() {
    //     log.info("MyConditionalService已加载。");
    // }
}
