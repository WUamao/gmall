package com.amao.gmall.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author amao
 * @date 2020/3/24 20:50
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "sso.server")
public class SsoConfig {

    private String url;
    private String loginpath;

}
