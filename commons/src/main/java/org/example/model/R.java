package org.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEnum;
import org.example.constants.BaseR;
import org.example.constants.CodeEnum;

import java.io.Serial;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class R<T> extends BaseR<T, R<T>> {

    @Serial
    private static final long serialVersionUID = -32761986519393341L;

    @Override
    public R<T> ok() {
        return (R<T>) new R<T>()
                .setCode(CodeEnum.SC_OK.getCode())
                .setMessage(CodeEnum.SC_OK.getMessage());
    }

    @Override
    public R<T> ok(T data) {
        return (R<T>) ok()
                .setData(data);
    }

    @Override
    public R<T> fail() {
        return (R<T>) new R<T>()
                .setCode(CodeEnum.SC_INTERNAL_SERVER_ERROR.getCode())
                .setMessage(CodeEnum.SC_INTERNAL_SERVER_ERROR.getMessage());
    }

    @Override
    public R<T> fail(String message) {
        return (R<T>) fail()
                .setMessage(message);
    }
}
