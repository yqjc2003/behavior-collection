package com.chen.behavior.aspect;

import com.chen.behavior.annotation.LogBehavior;
import com.chen.behavior.service.ILogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 切面
 *
 * @author jingchen
 * @since 2020-04-15
 */
@Aspect
@Component
public class LogAspect {

    private final ILogService logService;

    public LogAspect(ILogService logService) {
        this.logService = logService;
    }

    /**
     * aop logBehavior
     *
     * @param joinPoint   joinPoint
     * @param logBehavior logBehavior
     * @return Object
     * @throws Throwable Throwable
     */
    @Around(value = "@annotation(logBehavior)")
    public Object around(ProceedingJoinPoint joinPoint, LogBehavior logBehavior) throws Throwable {
        logService.logBehavior(joinPoint, logBehavior);
        return joinPoint.proceed();
    }

}
