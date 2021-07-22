package com.lanqiao.hebeitcm.controller.zcp;


import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.model.zcp.Employee;
import com.lanqiao.hebeitcm.service.zcp.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/emps")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String selectForPage(Model model,
                                Employee emp,
                                @RequestParam(value = "pageNum", required = false) Integer pageNum,
                                HttpSession session) {
        if (pageNum == null) {
            // 提交查询表单
            pageNum = 1;
            // 保留当前的查询条件，供接下来点击分页链接时使用
            session.setAttribute("empCondition", emp);
        } else {
            // 点击分页链接时取回查询条件
            emp = (Employee)session.getAttribute("empCondition");
        }
        final Page<Employee> employeeList = this.employeeService.select(emp, pageNum,5);
        model.addAttribute("employeeList", employeeList);
        return "employee/list";
    }


    // 同步
    @GetMapping("/{empno}")
    public String selectById(Model model,
                             @PathVariable Integer empno) {
        final Employee employee = this.employeeService.selectById(empno);
        model.addAttribute("emp", employee);
        return "employee/emp_update";
    }

    // 异步
    @GetMapping("/async/{empno}")
    public String selectByIdForAsync(Model model,
                             @PathVariable Integer empno) {
        final Employee employee = this.employeeService.selectById(empno);
        model.addAttribute("emp", employee);
        return "employee/emp_update-content";
    }


   @PostMapping
   public String update(Model model, Employee employee) {
        // 后面操作数据库代码省略
        return "redirect:/emps";
    }


}
