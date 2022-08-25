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

@TableName(value ="singer")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "歌手")
public class Singer extends BaseEntity {
    @Serial
    private static final long serialVersionUID = -3186729666133760637L;

    @TableField(value = "name")
    @ApiModelProperty(value = "歌手名称")
    private String name;

    @TableField(value = "photo")
    @ApiModelProperty(value = "歌手头像路径")
    private String photo;

    @TableField(value = "details")
    @ApiModelProperty(value = "歌手简介")
    private String details;

    @TableField(value = "user_id")
    @ApiModelProperty(value = "关联用户id")
    private String userId;

    @TableField(value = "remark")
    @ApiModelProperty(value = "备注")
    private String remark;
}