package com.teng.springCloud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户操作相关接口
 * @author 一明哥
 *
 */
// 由于hystrix  + feign 会出现重复注册的bug, 所有类上注释该注解
//@RequestMapping("/User")
public interface RegisterApi {

	@GetMapping("/alive")
	public String isAlive();


	@GetMapping("/getById")
	public String getById(Integer id);


	@PostMapping("/postPserson")
	public Person postPserson(@RequestBody Person person);
}