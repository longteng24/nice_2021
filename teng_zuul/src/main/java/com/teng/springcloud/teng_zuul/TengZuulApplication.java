package com.teng.springcloud.teng_zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class TengZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(TengZuulApplication.class, args);
    }

}
