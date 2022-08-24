package org.example.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.key.PermissionKey;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * PermissionCheck
 * custom permission check annotation
 */
@Slf4j
@Component
public class PermissionCheck {

    private Set<String> getAuthorities() {
        log.info("getAuthorities: {}", SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toSet());
    }

    /**
     * has permission release else prevent
     * @param permission permission
     * @return boolean
     */
    public boolean hasPermissions(String permission) {
        if (StringUtils.isEmpty(permission)) {
            return false;
        }

        if (CollectionUtils.isEmpty(getAuthorities())) {
            return false;
        }

        return hasPermissions(getAuthorities(), permission);
    }

    /**
     * has permission prevent else release
     * @param permission permission
     * @return boolean
     */
    public boolean lacksPermission(String permission) {
        return !hasPermissions(permission);
    }

    public boolean hasAnyPermission(String permissions) {
        if (StringUtils.isEmpty(permissions)) {
            return false;
        }

        if (CollectionUtils.isEmpty(getAuthorities())) {
            return false;
        }

        for (String permission : permissions.split(PermissionKey.PERMISSION_DELIMITER)) {
            if (StringUtils.isNotEmpty(permission) && hasPermissions(getAuthorities(), permission)) {
                return true;
            }
        }
        return false;
    }

    /**
     * has role release else prevent
     * @param role role
     * @return boolean
     */
    @Deprecated
    public boolean hasRole(String role) {
        if (StringUtils.isEmpty(role)) {
            return false;
        }

        if (CollectionUtils.isEmpty(getAuthorities())) {
            return false;
        }

//        for (Role i : staff.getSysStaff().getSysRoleList()) {
//            String roleKey = i.getRoleKey();
//            if (PermissionKey.ALL_ROLE.equals(roleKey) || roleKey.equals(StringUtils.trim(role))) {
//                return true;
//            }
//        }
        return false;
    }

    /**
     * has role prevent else release
     * @param role role
     * @return boolean
     */
    @Deprecated
    public boolean lacksRole(String role) {
        return !hasRole(role);
    }

    /**
     * has any role release else prevent
     * @param roles roles
     * @return boolean
     */
    @Deprecated
    public boolean hasAnyRoles(String roles) {
        if (StringUtils.isEmpty(roles)) {
            return false;
        }

        if (CollectionUtils.isEmpty(getAuthorities())) {
            return false;
        }

        for (String roleKey : roles.split(PermissionKey.ROLE_DELIMITER)) {
            if (hasRole(roleKey)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasPermissions(Set<String> permissions, String permission) {
        return permissions.contains(PermissionKey.ALL_PERMISSION) || permissions.contains(StringUtils.trim(permission));
    }

}
