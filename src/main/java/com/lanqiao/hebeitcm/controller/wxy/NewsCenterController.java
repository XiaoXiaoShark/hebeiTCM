package com.lanqiao.hebeitcm.controller.wxy;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.model.wxy.DataInformation;
import com.lanqiao.hebeitcm.service.wxy.NewsCenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 森木
 * @date 2021/7/22 11:00
 */
@Controller
@RequestMapping("/newscenter")
@Slf4j
public class NewsCenterController {

    @Autowired
    NewsCenterService newsCenterService;

    @GetMapping
    public String selectForPage(Model model) {
        final List<DataInformation> dataList = this.newsCenterService.selectByDataType("新闻");
        model.addAttribute("dataList", dataList);
        return "wxy/list";
    }

}
