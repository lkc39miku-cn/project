package org.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 歌单歌曲中间表
 * @TableName song_list
 */
@TableName(value ="song_list")
@Data
public class SongList implements Serializable {
    /**
     * id
     */
    @TableId(value = "id")
    private String id;

    /**
     * 歌单id
     */
    @TableField(value = "list_id")
    private String listId;

    /**
     * 歌曲id
     */
    @TableField(value = "song_id")
    private String songId;

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