package com.lkw.stall_management;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@MapperScan("com.lkw.stall_management.mapper")
@Slf4j
@SpringBootApplication
public class StallManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StallManagementApplication.class, args);
    }

}
