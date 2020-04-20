package com.chen.behavior.config;

import com.chen.behavior.properties.BehaviorCollectionProperties;
import com.chen.behavior.repository.LogMongoRepository;
import com.chen.behavior.serivce.impl.LogMongoServiceImpl;
import com.chen.behavior.service.ILogService;
import com.chen.behavior.service.IOperatorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chen
 * @since 2020-04-17
 */
@ConditionalOnClass(ILogService.class)
@EnableConfigurationProperties(BehaviorCollectionProperties.class)
@Configuration
@Slf4j
public class MongoLogAutoConfiguration {

    @Autowired
    private BehaviorCollectionProperties properties;

    @Autowired
    private LogMongoRepository logMongoRepository;

    @Autowired
    private IOperatorService operatorService;

    @Bean
    @ConditionalOnMissingBean(ILogService.class)
    public ILogService logService() {
        log.info(properties.toString());
        return new LogMongoServiceImpl(logMongoRepository, properties, operatorService);
    }

}