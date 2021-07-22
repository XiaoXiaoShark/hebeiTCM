package com.lanqiao.hebeitcm.mapper.zcp;


import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.model.zcp.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface EmployeeMapper {

    public Page<Employee> select(@Param("emp") Employee emp,
                                 @Param("pageNum") int pageNum,
                                 @Param("pageSize")int pageSize);

    public Employee selectById(Integer empno);
}
