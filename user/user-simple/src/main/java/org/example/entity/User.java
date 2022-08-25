package org.example.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@TableName(value ="user")
@Data
@Accessors(chain = true)
@ApiModel(value = "用户表")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 7174154087368025294L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @TableField(value = "name")
    @ApiModelProperty(value = "用户名")
    private String name;

    @TableField(value = "account")
    @ApiModelProperty(value = "用户账号")
    private String account;

    @TableField(value = "password")
    @ApiModelProperty(value = "用户密码")
    private String password;

    @TableField(value = "phone")
    @ApiModelProperty(value = "用户手机号")
    private String phone;

    @TableField(value = "area")
    @ApiModelProperty(value = "用户地区")
    private String area;

    @TableField(value = "gender")
    @ApiModelProperty(value = "性别 0 男 1 女 2 未知")
    private Integer gender;

    @TableField(value = "birth")
    @ApiModelProperty(value = "生日")
    private LocalDateTime birth;

    @TableField(value = "photo")
    @ApiModelProperty(value = "用户头像")
    private String photo;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}