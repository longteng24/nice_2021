package com.teng.springcloud.feign_consumer;

import com.teng.springCloud.RegisterApi;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient(name = "user-provider")
public interface UserConsumerService extends RegisterApi {

}