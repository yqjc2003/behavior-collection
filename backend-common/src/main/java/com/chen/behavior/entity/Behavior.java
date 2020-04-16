package com.chen.behavior.entity;

import lombok.Builder;
import lombok.Data;

/**
 * 用户行为
 *
 * @author jingchen
 * @since 2020-04-15
 */
@Data
@Builder
public class Behavior {
    /**
     * 操作人
     */
    private Operator operator;

    /**
     * appName
     */
    private String appName;

    /**
     * 类名
     */
    private String className;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 操作模块
     */
    private String module;

    /**
     * 操作
     */
    private String action;

    /**
     * 描述
     */
    private String description;

    /**
     * 额外信息
     */
    private String meta;

    /**
     * 操作时间
     */
    private Long timestamp;

}
