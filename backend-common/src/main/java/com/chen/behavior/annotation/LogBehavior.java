package com.chen.behavior.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 行为注解
 *
 * @author jingchen
 * @since 2020-04-15
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogBehavior {

    /**
     * 操作
     */
    String action();

    /**
     * 描述
     */
    String description();

    /**
     * 额外信息
     */
    String meta() default "";

}
