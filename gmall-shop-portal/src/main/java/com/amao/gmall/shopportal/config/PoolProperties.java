package com.amao.gmall.shopportal.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author amao
 * @date 2020/3/23 23:51
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "gmall.pool")
public class PoolProperties {

    private Integer coreSize;
    private Integer maximumPoolSize;
    private Integer queueSize;


}
