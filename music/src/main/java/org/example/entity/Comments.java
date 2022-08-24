package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;

@TableName(value ="comments")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Comments extends BaseEntity {

    @TableField(value = "to_user_id")
    @ApiModelProperty(value = "被回复者Id")
    private String toUserId;

    @TableField(value = "p_id")
    @ApiModelProperty(value = "父级Id")
    private String pId;

    @TableField(value = "details")
    @ApiModelProperty(value = "评论内容")
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