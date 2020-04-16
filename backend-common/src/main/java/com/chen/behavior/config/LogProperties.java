package com.chen.behavior.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

/**
 * 属性
 * @author jingchen
 * @since 2020-04-15
 */
@Data
public class LogProperties {
    @Value("behavior.app-name")
    private String appName;
}
