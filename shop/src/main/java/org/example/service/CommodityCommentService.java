package org.example.service;


import org.example.entity.CommodityComment;

import java.util.List;

public interface CommodityCommentService {
    List<CommodityComment> select();

    int insert(CommodityComment commodityComment);

    int delete(String id);
}
