package com.lanqiao.hebeitcm.controller.hry;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.model.hry.TbIndustrialDevelopTalRec;
import com.lanqiao.hebeitcm.service.hry.TbIndustrialDevelopTalRecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author 黄瑞颖
 * @create 2021-07-22 14:37
 */
@Controller
@RequestMapping("/talRec")
public class TbIndustrialDevelopTalRecController {

    @Autowired
    private TbIndustrialDevelopTalRecService tbIndustrialDevelopTalRecService;

    // 查询
    @GetMapping
    public String selectForPage(Model model,
                                TbIndustrialDevelopTalRec talRec,
                                @RequestParam(value = "pageNum", required = false) Integer pageNum,
                                HttpSession session){
        if (pageNum == null) {
            // 提交查询表单
            pageNum = 1;
            // 保留当前的查询条件，供接下来点击分页链接时使用
            session.setAttribute("talRecCondition", talRec);
        } else {
            // 点击分页链接时取回查询条件
            talRec = (TbIndustrialDevelopTalRec) session.getAttribute("talRecCondition");
        }

        final Page<TbIndustrialDevelopTalRec> talRecList = tbIndustrialDevelopTalRecService.select(talRec,pageNum,5);
        model.addAttribute("talRecList",talRecList);

        return "";
    }

    // 根据主键查询单条记录
    @GetMapping("/{itemID,itemCode}")
    public String selectCooExcByKey(Model model, @PathVariable Integer itemID, @PathVariable String itemCode){

        final TbIndustrialDevelopTalRec talRec = tbIndustrialDevelopTalRecService.selectByPrimaryKey(itemID,itemCode);
        model.addAttribute("talRec",talRec);

        return "";
    }

    // 删除
    @DeleteMapping
    public String deleteCooExc(int itemID,String itemCode){

        final int number = tbIndustrialDevelopTalRecService.deleteByPrimaryKey(itemID,itemCode);

        return "";
    }

    // 添加
    @PutMapping
    public String addCooExc(TbIndustrialDevelopTalRec talRec){

        final int number = tbIndustrialDevelopTalRecService.insert(talRec);

        return "";
    }

    // 更新
    @PostMapping
    public String updateCooExc(TbIndustrialDevelopTalRec talRec){

        final int number = tbIndustrialDevelopTalRecService.updateByPrimaryKey(talRec);

        return "";
    }
}
