package com.chen.behavior.serivce.impl;

import com.chen.behavior.annotation.LogBehavior;
import com.chen.behavior.annotation.LogModule;
import com.chen.behavior.entity.Behavior;
import com.chen.behavior.repository.LogMongoRepository;
import com.chen.behavior.service.ILogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Clock;

/**
 * mongo实现
 *
 * @author jingchen
 * @since 2020-04-15
 */
@Service
public class LogMongoServiceImpl implements ILogService {

    private final LogMongoRepository logMongoRepository;

    public LogMongoServiceImpl(LogMongoRepository logMongoRepository) {
        this.logMongoRepository = logMongoRepository;
    }

    /**
     * 记录
     *
     * @param joinPoint   joinPoint
     * @param logBehavior 行为注解
     */
    @Override
    public void logBehavior(ProceedingJoinPoint joinPoint, LogBehavior logBehavior) {

        LogModule logModule = joinPoint.getTarget().getClass().getAnnotation(LogModule.class);
        String moduleName = "";
        if (logModule != null) {
            moduleName = logModule.value();
        }


        Behavior behavior = Behavior.builder()
                .appName("应用")
                .module(moduleName)
                .action(logBehavior.action())
                .className(joinPoint.getTarget().getClass().getSimpleName())
                .methodName(joinPoint.getSignature().getName())
                .description(logBehavior.description())
                .meta(logBehavior.meta())
                .timestamp(Clock.systemDefaultZone().millis())
                // .operator()
                .build();

        logMongoRepository.save(behavior);
    }
}
