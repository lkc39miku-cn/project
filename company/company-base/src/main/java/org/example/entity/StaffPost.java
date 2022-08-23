package org.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

@ApiModel(value = "员工岗位关联")
@Data
@Accessors(chain = true)
public class StaffPost implements Serializable {
    @Serial
    private static final long serialVersionUID = 4040312416372582351L;

    @ApiModelProperty(value="外键 员工Id")
    private String staffId;

    @ApiModelProperty(value="外键 岗位Id")
    private String postId;
}
