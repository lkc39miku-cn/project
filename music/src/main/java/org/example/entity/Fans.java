package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 粉丝关注表
 * @TableName fans
 */
@TableName(value ="fans")
@Data
public class Fans implements Serializable {
    /**
     * id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 类型，区分关注的是歌手还是用户
     */
    @TableField(value = "type")
    private String type;

    /**
     * 被关注者id,可能是歌手
     */
    @TableField(value = "focus_id")
    private String focusId;

    /**
     * 关注者id
     */
    @TableField(value = "fans_id")
    private String fansId;

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