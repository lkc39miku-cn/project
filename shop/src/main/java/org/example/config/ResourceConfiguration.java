package org.example.config;

import lombok.extern.slf4j.Slf4j;
import org.example.constants.BaseConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Slf4j
@Configuration
public class ResourceConfiguration extends ResourceServerConfigurerAdapter implements BaseConfiguration.OAuth2.ResourceServer {
    @Override
    public void init() {
        log.info("ResourceConfiguration init");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/doc.html", "/webjars/**", "/img/**", "/swagger-resources/**", "/favicon.ico", "/v3/api-docs")

                .permitAll()
                .antMatchers()
                .permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .access("#oauth2.hasScope('shop')");
    }
}