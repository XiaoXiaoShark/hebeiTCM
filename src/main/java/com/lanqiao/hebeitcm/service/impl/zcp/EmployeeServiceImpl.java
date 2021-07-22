package com.lanqiao.hebeitcm.service.impl.zcp;

import com.github.pagehelper.Page;

import com.lanqiao.hebeitcm.mapper.zcp.EmployeeMapper;
import com.lanqiao.hebeitcm.model.zcp.Employee;
import com.lanqiao.hebeitcm.service.zcp.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("employeeService")
// 支持事务，增加、删除、更新操作单独使用 propagation = Propagation.REQUIRED
@Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public Page<Employee> select(Employee emp, int pageNum, int pageSize){
        return this.employeeMapper.select(emp, pageNum, pageSize);
    }

    @Override
    public Employee selectById(Integer empno) {
        return this.employeeMapper.selectById(empno);
    }

}
