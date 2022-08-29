package org.example.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.base.BaseUser;

import java.io.Serial;

@ApiModel(value="注册用户")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public final class RegisterUser extends BaseUser {
    @Serial
    private static final long serialVersionUID = -9066505945910019017L;
}
