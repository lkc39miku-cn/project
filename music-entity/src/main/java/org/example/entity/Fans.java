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

@TableName(value ="fans")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "粉丝关注表")
public class Fans extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 2249486902203266170L;

    @TableField(value = "type")
    @ApiModelProperty(value = "类型 区分关注的是歌手还是用户")
    private Integer type;

    @TableField(value = "focus_id")
    @ApiModelProperty(value = "被关注者id 可能是歌手")
    private String focusId;

    @TableField(value = "fans_id")
    @ApiModelProperty(value = "关注者id")
    private String fansId;
}