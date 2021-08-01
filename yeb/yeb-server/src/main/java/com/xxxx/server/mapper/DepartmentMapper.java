package com.xxxx.server.mapper;

import com.xxxx.server.pojo.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author solfeng
 * @since 2021-07-07
 */
public interface DepartmentMapper extends BaseMapper<Department> {


    /**
     * 获取所有部门
     * @param parentId
     * @return
     */
    List<Department> getAllDepartmentsByParentId(Integer parentId);

    /**
     * 添加部门
     * @param dep
     */
    void addDep(Department dep);

    /**
     * 删除部门
     * @param dep
     */
    void deleteDep(Department dep);
}
