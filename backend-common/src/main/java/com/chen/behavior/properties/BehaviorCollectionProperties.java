package com.chen.behavior.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 相关属性配置
 *
 * @author jingchen
 * @since 2020-04-20
 */
@ConfigurationProperties(prefix = "behavior.collection")
@Data
public class BehaviorCollectionProperties {

    private Boolean enable = false;
    private String appName = "defaultAppNAme";
    private String type = "";
}
