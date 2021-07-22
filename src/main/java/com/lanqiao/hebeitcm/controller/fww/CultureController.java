package com.lanqiao.hebeitcm.controller.fww;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.model.fww.culturals;
import com.lanqiao.hebeitcm.service.fww.CultureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/")
public class CultureController {

    @Autowired
    CultureService cultureService;
    
    @GetMapping
    public String selectAllFilms(){
        List<culturals> culturals = this.cultureService.selectAllFilms();
        if(culturals!=null){
            return "culture/culture";
        }
        return "";
    }
}
