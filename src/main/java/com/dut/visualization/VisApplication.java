package com.dut.visualization;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.dut.visualization.mapper")
public class VisApplication {

    public static void main(String[] args) {
        SpringApplication.run(VisApplication.class, args);
    }

}
