package org.example.client;

import org.example.client.error.CommodityClientError;
import org.example.config.FeignInterceptor;
import org.example.entity.param.CommodityParam;
import org.example.entity.vo.CommodityVo;
import org.example.model.PageR;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "shop-backstage", path = "/shop-backstage/commodity", fallback = CommodityClientError.class
, configuration = FeignInterceptor.class)
public interface CommodityClient {
    @GetMapping(value = "/select")
    PageR<List<CommodityVo>> select(@RequestParam CommodityParam commodityParam);
}
