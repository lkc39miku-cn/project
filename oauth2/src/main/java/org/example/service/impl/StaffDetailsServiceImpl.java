package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Staff;
import org.example.entity.StaffBody;
import org.example.exception.service.ServiceException;
import org.example.key.StaffKey;
import org.example.mapper.StaffMapper;
import org.example.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Slf4j
@Service
public class StaffDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("check:{}", username);

        Staff staff = staffMapper.selectOne(new LambdaQueryWrapper<Staff>()
                .eq(Staff::getUsername, username));

        if (Objects.isNull(staff)) {
            log.info("登录用户：{} 不存在.", username);
            throw new ServiceException("登录用户：" + username + " 不存在");
        }

        if (StaffKey.IS_DELETE.equals(staff.getDeleteStatus())) {
            log.info("登录用户：{} 已被删除.", username);
            throw new ServiceException("对不起，您的账号：" + username + " 已被删除");
        }

        if (StaffKey.IS_NOT_USED.equals(staff.getStatus())) {
            log.info("登录用户：{} 已被停用.", username);
            throw new ServiceException("对不起，您的账号：" + username + " 已停用");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        Set<String> menuPermissions = permissionService.getMenuPermission(staff);
        menuPermissions.forEach(v -> {
            grantedAuthorities.add(new SimpleGrantedAuthority(v));
        });

        return (UserDetails) new StaffBody()
                .setStaff(staff)
                .setAuthorities(grantedAuthorities)
                .setId(staff.getId());
    }
}
