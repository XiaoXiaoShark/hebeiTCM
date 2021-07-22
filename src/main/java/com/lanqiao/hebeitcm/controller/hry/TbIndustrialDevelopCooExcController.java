package com.lanqiao.hebeitcm.controller.hry;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.model.hry.TbIndustrialDevelopCooExc;
import com.lanqiao.hebeitcm.service.hry.TbIndustrialDevelopCooExcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author 黄瑞颖
 * @create 2021-07-22 11:36
 */
@Controller
@RequestMapping("/cooExc")
public class TbIndustrialDevelopCooExcController {

    @Autowired
    private TbIndustrialDevelopCooExcService tbIndustrialDevelopCooExcService;

    // 查询
    @GetMapping
    public String selectCooExcForPage(Model model,
                                TbIndustrialDevelopCooExc tbIndustrialDevelopCooExc,
                                @RequestParam(value = "pageNum", required = false) Integer pageNum,
                                HttpSession session){
        if (pageNum == null) {
            // 提交查询表单
            pageNum = 1;
            // 保留当前的查询条件，供接下来点击分页链接时使用
            session.setAttribute("cooExcCondition", tbIndustrialDevelopCooExc);
        } else {
            // 点击分页链接时取回查询条件
            tbIndustrialDevelopCooExc = (TbIndustrialDevelopCooExc) session.getAttribute("cooExcCondition");
        }

        final Page<TbIndustrialDevelopCooExc> cooExcList = tbIndustrialDevelopCooExcService.select(tbIndustrialDevelopCooExc,pageNum,5);
        model.addAttribute("cooExcList",cooExcList);

        return "";
    }

    // 根据主键查询单条记录
    @GetMapping("/{itemID,itemCode}")
    public String selectCooExcByKey(Model model, @PathVariable Integer itemID, @PathVariable String itemCode){

        final TbIndustrialDevelopCooExc cooExc = tbIndustrialDevelopCooExcService.selectByPrimaryKey(itemID,itemCode);
        model.addAttribute("cooExc",cooExc);

        return "";
    }

     // 删除
    @DeleteMapping
    public String deleteCooExc(int itemID,String itemCode){

        final int number = tbIndustrialDevelopCooExcService.deleteByPrimaryKey(itemID,itemCode);

        return "";
    }

    // 添加
    @PutMapping
    public String addCooExc(TbIndustrialDevelopCooExc tbIndustrialDevelopCooExc){

        final int number = tbIndustrialDevelopCooExcService.insert(tbIndustrialDevelopCooExc);

        return "";
    }

    // 更新
    @PostMapping
    public String updateCooExc(TbIndustrialDevelopCooExc tbIndustrialDevelopCooExc){

        final int number = tbIndustrialDevelopCooExcService.update(tbIndustrialDevelopCooExc);

        return "";
    }


}
