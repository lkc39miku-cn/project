package org.example.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Configuration
public class RestTemplateConfig {

    @Bean
    @Primary
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Resource
    private OAuth2ClientContext oAuth2ClientContext;

    @Bean
    @Primary
    @LoadBalanced
    public OAuth2RestTemplate oAuth2RestTemplate() {
        return new OAuth2RestTemplate(new ClientCredentialsResourceDetails(), oAuth2ClientContext);
    }
}