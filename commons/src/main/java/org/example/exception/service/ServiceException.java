package org.example.exception.service;

import lombok.Getter;
import lombok.Setter;
import org.example.constants.BaseEnum;
import org.example.constants.BaseException;
import org.example.constants.CodeEnum;

import java.io.Serial;

public class ServiceException extends BaseException {
    @Serial
    private static final long serialVersionUID = 22310317710516088L;

    @Getter
    @Setter
    private String message;

    public ServiceException(BaseEnum<?> baseEnum) {
        super(baseEnum, BaseModule.SERVICE);
    }

    public ServiceException(BaseEnum<?> baseEnum, String message) {
        super(baseEnum, BaseModule.SERVICE);
        this.message = message;
    }

    public ServiceException(String message) {
        super(CodeEnum.SC_OK, BaseModule.SERVICE);
        this.message = message;
    }
}
