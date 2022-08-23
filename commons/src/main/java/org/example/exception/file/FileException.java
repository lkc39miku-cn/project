package org.example.exception.file;

import lombok.Getter;
import lombok.Setter;
import org.example.constants.BaseEnum;
import org.example.constants.BaseException;
import org.example.constants.CodeEnum;
import org.example.constants.FileCodeEnum;

import java.io.Serial;

public class FileException extends BaseException {
    @Serial
    private static final long serialVersionUID = 5144197235279079777L;

    @Getter
    @Setter
    private String message;

    public FileException(BaseEnum<? extends FileCodeEnum> baseEnum) {
        super(baseEnum, BaseModule.FILE);
    }

    public FileException(BaseEnum<? extends FileCodeEnum> baseEnum, String message) {
        super(baseEnum, BaseModule.SERVICE);
        this.message = message;
    }

    public FileException(String message) {
        super(CodeEnum.SC_OK, BaseModule.SERVICE);
        this.message = message;
    }
}
