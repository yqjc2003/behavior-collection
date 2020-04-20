package com.chen.behavior.service.impl;

import com.chen.behavior.annotation.LogBehavior;
import com.chen.behavior.entity.Behavior;
import com.chen.behavior.properties.BehaviorCollectionProperties;
import com.chen.behavior.repository.LogElasticRepository;
import com.chen.behavior.service.ILogService;
import com.chen.behavior.service.IOperatorService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

/**
 * mongo实现
 *
 * @author jingchen
 * @since 2020-04-15
 */
@Service
public class LogElasticServiceImpl implements ILogService {

    private final LogElasticRepository elasticRepository;

    private final BehaviorCollectionProperties properties;

    private final IOperatorService operatorService;

    public LogElasticServiceImpl(LogElasticRepository elasticRepository,
                                 BehaviorCollectionProperties properties,
                                 IOperatorService operatorService) {
        this.elasticRepository = elasticRepository;
        this.properties = properties;
        this.operatorService = operatorService;
    }

    /**
     * 记录
     *
     * @param joinPoint   joinPoint
     * @param logBehavior 行为注解
     */
    @Override
    public void logBehavior(ProceedingJoinPoint joinPoint, LogBehavior logBehavior) {
        if (!properties.getEnable()) {
            return;
        }
        Behavior behavior = buildBehaviorEntity(joinPoint, logBehavior, properties, operatorService);
        elasticRepository.save(behavior);
    }

}
