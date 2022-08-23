package org.example.service;

import org.example.entity.Dept;
import org.example.entity.vo.DeptVo;

import java.util.List;

public interface DeptService {
    DeptVo selectByPrimaryKey(String id);

    List<DeptVo> selectAll();

    List<DeptVo> selectList(Dept dept);

    List<DeptVo> tree(List<DeptVo> deptVoList);

    List<DeptVo> roleTree(String roleId);

    boolean checkDeptNameUnique(String name);

    boolean checkDeptNameUnique(String name, String id);

    boolean selectOnlineChildrenByParentId(String id);

    boolean hasChildByParentId(String id);

    boolean checkExistStaffByDeptId(String id);

    int insert(Dept dept);

    int update(Dept dept);

    int delete(String id);
}
