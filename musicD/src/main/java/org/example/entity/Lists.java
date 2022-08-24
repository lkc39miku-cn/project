package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 歌单
 * @TableName lists
 */
@TableName(value ="lists")
@Data
public class Lists implements Serializable {
    /**
     * 歌单id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 歌单标题
     */
    @TableField(value = "title")
    private String title;

    /**
     * 歌单封面
     */
    @TableField(value = "img")
    private String img;

    /**
     * 歌单简介
     */
    @TableField(value = "details")
    private String details;

    /**
     * 歌单点击量
     */
    @TableField(value = "play_num")
    private Integer playNum;

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