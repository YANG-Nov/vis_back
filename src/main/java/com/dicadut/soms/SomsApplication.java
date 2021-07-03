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

        int orderNumber = 11;
        System.out.println("第" +  orderNumber + "个数是：" + fibonacci( orderNumber-1));


    }

    public static int fibonacci(int orderNumber) {
        if ((0 == orderNumber ) || (1 == orderNumber))
            return orderNumber;
        else
            return fibonacci(orderNumber - 1) + fibonacci(orderNumber - 2);
    }

}
