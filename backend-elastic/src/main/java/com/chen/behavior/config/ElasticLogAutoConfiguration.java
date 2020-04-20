package com.chen.behavior.config;

import com.chen.behavior.properties.BehaviorCollectionProperties;
import com.chen.behavior.repository.LogElasticRepository;
import com.chen.behavior.service.ILogService;
import com.chen.behavior.service.IOperatorService;
import com.chen.behavior.service.impl.LogElasticServiceImpl;
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
public class ElasticLogAutoConfiguration {

    @Autowired
    private BehaviorCollectionProperties properties;

    @Autowired
    private LogElasticRepository elasticRepository;

    @Autowired
    private IOperatorService operatorService;

    @Bean
    @ConditionalOnMissingBean(ILogService.class)
    public ILogService logService() {
        return new LogElasticServiceImpl(elasticRepository, properties, operatorService);
    }

}