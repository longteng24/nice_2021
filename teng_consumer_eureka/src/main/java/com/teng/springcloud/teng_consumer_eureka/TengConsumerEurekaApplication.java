package com.teng.springcloud.teng_consumer_eureka;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TengConsumerEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TengConsumerEurekaApplication.class, args);
    }


    @Bean
    RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /*
    切换负载均衡策略
     */
    @Bean
    public IRule myRule() {
        //return new RoundRobinRule();
        return new RandomRule();
        //  return new RetryRule();
    }

}
