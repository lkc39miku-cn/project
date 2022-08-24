package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * 专辑
 * @TableName album
 */
@TableName(value ="album")
@Data
@ApiModel(value = "RoleMenu对象", description = "无")
public class Album implements Serializable {
    /**
     * id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 专辑名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 专辑封面
     */
    @TableField(value = "img")
    private String img;

    /**
     * 发行时间
     */
    @TableField(value = "time")
    private LocalDateTime time;

    /**
     * 专辑简介
     */
    @TableField(value = "details")
    private String details;

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