package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Dept;
import org.example.entity.Staff;
import org.example.entity.convert.DeptConvert;
import org.example.entity.vo.DeptVo;
import org.example.key.DeptKey;
import org.example.mapper.DeptMapper;
import org.example.mapper.StaffMapper;
import org.example.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private StaffMapper staffMapper;
    @Autowired
    private DeptConvert deptConvert;

    @Override
    public DeptVo selectByPrimaryKey(String id) {
        return deptConvert.convert(deptMapper.selectById(id));
    }

    @Override
    public List<DeptVo> selectAll() {
        return deptConvert.convert(deptMapper.selectList(null));
    }

    @Override
    public List<DeptVo> selectList(Dept dept) {
        return deptConvert.convert(deptMapper.selectList(new LambdaQueryWrapper<Dept>()
                .eq(Objects.nonNull(dept.getStatus()), Dept::getStatus, dept.getStatus())
                .eq(Objects.nonNull(dept.getDeleteStatus()), Dept::getDeleteStatus, dept.getDeleteStatus())));
    }

    @Override
    public List<DeptVo> tree(List<DeptVo> deptVoList) {
        List<DeptVo> tree = new ArrayList<>();
        deptVoList.forEach(v -> {
            if (v.getParentId().equals("0")) {
                tree.add(v);
            }
        });

        return convertTree(tree, deptVoList.stream().filter(v -> !v.getParentId().equals("0")).toList());
    }

    private List<DeptVo> convertTree(List<DeptVo> tree, List<DeptVo> deptVoList) {
        deptVoList.forEach(v -> {
            tree.forEach(t -> {
                if (t.getId().equals(v.getParentId())) {
                    if (t.getChildren() == null) {
                        t.setChildren(new ArrayList<>());
                    }
                    t.getChildren().add(v);
                    deptVoList.remove(v);
                }
            });
        });
        if (deptVoList.size() > 0) {
            convertTree(tree, deptVoList);
        }
        return tree;
    }

    @Override
    public List<DeptVo> roleTree(String roleId) {
        return null;
    }

    @Override
    public boolean checkDeptNameUnique(String name) {
        return Objects.nonNull(deptMapper.selectOne(new LambdaQueryWrapper<Dept>()
                .eq(Dept::getName, name)));
    }

    @Override
    public boolean checkDeptNameUnique(String name, String id) {
        return Objects.nonNull(deptMapper.selectOne(new LambdaQueryWrapper<Dept>()
                .eq(Dept::getName, name)
                .ne(Dept::getId, id)));
    }

    @Override
    public boolean selectOnlineChildrenByParentId(String id) {
        return deptMapper.selectList(new LambdaQueryWrapper<Dept>()
                .eq(Dept::getParentId, id)
                .eq(Dept::getStatus, DeptKey.IS_USED)).size() > 0;
    }

    @Override
    public boolean hasChildByParentId(String id) {
        return deptMapper.selectList(new LambdaQueryWrapper<Dept>()
                .eq(Dept::getParentId, id)).size() > 0;
    }

    @Override
    public boolean checkExistStaffByDeptId(String id) {
        return staffMapper.selectList(new LambdaQueryWrapper<Staff>()
                .eq(Staff::getDeptId, id)).size() > 0;
    }

    @Override
    public int insert(Dept dept) {
        return deptMapper.insert(dept);
    }

    @Override
    public int update(Dept dept) {
        return deptMapper.updateById(dept);
    }

    @Override
    public int delete(String id) {
        return deptMapper.updateById((Dept) new Dept()
                .setDeleteStatus(DeptKey.IS_DELETE)
                .setId(id));
    }
}
