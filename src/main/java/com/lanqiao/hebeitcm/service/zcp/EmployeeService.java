package com.lanqiao.hebeitcm.service.zcp;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.model.zcp.Employee;


/**
*
*/
public interface EmployeeService  {

    public Page<Employee> select(Employee emp, int pageNum, int pageSize);

    public Employee selectById(Integer empno);


}
