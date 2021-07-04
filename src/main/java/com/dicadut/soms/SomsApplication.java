package com.dicadut.soms;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.dicadut.soms.mapper")
public class SomsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SomsApplication.class, args);
    }

}
