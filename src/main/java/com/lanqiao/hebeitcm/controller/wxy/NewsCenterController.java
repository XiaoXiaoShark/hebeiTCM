package com.lanqiao.hebeitcm.controller.wxy;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanqiao.hebeitcm.model.wxy.DataInformation;
import com.lanqiao.hebeitcm.service.wxy.NewsCenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String selectForPage(Model model,
                                @RequestParam(value = "pageNum", required = false)Integer pageNum) {
        if(pageNum == null){
            pageNum=1;
        }
        final Page<DataInformation> dataList = this.newsCenterService.selectByDataType(pageNum,5,"新闻");
        model.addAttribute("dataList", dataList);
        return "wxy/newscenter_list";
    }

    @GetMapping("/{itemID}")
    public String newsDetails(Model model,
                              @PathVariable Integer itemID){
        final DataInformation data = this.newsCenterService.dataDetails(itemID);
        this.newsCenterService.updateVisit(1,itemID);
        model.addAttribute("data",data);
        return "wxy/newscenter_details";
    }

}
