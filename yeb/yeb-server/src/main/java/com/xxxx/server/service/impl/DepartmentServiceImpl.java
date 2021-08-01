package com.xxxx.server.service.impl;

import com.xxxx.server.pojo.Department;
import com.xxxx.server.mapper.DepartmentMapper;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author solfeng
 * @since 2021-07-07
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
    /**
     * 获取所有部门
     * @return
     */
    @Override
    public List<Department> getAllDepartments() {
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }

    /**
     * 添加部门
     * @param dep
     * @return
     */
    @Override
    public RespBean addDep(Department dep) {
       dep.setEnabled(true);
       departmentMapper.addDep(dep);
       if (1== dep.getResult()){
           return RespBean.success("添加成功");
       }
       return RespBean.error("添加失败");
    }

    @Override
    public RespBean deleteDep(Integer id) {
        Department department = new Department();
        department.setId(id);
        departmentMapper.deleteDep(department);

        if (-2 == department.getResult()){
            return RespBean.error("该部门下有子部门，删除失败！");
        }
        if (-1 == department.getResult()){
            return RespBean.error("该部门下有员工，删除失败！");
        }
        if (1 == department.getResult()){
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败");
    }
}
