package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 歌手
 * @TableName singer
 */
@TableName(value ="singer")
@Data
public class Singer implements Serializable {
    /**
     * 歌手id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 歌手名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 歌手头像
     */
    @TableField(value = "photo")
    private String photo;

    /**
     * 歌手简介
     */
    @TableField(value = "details")
    private String details;

    /**
     * 创建人id
     */
    @TableField(value = "create_staff_id")
    private Integer createStaffId;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private String createTime;

    /**
     * 备注
     */
    @TableField(value = "remark")
    private String remark;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}