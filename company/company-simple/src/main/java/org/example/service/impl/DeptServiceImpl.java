package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Dept;
import org.example.entity.Role;
import org.example.entity.Staff;
import org.example.entity.convert.DeptConvert;
import org.example.entity.vo.DeptVo;
import org.example.key.DeptKey;
import org.example.mapper.DeptMapper;
import org.example.mapper.RoleMapper;
import org.example.mapper.StaffMapper;
import org.example.service.DeptService;
import org.example.util.RedisCache;
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
    private RoleMapper roleMapper;
    @Autowired
    private DeptConvert deptConvert;
    @Autowired
    private RedisCache redisCache;

    @Override
    public DeptVo selectByPrimaryKey(String id) {
        DeptVo deptVo = deptConvert.convert(deptMapper.selectById(id));
        redisCache.setCacheObject(DeptKey.REDIS_SELECT_ID_KEY + id, deptVo);
        if (deptVo == null) {
            redisCache.expire(DeptKey.REDIS_SELECT_ID_KEY + id, 60 * 5);
        }
        return deptVo;
    }

    @Override
    public List<DeptVo> selectAll() {
        List<Dept> deptList = deptMapper.selectList(null);
        List<DeptVo> deptVos = deptConvert.convert(deptList);
        redisCache.setCacheList(DeptKey.REDIS_SELECT_ALL, deptVos);
        if (deptList.size() == 0) {
            redisCache.expire(DeptKey.REDIS_SELECT_ALL, 60 * 5);
        }
        return deptVos;
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
            if ("0".equals(v.getParentId())) {
                tree.add(v);
            }
        });

        return convertTree(tree, deptVoList.stream().filter(v -> !"0".equals(v.getParentId())).toList());
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
        Role role = roleMapper.selectById(roleId);
        List<String> list = deptMapper.roleTree(role.getId(), role.isDeptCheckStrictly());
        List<DeptVo> deptList = selectList(new Dept().setStatus(DeptKey.IS_USED).setDeleteStatus(DeptKey.IS_NOT_DELETE));

        List<DeptVo> tree = new ArrayList<>();
        deptList.forEach(v -> {
            if ("0".equals(v.getParentId())) {
                tree.add(v);
            }
        });
        List<DeptVo> convertTree = convertTree(tree, deptList.stream().filter(v -> !"0".equals(v.getParentId())).toList());

        return checkStatus(convertTree, list);
    }

    private List<DeptVo> checkStatus(List<DeptVo> tree, List<String> list) {
        tree.forEach(v -> {
            if (list.contains(v.getId())) {
                v.setChecked(true);
                list.remove(v.getId());
            }
            if (v.getChildren() != null) {
                checkStatus(v.getChildren(), list);
            }
        });
        return tree;
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
