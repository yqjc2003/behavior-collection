package com.chen.behavior.config;

import com.chen.behavior.repository.LogMongoRepository;
import com.chen.behavior.serivce.impl.LogMongoServiceImpl;
import com.chen.behavior.service.ILogService;
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
@EnableConfigurationProperties(LogMongoRepository.class)
@Configuration
public class MongoLogAutoConfiguration {

    @Autowired
    private LogMongoRepository logMongoRepository;

    @Bean
    @ConditionalOnMissingBean(ILogService.class)
    public ILogService logService() {
        return new LogMongoServiceImpl(logMongoRepository);
    }

}