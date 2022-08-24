package org.example.filter;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Staff;
import org.example.mapper.StaffMapper;
import org.example.util.StaffThreadLocal;
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
    private StaffMapper staffMapper;

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
            StaffThreadLocal.setStaff(staffMapper.selectOne(new LambdaQueryWrapper<Staff>()
                    .eq(Staff::getUsername, SecurityContextHolder.getContext().getAuthentication().getName())));
        }
        filterChain.doFilter(request, response);
    }
}
