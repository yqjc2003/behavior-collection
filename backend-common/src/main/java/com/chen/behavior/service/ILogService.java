package com.chen.behavior.service;

import com.chen.behavior.annotation.LogBehavior;
import com.chen.behavior.annotation.LogModule;
import com.chen.behavior.entity.Behavior;
import com.chen.behavior.properties.BehaviorCollectionProperties;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Clock;

/**
 * 行为采集service
 *
 * @author jingchen
 * @since 2020-04-15
 */
@Service
public interface ILogService {
    /**
     * 记录
     *
     * @param joinPoint   joinPoint
     * @param logBehavior 行为注解
     */
    @Async
    void logBehavior(ProceedingJoinPoint joinPoint, LogBehavior logBehavior);

    default Behavior buildBehaviorEntity(ProceedingJoinPoint joinPoint,
                                         LogBehavior logBehavior,
                                         BehaviorCollectionProperties properties,
                                         IOperatorService operatorService) {
        LogModule logModule = joinPoint.getTarget().getClass().getAnnotation(LogModule.class);
        String moduleName = "";
        if (logModule != null) {
            moduleName = logModule.value();
        }
        return Behavior.builder()
                .appName(properties.getAppName())
                .module(moduleName)
                .operator(operatorService.getOperator())
                .action(logBehavior.action())
                .className(joinPoint.getTarget().getClass().getSimpleName())
                .methodName(joinPoint.getSignature().getName())
                .description(logBehavior.description())
                .meta(logBehavior.meta())
                .timestamp(Clock.systemDefaultZone().millis())
                // .operator()
                .build();
    }
}
