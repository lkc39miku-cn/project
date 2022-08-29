package org.example.service.impl;

import org.example.CommodityCommentService;
import org.example.mapper.CommodityCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommodityCommentServiceImpl implements CommodityCommentService {
    @Autowired
    private CommodityCommentMapper commodityCommentMapper;
}
