package org.example.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@ApiModel(value = "用户表")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 7174154087368025294L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    protected String id;

    @TableField(value = "name")
    @ApiModelProperty(value = "用户名")
    protected String name;

    @TableField(value = "account")
    @ApiModelProperty(value = "用户账号")
    protected String account;

    @TableField(value = "password")
    @ApiModelProperty(value = "用户密码")
    protected String password;

    @TableField(value = "phone")
    @ApiModelProperty(value = "用户手机号")
    protected String phone;

    @TableField(value = "area")
    @ApiModelProperty(value = "用户地区")
    protected String area;

    @TableField(value = "gender")
    @ApiModelProperty(value = "性别 0 男 1 女 2 未知")
    protected Integer gender;

    @TableField(value = "birth")
    @ApiModelProperty(value = "生日")
    protected LocalDateTime birth;

    @TableField(value = "photo")
    @ApiModelProperty(value = "用户头像")
    protected String photo;

    @ApiModelProperty(value = "禁用状态 0 启用 1 禁用")
    @TableField(value = "status")
    protected Integer status;

    @ApiModelProperty(value = "删除状态 0 未删除 1 已删除")
    @TableField(value = "delete_status")
    protected Integer deleteStatus;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    protected LocalDateTime createTime;
}