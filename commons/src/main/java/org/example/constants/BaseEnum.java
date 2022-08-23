package org.example.constants;

public interface BaseEnum<T extends Enum<T> & BaseEnum<T>> {
    Integer getCode();

    String getMessage();

    static <T extends Enum<T> & BaseEnum<T>> T parseByCode(Class<T> clazz, Integer code) {
        for (T t : clazz.getEnumConstants()) {
            if (t.getCode().intValue() == code.intValue()) {
                return t;
            }
        }
        return null;
    }
}
