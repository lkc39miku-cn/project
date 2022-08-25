package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.constants.BaseEntity;

@TableName(value ="comments")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "评论")
public class Comments extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 3440604832542979343L;

    @TableField(value = "to_user_id")
    @ApiModelProperty(value = "被回复者Id")
    private String toUserId;

    @TableField(value = "p_id")
    @ApiModelProperty(value = "父级Id")
    private String pId;

    @TableField(value = "details")
    @ApiModelProperty(value = "评论内容")
    private String details;

    @TableField(value = "user_id")
    @ApiModelProperty(value = "评论者Id")
    private String userId;

    @TableField(value = "type")
    @ApiModelProperty(value = "评论类型 1 歌单 2 专辑 3 歌曲")
    private Integer type;

    @TableField(value = "target_id")
    @ApiModelProperty(value = "目标id 可能是歌单id 专辑id 歌曲id")
    private String targetId;
}