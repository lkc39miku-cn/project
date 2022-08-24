package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.time.LocalDateTime;


@ApiModel(value="员工")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Staff extends BaseEntity {
    @Serial
    private static final long serialVersionUID = -5211532043764110349L;

    @ApiModelProperty(value="员工账号")
    protected String username;

    @ApiModelProperty(value="员工昵称")
    protected String nickname;

    @ApiModelProperty(value="员工邮箱")
    protected String email;

    @ApiModelProperty(value="手机号码")
    protected String phone;

    @ApiModelProperty(value="员工性别 0男 1女 2未知")
    protected Integer sex;

    @ApiModelProperty(value="头像地址")
    protected String avatar;

    @ApiModelProperty(value="密码")
    protected String password;

    @ApiModelProperty(value="帐号状态 0正常 1停用")
    protected Integer status;

    @ApiModelProperty(value="删除标志 0代表存在 1代表删除")
    protected Integer deleteStatus;

    @ApiModelProperty(value="最后登录IP")
    protected String endLoginIp;

    @ApiModelProperty(value="最后登录时间")
    protected LocalDateTime endLoginTime;

    @ApiModelProperty(value="外键 部门")
    protected String deptId;

    @ApiModelProperty(value="创建者Id")
    protected String createStaffId;

    @ApiModelProperty(value="备注")
    protected String remark;

    @Value("${company.staff.admin-id}")
    private static String adminId = "1";

    public boolean isAdmin() {
        return isAdmin(this.id);
    }
    public static boolean isAdmin(String id) {
        return adminId.equals(id);
    }
}