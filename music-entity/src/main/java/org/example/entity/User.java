package org.example.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

/**
* 用户表
* @TableName user
*/
@TableName(value ="user")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "前台用户")
public class User implements Serializable {

    /**
    * id
    */
    @NotBlank(message="[id]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("id")
    @Length(max= 255,message="编码长度不能超过255")
    private String id;
    /**
    * 用户名
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("用户名")
    @Length(max= 255,message="编码长度不能超过255")
    private String name;
    /**
    * 用户账号
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("用户账号")
    @Length(max= 255,message="编码长度不能超过255")
    private String account;
    /**
    * 用户密码
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("用户密码")
    @Length(max= 255,message="编码长度不能超过255")
    private String password;
    /**
    * 电话
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("电话")
    @Length(max= 255,message="编码长度不能超过255")
    private String phone;
    /**
    * 地区
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("地区")
    @Length(max= 255,message="编码长度不能超过255")
    private String area;
    /**
    * 简介
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("简介")
    @Length(max= 255,message="编码长度不能超过255")
    private String details;
    /**
    * 性别
    */
    @ApiModelProperty("性别")
    private Integer gender;
    /**
    * 生日
    */
    @ApiModelProperty("生日")
    private LocalDateTime birth;
    /**
    * 用户头像
    */
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("用户头像")
    @Length(max= 255,message="编码长度不能超过255")
    private String photo;
    /**
    * 创建时间
    */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
    /**
    * 更新时间
    */
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;


}
