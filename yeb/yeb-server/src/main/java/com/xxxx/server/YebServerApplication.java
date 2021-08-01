package com.xxxx.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName: YebServerApplication
 * @Description: TODO
 * @author: solfeng
 * @date: 2021/7/7  17:55
 */
@SpringBootApplication
@MapperScan("com.xxxx.server.mapper")
@EnableScheduling
public class YebServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(YebServerApplication.class,args);
    }
}
