package com.lanqiao.hebeitcm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages={"com.lanqiao.hebeitcm.mapper"}) // 扫描映射器接口
public class HebeiTcmApplication {

    public static void main(String[] args) {
        SpringApplication.run(HebeiTcmApplication.class, args);
    }

}
