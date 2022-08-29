package org.example.key;

public interface DeptKey {
    Integer IS_USED = 0;
    Integer IS_NOT_USED = 1;
    Integer IS_NOT_DELETE = 0;
    Integer IS_DELETE = 1;

    String REDIS_SELECT_ID_KEY = "dept:select:id:";
    String REDIS_SELECT_ALL = "dept:select:all";
    String REDIS_TREE = "dept:tree";
}
