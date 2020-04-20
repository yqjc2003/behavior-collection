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

    /**
     * 构建用户行为实体类
     *
     * @param joinPoint       jp
     * @param logBehavior     注解包含的信息
     * @param properties      属性
     * @param operatorService 当前登录人相关信息
     * @return 用户行为实体类
     */
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
