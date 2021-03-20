package com.teng.springcloud.feign_provider;

import com.teng.springCloud.Person;
import com.teng.springCloud.RegisterApi;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
public class UserController implements RegisterApi {

	@Override
	public String isAlive() {
		// TODO Auto-generated method stub
		return "ok";
	}
	@Override
	public String getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/getMap")
	public Map<Integer, String> getMap(@RequestParam("id") Integer id) {



		System.out.println(id);
		return Collections.singletonMap(id, "mmeme");
	}
	@GetMapping("/getMap2")
	public Map<Integer, String> getMap2(Integer id,String name) {
		// TODO Auto-generated method stub
		System.out.println(id);
		return Collections.singletonMap(id, name);
	}

	@GetMapping("/getMap3")
	public Map<Integer, String> getMap3(@RequestParam Map<String, Object> map) {
		// TODO Auto-generated method stub
		System.out.println(map);
		return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
	}


	@PostMapping("/postMap")
	public Map<Integer, String> postMap(@RequestBody Map<String, Object> map) {
		// TODO Auto-generated method stub
		System.out.println(map);
		return Collections.singletonMap(Integer.parseInt(map.get("id").toString()), map.get("name").toString());
	}

	@Override
	public Person postPserson(Person person) {
		System.out.println(ToStringBuilder.reflectionToString(person));
		return person;
	}
	@GetMapping("/hiTeng")
	public String hiTeng(@RequestParam String name) {

		return "你好："+name;
	};

}