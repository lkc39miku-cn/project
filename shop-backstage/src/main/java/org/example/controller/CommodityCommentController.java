package org.example.controller;

import org.example.CommodityCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/commodity/comment")
public class CommodityCommentController {
    @Autowired
    private CommodityCommentService commodityCommentService;
}
