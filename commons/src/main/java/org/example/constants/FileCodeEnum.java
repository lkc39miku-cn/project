package org.example.constants;

import java.util.Optional;

public enum FileCodeEnum implements BaseEnum<FileCodeEnum> {
    ;

    private final Integer code;
    private final String message;

    FileCodeEnum(Integer code, String message) {
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

    public static Optional<FileCodeEnum> of(Integer code) {
        return Optional.ofNullable(BaseEnum.parseByCode(FileCodeEnum.class, code));
    }
}
