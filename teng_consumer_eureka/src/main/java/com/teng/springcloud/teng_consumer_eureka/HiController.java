package com.teng.springcloud.teng_consumer_eureka;


import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @program: nice-2021
 * @description: hi
 * @author: Mr.Teng
 * @create: 2021-03-16 09:13
 **/
@RestController
public class HiController {

    @Autowired
    DiscoveryClient client;

    @Autowired
    EurekaClient eurekaClient;

    @Autowired
    LoadBalancerClient lb;

    @GetMapping("/hi")
    public String getHi() {
        return "hi";
    }


    @GetMapping("/client")
    public String getClient() {
        List<String> services = client.getServices();
        StringBuffer sb = new StringBuffer("clients:");
        for (String str: services) {
            sb.append(str + "|   \n");
        }

        return sb.toString();
    }

    //获取指定实例信息
    @GetMapping("/client2")
    public Object getClient2() {
        return client.getInstances("euk_server01");
    }

    //获取指定服务实例信息
    @GetMapping("/client3")
    public Object getClient3() {
        List<ServiceInstance> ins = client.getInstances("euk_server01");

        StringBuffer sb = new StringBuffer("clients:");

        for (ServiceInstance str : ins) {
            sb.append(str + "|   \n");
        }
        return sb.toString();
    }


    @GetMapping("/client4")
    public String getClient4() {
        List<InstanceInfo> ins = eurekaClient.getInstancesById("windows10.microdone.cn:euk_server01:7001");
        if (ins.size() == 0) {

            return "can not find server";
        }
        InstanceInfo info = ins.get(0);
        String url = "";
        if (info.getStatus() == InstanceInfo.InstanceStatus.UP) {
            url = "http://" + info.getHostName() + ":" + info.getPort() + "/getHi";

        }
        return url;
    }

    //获取指定服务实例信息
    @GetMapping("/client5")
    public String getClient5() {
        List<InstanceInfo> ins = eurekaClient.getInstancesByVipAddress("euk_provider",false);
        if (ins.size() == 0) {

            return "can not find server";
        }
        InstanceInfo info = ins.get(0);
        String resp = "";
        if (info.getStatus() == InstanceInfo.InstanceStatus.UP) {
           String url = "http://" + info.getHostName() + ":" + info.getPort() + "/hi";

            System.out.println("url: "+url);
            RestTemplate restTemplate = new RestTemplate();
             resp = restTemplate.getForObject(url, String.class);
        }
        return resp;
    }

    //客户端负载均衡
    @GetMapping("/client6")
    public String getClient6() {

        ServiceInstance info = lb.choose("euk_provider");

        String url = "http://" + info.getHost() + ":" + info.getPort() + "/hi";

            System.out.println("url: "+url);
            RestTemplate restTemplate = new RestTemplate();
        return   restTemplate.getForObject(url, String.class);

    }


}
