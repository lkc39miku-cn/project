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

@TableName(value ="lists")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value = "歌单")
public class Lists extends BaseEntity {

    @Serial
    private static final long serialVersionUID = -3739340803061506914L;

    @TableField(value = "title")
    @ApiModelProperty(value = "歌单标题")
    private String title;

    @TableField(value = "img")
    @ApiModelProperty(value = "歌单封面")
    private String img;

    @TableField(value = "details")
    @ApiModelProperty(value = "歌单简介")
    private String details;

    @TableField(value = "play_num")
    @ApiModelProperty(value = "歌单点击量")
    private Integer playNum;

    @TableField(value = "create_user_id")
    @ApiModelProperty(value = "创建人id")
    private String createUserId;

    @TableField(value = "remark")
    @ApiModelProperty(value = "备注")
    private String remark;
}