package com.lanqiao.hebeitcm.controller.hry;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.model.hry.TecServiceInfo;
import com.lanqiao.hebeitcm.service.hry.TecServiceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author 黄瑞颖
 * @create 2021-07-21 15:25
 */
@Controller
@RequestMapping("/tecServiceInfo")
public class TecServiceInfoController {
    @Autowired
    private TecServiceInfoService tecServiceInfoService;

    // 查询
    @GetMapping
    public String selectForPage(Model model,
                                TecServiceInfo tecServiceInfo,
                                @RequestParam(value = "pageNum", required = false) Integer pageNum,
                                HttpSession session){
        if (pageNum == null) {
            // 提交查询表单
            pageNum = 1;
            // 保留当前的查询条件，供接下来点击分页链接时使用
            session.setAttribute("tecServiceInfoCondition", tecServiceInfo);
        } else {
            // 点击分页链接时取回查询条件
            tecServiceInfo = (TecServiceInfo) session.getAttribute("tecServiceInfoCondition");
        }

        final Page<TecServiceInfo> tecServiceInfoList = this.tecServiceInfoService.select(tecServiceInfo,pageNum,5);
        model.addAttribute("tecServiceInfoList", tecServiceInfoList);
        return "tecServiceInfo/list";

    }

    // 根据ID查询单条信息
    @GetMapping("/{itemID,itemCode}")
    public String selectByItemId(Model model, @PathVariable Integer itemID,@PathVariable String itemCode){

        final TecServiceInfo tecServiceInfo = this.tecServiceInfoService.selectByItemID(itemID,itemCode);
        model.addAttribute("tecServiceInfo",tecServiceInfo);
        return "/tecServiceInfo/tecServiceInfo_update";
    }

    // 添加
    @PutMapping
    public String add(TecServiceInfo tecServiceInfo){
        final int number = this.tecServiceInfoService.addTecServiceInfo(tecServiceInfo);
        return "redirect:/tecServiceInfo";
    }

    // 删除
    @DeleteMapping
    public String delete(int itemID,String itemCode){
        final int number = this.tecServiceInfoService.deleteTecServiceInfo(itemID,itemCode);
        return "redirect:/tecServiceInfo";

    }

    // 更新
    @PostMapping
    public String update(TecServiceInfo tecServiceInfo){
        final int number = this.tecServiceInfoService.updateTecServiceInfo(tecServiceInfo);
        return "redirect:/tecServiceInfo";
    }

}
