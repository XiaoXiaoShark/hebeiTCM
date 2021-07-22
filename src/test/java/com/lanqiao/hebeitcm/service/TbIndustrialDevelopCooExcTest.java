package com.lanqiao.hebeitcm.service;

import com.github.pagehelper.Page;
import com.lanqiao.hebeitcm.model.hry.TbIndustrialDevelopCooExc;
import com.lanqiao.hebeitcm.service.hry.TbIndustrialDevelopCooExcService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

/**
 * @author 黄瑞颖
 * @create 2021-07-22 12:13
 */
@SpringBootTest
public class TbIndustrialDevelopCooExcTest {

    @Autowired
    private TbIndustrialDevelopCooExcService tbIService;

    @Test
    public void selectTest(){

        Page<TbIndustrialDevelopCooExc> select = tbIService.select(new TbIndustrialDevelopCooExc(), 1, 5);
    }

    @Test
    public void insertTest(){

        TbIndustrialDevelopCooExc cooExc = new TbIndustrialDevelopCooExc();
        String uuid = UUID.randomUUID().toString();

        cooExc.setItemcode(uuid);
        cooExc.setCooperationExchangeName("川产紫杉醇及其注射液的新药研究");
        cooExc.setCooperationExchangeLeader("黄瑞颖");
        cooExc.setVisitNum(0);
        cooExc.setProjectIntroduce("川产紫杉醇及其注射液的新药研究(获四川省科学技术进步一等奖) ◎ 中药抗内毒素作用——中医解毒法实质研究(获四川省科学技术进步一等奖) ◎它们通过外源性感染和肠道系统内源性转位两种途径进入血液循环导致内毒素血症，是机体致病的重要毒力.");
        cooExc.setContacts("小黄");
        cooExc.setPhone("123456789");
        cooExc.setCooperativeOrg("广西");
        cooExc.setStatus("1");
        cooExc.setCreater("黄瑞颖");
        cooExc.setItemcreateat(new Date());
        cooExc.setUpdater("黄瑞颖");
        cooExc.setItemupdateat(new Date());
        cooExc.setOrgCode("44");

        tbIService.insert(cooExc);
    }

    @Test
    public void deleteTest(){

        System.out.println(tbIService.deleteByPrimaryKey(5, "22d88c1e-1622-42ea-aced-deccec62aa07"));
    }

    @Test void updateTest(){

        TbIndustrialDevelopCooExc cooExc ;

        cooExc=tbIService.selectByPrimaryKey(4,"faa0b9f9-504d-42e4-bcd8-1c43606fa300");

        cooExc.setCreater("张三");
        cooExc.setUpdater("李四");

        System.out.println(tbIService.update(cooExc));
    }

}
