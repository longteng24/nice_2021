package com.teng.springcloud.feign_consumer;

import com.teng.springCloud.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConsumerController {


	@Autowired
	ConsumerApi api;

	@GetMapping("/alive")
	public String alive() {

		return api.isAlive();
	}
	@GetMapping("/map")
	public Map<Integer, String> map(Integer id) {
		System.out.println(id);
		return api.getMap(id);
	}

	@GetMapping("/map2")
	public Map<Integer, String> map2(Integer id,String name) {
		System.out.println(id);
		return api.getMap2(id,name);
	}


	@GetMapping("/map3")
	public Map<Integer, String> map3(@RequestParam Map<String, Object> map) {
		HashMap<String, Object> map1 = new HashMap<>(2);

		map1.put("id", 2000);
		map1.put("name", "凯");
		return api.getMap3(map1);
	}


	@GetMapping("/map4")
	public Map<Integer, String> map4(@RequestParam Map<String, Object> map) {
//		System.out.println(id);
//		HashMap<String, Object> map = new HashMap<>(2);
//
//		map.put("id", id);
//		map.put("name", name);
//		syso
		System.out.println(map);
		return api.postMap(map);
	}




//	@GetMapping("/postPerson")
//	public Person postPerson(@RequestParam Map<String, Object> map) {
//
//		System.out.println(map);
//
//		Person person = new Person();
//		person.setId(Integer.parseInt(map.get("id").toString()));
//		person.setName("xxoo");
//		return api.postPserson(person);
//	};

	@GetMapping("/hiTeng")
	public String hiTeng(@RequestParam String name) {

		return api.hiTeng(name);
	};
}