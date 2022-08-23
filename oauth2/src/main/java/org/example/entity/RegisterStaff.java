package org.example.entity;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.base.BaseStaff;

import java.io.Serial;

@ApiModel(value="注册员工")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public final class RegisterStaff extends BaseStaff {
    @Serial
    private static final long serialVersionUID = -9066505945910019017L;
}
