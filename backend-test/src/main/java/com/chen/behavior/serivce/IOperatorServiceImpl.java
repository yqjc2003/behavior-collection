package com.chen.behavior.serivce;

import com.chen.behavior.entity.Operator;
import com.chen.behavior.service.IOperatorService;
import org.springframework.stereotype.Service;

/**
 * 当前登录人
 *
 * @author jingchen
 * @since 2020-04-20
 */
@Service
public class IOperatorServiceImpl implements IOperatorService {
    /**
     * 获取操作人信息
     *
     * @return 获取操作人信息
     */
    @Override
    public Operator getOperator() {
        return new Operator(1L, "用户名");
    }
}
