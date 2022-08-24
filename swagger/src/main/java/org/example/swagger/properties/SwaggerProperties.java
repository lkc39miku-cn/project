package org.example.swagger.properties;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.constants.BaseConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Slf4j
@Data
@RefreshScope
@Configuration
public class SwaggerProperties implements BaseConfiguration.Swagger.Properties {
    @Override
    public void init() {
        log.info("SwaggerProperties init");
    }

    @Value("${swagger.title}")
    private String title;

    @Value("${swagger.description}")
    private String description;

    @Value("${swagger.name}")
    private String name;

    @Value("${swagger.url}")
    private String url;

    @Value("${swagger.email}")
    private String email;

    @Value("${swagger.version}")
    private String version;

    @Value("${swagger.enable}")
    private Boolean enable;

    @Value("${swagger.path-mapping}")
    private String pathMapping;
}