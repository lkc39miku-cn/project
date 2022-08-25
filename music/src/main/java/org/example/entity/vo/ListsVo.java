package org.example.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.entity.Lists;
import org.example.entity.Song;

import java.util.List;

@ApiModel(value="歌曲Vo")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(value = "handler")
public class ListsVo extends Lists {
  private   List<Song> songList;
}
