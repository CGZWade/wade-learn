package com.wade.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MainAppConfigCenter3344 {

    // 127.0.0.1 config-3344.com
    public static void main(String[] args) {
        SpringApplication.run(MainAppConfigCenter3344.class);
    }

}
