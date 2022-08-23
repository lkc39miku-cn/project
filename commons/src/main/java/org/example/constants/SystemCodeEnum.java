package org.example.constants;


import java.util.Optional;

public enum SystemCodeEnum implements BaseEnum<SystemCodeEnum> {
    ;

    private final Integer code;
    private final String message;

    SystemCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    public static Optional<SystemCodeEnum> of(Integer code) {
        return Optional.ofNullable(BaseEnum.parseByCode(SystemCodeEnum.class, code));
    }
}
