package org.example.filter;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.entity.User;
import org.example.mapper.UserMapper;
import org.example.util.RedisCache;
import org.example.util.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * JwtAuthenticationToken
 */
@Slf4j
@Component
public class JwtAuthenticationToken extends OncePerRequestFilter {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisCache redisCache;

    /**
     * @param request that resulted in an <code>AuthenticationException</code>
     * @param response so that the user agent can begin authentication
     * @param filterChain filter chain
     * @throws ServletException servlet exception
     * @throws IOException io exception
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (Objects.nonNull(SecurityContextHolder.getContext().getAuthentication())) {
            User user;
            if (StringUtils.isEmpty(redisCache.getCacheObject("user name:" + SecurityContextHolder.getContext().getAuthentication().getName()))) {
                 user = userMapper.selectOne(new LambdaQueryWrapper<User>()
                        .eq(User::getAccount, SecurityContextHolder.getContext().getAuthentication().getName()));
                redisCache.setCacheObject("user name:" + user.getAccount(), user);
            } else {
                user = redisCache.getCacheObject("user name:" + SecurityContextHolder.getContext().getAuthentication().getName());
            }
            UserThreadLocal.setUser(user);
        }
        filterChain.doFilter(request, response);
    }
}
