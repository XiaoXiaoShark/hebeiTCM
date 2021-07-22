package com.lanqiao.hebeitcm.service;

import com.lanqiao.hebeitcm.model.hry.TbIndustrialDevelopTalRec;
import com.lanqiao.hebeitcm.service.hry.TbIndustrialDevelopTalRecService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.UUID;

/**
 * @author 黄瑞颖
 * @create 2021-07-22 15:12
 */
@SpringBootTest
public class TbIndustrialDevelopTalRecTest {
    @Autowired
    private TbIndustrialDevelopTalRecService tbIndustrialDevelopTalRecService;

    @Test
    public void selectTest(){
        tbIndustrialDevelopTalRecService.select(new TbIndustrialDevelopTalRec(),1,5);
    }

    @Test
    public void insertTest(){
        TbIndustrialDevelopTalRec talRec = new TbIndustrialDevelopTalRec();
        String uuid = UUID.randomUUID().toString();

        talRec.setItemcode(uuid);
        talRec.setWorkplace("桂林");
        talRec.setRecruitmentCount("3人");
        talRec.setPostDuty("孰悉电池组装制程; 参与电化学储能电站的设计开发；");
        talRec.setPostDescr("熟练使用各种电化学测试仪器，如电化学工作台、内阻测试仪、电池充放电设备，频化成设备，及其它分析仪器等；");
        talRec.setSalary("参照市场化水平面议");
        talRec.setStatus("1");
        talRec.setCreater("黄瑞颖");
        talRec.setItemcreateat(new Date());
        talRec.setUpdater("黄瑞颖");
        talRec.setItemupdateat(new Date());
        talRec.setRecruitmentTitle("固体发酵和半仿生-生物酶技术用于中药药效物质提取的研究项目招聘需求");
        talRec.setRecruitmentPosition("研究助理");
        talRec.setEducation("大学及以上");
        talRec.setEmali("qinyan2020@qq.com");
        talRec.setOrgCode("44");
        talRec.setVisitNum(0);

        System.out.println(tbIndustrialDevelopTalRecService.insert(talRec));

    }

    @Test
    public void updateTest(){
        TbIndustrialDevelopTalRec talRec = tbIndustrialDevelopTalRecService.selectByPrimaryKey(4,"5eaeae24-0938-4cae-9140-f4faf68f25e4");

        talRec.setCreater("李四");
        talRec.setUpdater("张三");

        tbIndustrialDevelopTalRecService.updateByPrimaryKey(talRec);
    }

    @Test
    public void deleteTest(){
        tbIndustrialDevelopTalRecService.deleteByPrimaryKey(4,"5eaeae24-0938-4cae-9140-f4faf68f25e4");
    }
}
