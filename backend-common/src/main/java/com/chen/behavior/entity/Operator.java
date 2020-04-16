package com.chen.behavior.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 用户
 *
 * @author jingchen
 * @since 2020-04-15
 */
@Data
@AllArgsConstructor
public class Operator {

    /**
     * 操作人ID
     */
    private Long operatorId;

    /**
     * 操作人
     */
    private String operatorName;

}
