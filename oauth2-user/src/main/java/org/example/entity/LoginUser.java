package org.example.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.base.BaseUser;

import java.io.Serial;

@ApiModel(value="登录用户")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public final class LoginUser extends BaseUser {
    @Serial
    private static final long serialVersionUID = -8112317966718206907L;
}
