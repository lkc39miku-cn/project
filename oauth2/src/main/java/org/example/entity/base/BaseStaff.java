package org.example.entity.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class BaseStaff implements Serializable {
    @Serial
    private static final long serialVersionUID = 3190055636503347742L;
    protected String username;
    protected String password;
    protected String code;
    protected String uuid;
}
