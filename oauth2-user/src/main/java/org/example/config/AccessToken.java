package org.example.config;

import org.example.entity.UserBody;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AccessToken extends JwtAccessTokenConverter {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        UserBody userBody = (UserBody) authentication.getUserAuthentication().getPrincipal();
        userBody.getUser().setPassword(null);
        DefaultOAuth2AccessToken defaultOAuth2AccessToken = (DefaultOAuth2AccessToken) super.enhance(accessToken, authentication);
        Map<String, Object> map = new HashMap<>(1);
        map.put("userBody", userBody);
        defaultOAuth2AccessToken.setAdditionalInformation(map);
        return defaultOAuth2AccessToken;
    }
}
