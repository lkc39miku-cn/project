package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@ApiModel(value = "角色")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity {
    @Serial
    private static final long serialVersionUID = -6731490734796778732L;

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "角色权限字符串")
    private String roleKey;

    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

    @ApiModelProperty(value = "菜单树选择项是否关联显示")
    private boolean menuCheckStrictly;

    @ApiModelProperty(value = "部门树选择项是否关联显示")
    private boolean deptCheckStrictly;

    @ApiModelProperty(value = "角色状态 0正常 1停用")
    private Integer status;

    @ApiModelProperty(value = "删除标志 0代表存在 1代表删除")
    private Integer deleteStatus;

    @ApiModelProperty(value = "创建者Id")
    private String createStaffId;

    @ApiModelProperty(value = "备注")
    private String remark;

    @Value("${company.role.admin-id}")
    private static String adminId = "1";

    public boolean isAdmin() {
        return isAdmin(this.id);
    }
    public static boolean isAdmin(String id) {
        return adminId.equals(id);
    }
}