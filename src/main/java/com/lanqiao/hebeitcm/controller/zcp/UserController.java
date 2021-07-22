package com.lanqiao.hebeitcm.controller.zcp;


import com.lanqiao.hebeitcm.model.zcp.Users;
import com.lanqiao.hebeitcm.service.zcp.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller //组合了@Controller 和 @ResponseBody注解，所有都异步处理方法，响应的都是json
@SessionAttributes({"logUser"})
@Slf4j
public class UserController {

    @Autowired
    UsersService usersService;

    // Restful 风格API的设计其实是一种架构风格
    @GetMapping("/") // @PutMapping, @PostMapping, @DeleteMapping
    public String index() {
        return "user/login"; // templates/login.html
    }


    @RequestMapping("/user/login")
    public String login(Users user, Model model) {
        log.info(user.toString());

        final Users logUser = this.usersService.selectForLogin(user);
        if (logUser != null) {
            model.addAttribute("logUser", logUser);
            return "redirect:/emps"; // 重定向只可以定向到控制器，不可定向到模板页面

        } else {
            return "user/login";
        }
    }

}
