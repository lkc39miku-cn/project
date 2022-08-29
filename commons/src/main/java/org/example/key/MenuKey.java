package org.example.key;

public interface MenuKey {
    Integer IS_FRAME = 0;
    Integer IS_NOT_FRAME = 1;
    Integer IS_USED = 0;
    Integer IS_NOT_USED = 1;
    Integer IS_SHOW = 0;
    Integer IS_NOT_SHOW = 1;

    String REDIS_SELECT_ID_KEY = "dept:select:id:";
    String REDIS_TREE = "dept:tree";
}
