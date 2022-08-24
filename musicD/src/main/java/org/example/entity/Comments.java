package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 评论表
 * @TableName comments
 */
@TableName(value ="comments")
@Data
public class Comments implements Serializable {
    /**
     * id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 回复给谁的id
     */
    @TableField(value = "to_user_id")
    private String toUserId;

    /**
     * 父级id
     */
    @TableField(value = "p_id")
    private String pId;

    /**
     * 评论内容
     */
    @TableField(value = "details")
    private String details;

    /**
     * 评论时间
     */
    @TableField(value = "time")
    private LocalDateTime time;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private String userId;

    /**
     * 评论类型 1,歌单2,专辑3,歌曲
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 目标id,可能是歌单id,专辑id,歌曲id
     */
    @TableField(value = "target_id")
    private String targetId;

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