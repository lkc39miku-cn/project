package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.entity.SeckillGoods;
import org.example.entity.SeckillOrderInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface SeckillOrderMapper extends BaseMapper<SeckillOrderInfo> {
}
