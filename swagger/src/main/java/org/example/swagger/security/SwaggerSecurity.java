package org.example.swagger.security;

import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.example.constants.BaseConfiguration;
import org.example.key.TokenKey;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.service.contexts.SecurityContext;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Configuration
public class SwaggerSecurity implements BaseConfiguration.Swagger.Configuration {
    @Override
    public void init() {
        log.info("SwaggerSecurity init");
    }

    public List<SecurityScheme> securitySchemes() {
        List<SecurityScheme> apiKeyList = new ArrayList<>();
        apiKeyList.add(new ApiKey(TokenKey.TOKEN, TokenKey.AUTHORIZATION, In.HEADER.toValue()));
        return apiKeyList;
    }

    public List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                        .securityReferences(securityReferences())
                        .operationSelector(v -> v.requestMappingPattern().matches("/.*"))
                        .build()
        );
        return securityContexts;
    }

    private List<SecurityReference> securityReferences() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference(TokenKey.AUTHORIZATION, authorizationScopes));
        return securityReferences;
    }
}
