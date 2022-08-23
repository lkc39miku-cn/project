package org.example.constants;

import lombok.Data;
import lombok.experimental.Accessors;
import org.example.model.R;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public abstract class BaseR<T, V extends BaseR<T, V>> implements Serializable {
    protected Integer code;
    protected String message;
    protected T data;

    public abstract V ok();

    public abstract V ok(T data);

    public abstract V fail();

    public abstract V fail(String message);
}
