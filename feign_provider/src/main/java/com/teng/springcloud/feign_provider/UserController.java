package com.teng.springcloud.feign_provider;

import com.teng.springCloud.RegisterApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements RegisterApi {

	@Override
	public String isAlive() {
		// TODO Auto-generated method stub
		return "ok";
	}

}