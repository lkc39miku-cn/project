package org.example.util;

import org.example.entity.Staff;

public class StaffThreadLocal {
    public static final ThreadLocal<Staff> STAFF = new ThreadLocal<>();

    public static Staff getStaff() {
        return STAFF.get();
    }

    public static void setStaff(Staff staff) {
        STAFF.set(staff);
    }

    public static void removeStaff() {
        STAFF.remove();
    }
}
