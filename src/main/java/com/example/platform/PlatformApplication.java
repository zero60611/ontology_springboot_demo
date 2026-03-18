/**
 * Spring Boot 應用程式入口。
 */
package com.example.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PlatformApplication {

    /**
     * 啟動 Foundry-like 平台骨架專案。
     *
     * @param args 啟動參數
     */
    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);
    }
}
