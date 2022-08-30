package org.example.client.error;

import org.example.client.CommodityClient;
import org.example.entity.param.CommodityParam;
import org.example.entity.vo.CommodityVo;
import org.example.model.PageR;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommodityClientError implements CommodityClient {
    @Override
    public PageR<List<CommodityVo>> select(CommodityParam commodityParam) {
        return new PageR<List<CommodityVo>>().fail("查询商品接口异常");
    }
}
