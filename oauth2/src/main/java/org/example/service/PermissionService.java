package org.example.service;

import org.example.entity.Staff;

import java.util.Set;

public interface PermissionService {
    Set<String> getMenuPermission(Staff staff);
}
