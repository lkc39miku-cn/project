package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.checkerframework.checker.units.qual.A;
import org.example.entity.CommodityBrand;
import org.example.entity.CommodityComment;
import org.example.entity.convert.CommodityCommentConvert;
import org.example.entity.vo.CommodityBrandVo;
import org.example.entity.vo.CommodityCommentVo;
import org.example.model.R;
import org.example.result.CompareExecute;
import org.example.service.CommodityCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Api(value = "评论")
@RestController
@RequestMapping(value = "/commodity/comment")
public class CommodityCommentController {
    @Autowired
    private CommodityCommentService commodityCommentService;
    @Autowired
    private CommodityCommentConvert commodityCommentConvert;

    @ApiOperation(value = "查询所有评论数据")
    @GetMapping(value = "/select")
    public R<List<CommodityCommentVo>> select(){
        return new R<List<CommodityCommentVo>>()
                .ok(commodityCommentConvert.convert(commodityCommentService.select()));
    }

    @ApiOperation(value = "新增评论")
    @PostMapping("/insert")
    public R<String> insert(@RequestBody CommodityComment commodityComment){
        return new CompareExecute<>().compare(commodityCommentService.insert(commodityComment),CompareExecute.ExecuteStatus.INSERT);
    }


    @ApiOperation(value = "删除评论")
    @DeleteMapping("/delete{id}")
    private R<String> delete(@PathVariable("id") String id){
        return new CompareExecute<>().compare(commodityCommentService.delete(id),CompareExecute.ExecuteStatus.DELETE);
    }




}
