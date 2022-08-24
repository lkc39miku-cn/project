package org.example.entity.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(value="员工Param")
@Data
public final class StaffParam {
    private String username;
    private String phone;
    private String roleId;
}
