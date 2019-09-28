package com.chunkit.wifi_monitor;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value = "com.chunkit.wifi_monitor.mapper")
@SpringBootApplication
public class WifiMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(WifiMonitorApplication.class, args);
    }

}
