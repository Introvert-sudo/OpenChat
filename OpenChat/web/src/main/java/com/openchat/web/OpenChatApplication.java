package com.openchat.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "com.openchat.web",
        "com.openchat.core"
})
public class OpenChatApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenChatApplication.class, args);
    }
}
