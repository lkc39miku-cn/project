package org.example.constants;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;

public class BaseException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -2290910777475947801L;

    @Getter
    protected final BaseEnum<?> baseEnum;

    @Getter
    @Setter
    protected String module;

    public enum BaseModule {
        SERVICE("service"),
        FILE("file");

        private final String module;

        BaseModule(String module) {
            this.module = module;
        }
    }

    public BaseException(BaseEnum<?> baseEnum, BaseModule module) {
        this.baseEnum = baseEnum;
        this.module = module.module;
    }
}
