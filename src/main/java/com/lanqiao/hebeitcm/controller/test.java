package com.lanqiao.hebeitcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 黄瑞颖
 * @create 2021-07-21 11:10
 */
@Controller
public class test {
    // 测试用，可以删掉
    @GetMapping("/")
    public String index(){
        return "Industrial_development/Industrial_development";
    }

}
