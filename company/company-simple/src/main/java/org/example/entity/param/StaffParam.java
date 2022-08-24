package org.example.entity.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@ApiModel(value="员工Param")
@Data
public final class StaffParam {
    private String id;
    private String username;
    private String phone;
    private String email;
    private String deptId;
    private String roleId;
    private List<String> roleIdList;
}
