package org.example.util;

import org.example.entity.User;

public class UserThreadLocal {
    public static final ThreadLocal<User> USER = new ThreadLocal<>();

    public static User getStaff() {
        return USER.get();
    }

    public static void setStaff(User user) {
        USER.set(user);
    }

    public static void removeStaff() {
        USER.remove();
    }
}
