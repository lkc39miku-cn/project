package org.example.service.impl;

import org.example.entity.CommodityType;
import org.example.entity.convert.CommodityTypeConvert;
import org.example.entity.vo.CommodityTypeVo;
import org.example.mapper.CommodityTypeMapper;
import org.example.service.CommodityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommodityTypeServiceImpl implements CommodityTypeService {
    @Autowired
    private CommodityTypeMapper commodityTypeMapper;
    @Autowired
    private CommodityTypeConvert commodityTypeConvert;

    @Override
    public List<CommodityTypeVo> selectList() {
        return commodityTypeConvert.convert(commodityTypeMapper.selectList(null));
    }

    @Override
    public List<CommodityTypeVo> tree(List<CommodityTypeVo> commodityTypeVoList) {
        List<CommodityTypeVo> tree = new ArrayList<>();
        commodityTypeVoList.forEach(v -> {
            if ("0".equals(v.getParentId())) {
                tree.add(v);
            }
        });

        return convertTree(tree, commodityTypeVoList.stream().filter(v -> !"0".equals(v.getParentId())).toList());
    }

    private List<CommodityTypeVo> convertTree(List<CommodityTypeVo> tree, List<CommodityTypeVo> commodityTypeVoList) {
        commodityTypeVoList.forEach(v -> {
            tree.forEach(t -> {
                if (t.getId().equals(v.getParentId())) {
                    if (t.getChildren() == null) {
                        t.setChildren(new ArrayList<>());
                    }
                    t.getChildren().add(v);
                    commodityTypeVoList.remove(v);
                }
            });
        });
        if (commodityTypeVoList.size() > 0) {
            convertTree(tree, commodityTypeVoList);
        }
        return tree;
    }

    @Override
    public int insert(CommodityType commodityType) {
        return commodityTypeMapper.insert(commodityType);
    }

    @Override
    public int update(CommodityType commodityType) {
        return commodityTypeMapper.updateById(commodityType);
    }

    @Override
    public int delete(String id) {
        return commodityTypeMapper.deleteById(id);
    }
}
