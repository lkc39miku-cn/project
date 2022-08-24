package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 歌曲表
 * @TableName song
 */
@TableName(value ="song")
@Data
public class Song implements Serializable {
    /**
     * 歌曲id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 歌曲名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 歌手Id
     */
    @TableField(value = "singer")
    private String singer;

    /**
     * 歌曲图片
     */
    @TableField(value = "img")
    private String img;

    /**
     * 歌曲文件路径
     */
    @TableField(value = "file_path")
    private LocalDateTime filePath;

    /**
     * 专辑Id
     */
    @TableField(value = "album")
    private String album;

    /**
     * 歌词
     */
    @TableField(value = "lyc")
    private String lyc;

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