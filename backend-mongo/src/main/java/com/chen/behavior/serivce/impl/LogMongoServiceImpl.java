package com.chen.behavior.serivce.impl;

import com.chen.behavior.annotation.LogBehavior;
import com.chen.behavior.entity.Behavior;
import com.chen.behavior.properties.BehaviorCollectionProperties;
import com.chen.behavior.repository.LogMongoRepository;
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
public class LogMongoServiceImpl implements ILogService {

    private final LogMongoRepository logMongoRepository;

    private final BehaviorCollectionProperties properties;

    private final IOperatorService operatorService;

    public LogMongoServiceImpl(LogMongoRepository logMongoRepository,
                               BehaviorCollectionProperties properties,
                               IOperatorService operatorService) {
        this.logMongoRepository = logMongoRepository;
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

        logMongoRepository.save(behavior);
    }
}
