package org.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.experimental.Accessors;
import org.example.model.R;
import org.example.util.RedisCache;
import org.example.util.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Api(tags = "购物车")
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private RedisCache redisCache;

    @Data
    @Accessors(chain = true)
    static class Cart {
        private String commodityId;
        private Integer number;
    }

    @ApiOperation("查询")
    @GetMapping("/select")
    public R<List<Cart>> select() {
        return new R<List<Cart>>()
                .ok(redisCache.getCacheList("user:cart:" + UserThreadLocal.getUser().getId()));
    }

    @ApiOperation("添加")
    @PostMapping(value = "/insert")
    public R<String> addCart(Cart cart) {
        List<Cart> cacheList = Objects.nonNull(redisCache.getCacheList("user:cart:" + UserThreadLocal.getUser().getId())) ?
                redisCache.getCacheList("user:cart:" + UserThreadLocal.getUser().getId()) : new ArrayList<>();

        cacheList.add(cart);
        redisCache.setCacheList("user:cart:" + UserThreadLocal.getUser().getId(), cacheList);
        return new R<String>()
                .ok();
    }

    @DeleteMapping("/delete")
    @ApiOperation("删除")
    public R<String> deleteCart(List<String> commodityList, String commodityId) {
        List<Cart> cacheList = redisCache.getCacheList("user:cart:" + UserThreadLocal.getUser().getId());
        List<Cart> carts;
        if (commodityList.isEmpty()) {
            carts = cacheList.stream().filter(v -> !v.commodityId.equals(commodityId)).toList();
        } else {
            carts = cacheList.stream().filter(v -> !commodityList.contains(v.getCommodityId())).toList();
        }
        redisCache.setCacheList("user:cart:" + UserThreadLocal.getUser().getId(), carts);
        return new R<String>()
                .ok();
    }

    @PutMapping("/update")
    @ApiOperation("更新")
    public R<String> updateCart(Cart cart) {
        List<Cart> cacheList = redisCache.getCacheList("user:cart:" + UserThreadLocal.getUser().getId());
        cacheList.forEach(v -> {
            if (v.getCommodityId().equals(cart.getCommodityId())) {
                v.setNumber(cart.getNumber());
                return;
            }
        });
        redisCache.setCacheList("user:cart:" + UserThreadLocal.getUser().getId(), cacheList);
        return new R<String>()
                .ok();
    }
}
