package org.example.service.impl;

import org.example.entity.CommodityComment;
import org.example.mapper.CommodityCommentMapper;
import org.example.service.CommodityCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityCommentServiceImpl implements CommodityCommentService {
    @Autowired
    private CommodityCommentMapper commodityCommentMapper;

    @Override
    public List<CommodityComment> select() {
        return commodityCommentMapper.selectList(null);
    }

    @Override
    public int insert(CommodityComment commodityComment) {
        return commodityCommentMapper.insert(commodityComment);
    }

    @Override
    public int delete(String id) {
        return commodityCommentMapper.deleteById(id);
    }
}
