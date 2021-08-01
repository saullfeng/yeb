package com.xxxx.server.controller;


import com.xxxx.server.pojo.EmployeeEc;

import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.service.IEmployeeEcService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author solfeng
 * @since 2021-07-07
 */
@RestController
@RequestMapping("/system/basic/employee-ec")
public class EmployeeEcController {
    @Autowired
    private IEmployeeEcService employeeEcService;

    @ApiOperation(value = "查询所有奖惩")
    @GetMapping("/")
    public List<EmployeeEc> getAllEmployeeEc(){
        return employeeEcService.list();
    }



    @ApiOperation(value = "添加奖惩")
    @PostMapping("/")
    public RespBean addEmployeeEc(@RequestBody EmployeeEc employeeEc){
        employeeEc.setEcDate(LocalDate.now());
        if (employeeEcService.save(employeeEc)){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }


    @ApiOperation(value = "修改奖惩")
    @PutMapping("/")
    public RespBean updateEmployeeEc(@RequestBody EmployeeEc employeeEc){
        System.out.println(employeeEc);
        if (employeeEcService.updateById(employeeEc)){
            return RespBean.success("修改成功");
        }
        return RespBean.error("修改失败");

    }

    @ApiOperation(value = "删除奖惩")
    @DeleteMapping("/{id}")
    public RespBean deleteEmployeeEc(@PathVariable Integer id){
        if (employeeEcService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @ApiOperation(value = "批量删除奖惩")
    @DeleteMapping("/")
    public RespBean deleteEmployeeEc(Integer[] ids){
        if (employeeEcService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }


}
