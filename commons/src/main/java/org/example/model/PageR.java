package org.example.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseR;
import org.example.constants.CodeEnum;

import java.io.Serial;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public final class PageR<T> extends BaseR<T, PageR<T>> {

    private Long count;

    @Serial
    private static final long serialVersionUID = -8927096616617776525L;

    @Override
    public PageR<T> ok() {
        return (PageR<T>) new PageR<T>()
                .setCode(CodeEnum.SC_OK.getCode())
                .setMessage(CodeEnum.SC_OK.getMessage());
    }

    @Override
    public PageR<T> ok(T data) {
        return (PageR<T>) ok()
                .setData(data);
    }

    @Override
    public PageR<T> fail() {
        return (PageR<T>) new PageR<T>()
                .setCode(CodeEnum.SC_INTERNAL_SERVER_ERROR.getCode())
                .setMessage(CodeEnum.SC_INTERNAL_SERVER_ERROR.getMessage());
    }

    @Override
    public PageR<T> fail(String message) {
        return (PageR<T>) fail()
                .setMessage(message);
    }
}
