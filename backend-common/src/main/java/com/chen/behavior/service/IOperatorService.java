package com.chen.behavior.service;

import com.chen.behavior.entity.Operator;

/**
 * 获取当前操作人信息
 *
 * @author jingchen
 * @since 2020-04-15
 */
public interface IOperatorService {

    /**
     * 获取操作人信息
     *
     * @return 获取操作人信息
     */
    Operator getOperator();
}
