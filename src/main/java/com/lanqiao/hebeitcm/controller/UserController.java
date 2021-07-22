package com.lanqiao.hebeitcm.controller;

import com.lanqiao.hebeitcm.model.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author : 小小shark
 * @ClassName UserController
 * @date : 2021-07-21 11:38
 * @Description TODO
 **/
@Controller
public class UserController {
    @RequestMapping(path = "/index")
    public String getIndexPage(Model model) {
        // 认证成功后,结果user信息会通过SecurityContextHolder存入SecurityContext中.
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj instanceof User) {
            model.addAttribute("loginUser", obj);
        }
        return "/index";
    }

    @RequestMapping(path = "/discuss")
    public String getDiscussPage() {
        return "/site/discuss";
    }

    @RequestMapping(path = "/letter")
    public String getLetterPage() {
        return "/site/letter";
    }

    @RequestMapping(path = "/admin")
    public String getAdminPage() {
        return "/site/admin";
    }

    @RequestMapping(path = "/loginpage")
    public String getLoginPage() {
        return "/site/login";
    }

    // 拒绝访问时的提示页面
    @RequestMapping(path = "/denied")
    public String getDeniedPage() {
        return "/error/404";
    }

}
