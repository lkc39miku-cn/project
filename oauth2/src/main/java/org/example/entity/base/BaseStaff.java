package org.example.entity.base;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class BaseStaff implements Serializable {
    protected String username;
    protected String password;
    protected String code;
    protected String uuid;
}
