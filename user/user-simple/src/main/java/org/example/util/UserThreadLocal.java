package org.example.util;

import org.example.entity.User;

public class UserThreadLocal {
    public static final ThreadLocal<User> USER = new ThreadLocal<>();

    public static User getUser() {
        return USER.get();
    }

    public static void setUser(User user) {
        USER.set(user);
    }

    public static void removeUser() {
        USER.remove();
    }
}
