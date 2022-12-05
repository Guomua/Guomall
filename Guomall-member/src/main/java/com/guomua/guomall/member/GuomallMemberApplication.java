package com.guomua.guomall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients("com.guomua.guomall.member.feign")
public class GuomallMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuomallMemberApplication.class, args);
    }

}
