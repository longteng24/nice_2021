package com.teng.springcloud.teng_consumer_eureka;


import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: nice-2021
 * @description: hi
 * @author: Mr.Teng
 * @create: 2021-03-16 09:13
 **/
@RestController
public class HiControllerPlus {

    @Autowired
    DiscoveryClient client;

    @Autowired
    EurekaClient eurekaClient;

    @Autowired
    LoadBalancerClient lb;

    @Autowired
    RestTemplate restTemplate;

    //客户端负载均衡
    @GetMapping("/client7")
    public String getClient6() {

        ServiceInstance info = lb.choose("EUK_PROVIDER");

        String url = info.getUri() + "/hi";

        System.out.println("url: "+url);

        return   restTemplate.getForObject(url, String.class);

    }

    /**
     * 获取客户端服务列表
     */
    @Autowired
    DiscoveryClient discoveryClient;

     private static    AtomicInteger atomicInteger = new AtomicInteger();
    /**
     * 手动负载均衡
     * @return
     */
    @GetMapping("/client8")
    public String getClient8() {

        List<ServiceInstance> instances = discoveryClient.getInstances("provider");
        System.out.println("instances:"+instances);

        int nextInt = new Random().nextInt(instances.size());
        //自定义随机算法
        ServiceInstance inst = instances.get(nextInt);

        //轮询算法
        int i = atomicInteger.getAndIncrement();
        ServiceInstance inst01 = instances.get(i%instances.size());

        String url = inst.getUri() + "/hi";

        System.out.println("url: "+url);
        RestTemplate restTemplate = new RestTemplate();

        return  restTemplate.getForObject(url, String.class);
    }

    /*
     restTemplate 结合 ribbon
     */
    @GetMapping("/client9")
    public String getClient9() {
        String url = "http://provider/hi";


        return   restTemplate.getForObject(url, String.class);
    }

}
