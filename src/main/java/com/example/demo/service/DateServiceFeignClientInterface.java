package com.example.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "spring-cloud-provider")
public interface DateServiceFeignClientInterface {

    @GetMapping("/getUserInfo")
    String userInfo();
}
