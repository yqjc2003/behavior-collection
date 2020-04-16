package com.chen.behavior.service;

import com.chen.behavior.annotation.LogBehavior;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author jingchen
 * @since 2020-04-15
 */
@Service
public interface ILogService {
    /**
     * 记录
     *
     * @param joinPoint joinPoint
     * @param logBehavior 行为注解
     */
    void logBehavior(ProceedingJoinPoint joinPoint, LogBehavior logBehavior);
}
