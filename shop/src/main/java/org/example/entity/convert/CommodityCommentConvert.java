package org.example.entity.convert;

import org.example.entity.CommodityComment;
import org.example.entity.vo.CommodityCommentVo;
import org.example.util.Convert;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public abstract class CommodityCommentConvert implements Convert<CommodityComment, CommodityCommentVo> {
    @Override
    public abstract CommodityCommentVo convert(CommodityComment commodityComment);
    @Override
    public abstract List<CommodityCommentVo> convert(List<CommodityComment> commodityCommentList);

    @AfterMapping
    public void convert(CommodityComment commodityComment, @MappingTarget CommodityCommentVo commodityCommentVo) {
    }

    @AfterMapping
    public void convert(List<CommodityComment> commodityCommentList, @MappingTarget List<CommodityCommentVo> commodityCommentVoList) {
        commodityCommentVoList.forEach(v -> convert(null, v));
    }
}
