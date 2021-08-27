package com.geekbrains.ru.springmvcdemo.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "application.server")
public class ApplicationServerConfig {

    private String contextPath;
    private int port;

}
