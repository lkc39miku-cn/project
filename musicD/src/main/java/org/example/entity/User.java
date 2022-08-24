package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 用户表
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 用户名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 用户账号
     */
    @TableField(value = "account")
    private String account;

    /**
     * 用户密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 电话
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 地区
     */
    @TableField(value = "area")
    private String area;

    /**
     * 简介
     */
    @TableField(value = "details")
    private String details;

    /**
     * 性别
     */
    @TableField(value = "gender")
    private Integer gender;

    /**
     * 生日
     */
    @TableField(value = "birth")
    private LocalDateTime birth;

    /**
     * 用户头像
     */
    @TableField(value = "photo")
    private String photo;

    /**
     * 创建人
     */
    @TableField(value = "create_staff_id")
    private String createStaffId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}