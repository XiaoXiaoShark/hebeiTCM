package com.lanqiao.hebeitcm.yzy_CAR.service;

import com.lanqiao.hebeitcm.service.yzy_CAR.Sci_achiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author:YangZiYang
 * @create 2021/7/21 17:04
 */

@SpringBootTest

public class Sci_achiServiceTest {
    @Autowired
    Sci_achiService sci_achiService;

    @Test
    public void selectForAllTest() {
        List list = sci_achiService.selectForAll();
        System.out.println(list);
    }
}


