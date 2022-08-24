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
import org.example.constants.BaseEntity;

@TableName(value ="album")
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "专辑")
public class Album extends BaseEntity {
    @Serial
    private static final long serialVersionUID = -149802188336127684L;

    @TableField(value = "name")
    @ApiModelProperty(value = "专辑名称")
    private String name;

    @TableField(value = "img")
    @ApiModelProperty(value = "专辑图片")
    private String img;

    @TableField(value = "time")
    @ApiModelProperty(value = "专辑时间")
    private LocalDateTime time;

    @TableField(value = "details")
    @ApiModelProperty(value = "专辑详情")
    private String details;

    @TableField(value = "create_staff_id")
    @ApiModelProperty(value = "创建人id")
    private String createStaffId;

    @TableField(value = "remark")
    @ApiModelProperty(value = "备注")
    private String remark;
}