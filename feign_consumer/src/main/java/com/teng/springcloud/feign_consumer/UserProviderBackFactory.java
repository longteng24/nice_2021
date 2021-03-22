package com.teng.springcloud.feign_consumer;

import com.teng.springCloud.Person;
import feign.FeignException;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserProviderBackFactory implements FallbackFactory<ConsumerApi> {

    /**
     *
     * @param cause  错误原因
     * @return 降级处理
     */
    @Override
    public ConsumerApi create(Throwable cause) {
        return new ConsumerApi() {
            @Override
            public Map<Integer, String> getMap(Integer id) {
                return null;
            }

            @Override
            public Map<Integer, String> getMap2(Integer id, String name) {
                return null;
            }

            @Override
            public Map<Integer, String> getMap3(Map<String, Object> map) {
                return null;
            }

            @Override
            public Map<Integer, String> postMap(Map<String, Object> map) {
                return null;
            }

            @Override
            public String hiTeng(String name) {
                return null;
            }

            @Override
            public String isAlive() {
                // TODO Auto-generated method stub
                System.out.println(cause);
                if (cause instanceof FeignException.InternalServerError) {

                    return "远程服务器 500" + cause.getLocalizedMessage();
                } else {

                    return "呵呵！！！！";
                }
            }

            @Override
            public String getById(Integer id) {
                return null;
            }

            @Override
            public Person postPserson(Person person) {
                return null;
            }
        };
    }
}
