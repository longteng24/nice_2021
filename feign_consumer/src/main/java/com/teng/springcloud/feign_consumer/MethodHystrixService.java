package com.teng.springcloud.feign_consumer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @program: nice-2021
 * @description: hystrix+restTemplate  实现降级
 * @author: Mr.Teng
 * @create: 2021-03-22 08:23
 **/
@Service
public class MethodHystrixService {


    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(defaultFallback = "back")
    public String alive() {
        String url = "http://user-provider/alive";

        return restTemplate.getForObject(url, String.class);

    }

    public String back() {
        return "哈哈";
    }


}








