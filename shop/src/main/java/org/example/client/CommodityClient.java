package org.example.client;

import org.example.client.error.CommodityClientError;
import org.example.entity.param.CommodityParam;
import org.example.entity.vo.CommodityVo;
import org.example.model.PageR;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient(name = "shop-backstage", value = "/commodity", fallback = CommodityClientError.class)
public interface CommodityClient {
    @GetMapping(value = "/select")
    PageR<List<CommodityVo>> select(CommodityParam commodityParam);
}
