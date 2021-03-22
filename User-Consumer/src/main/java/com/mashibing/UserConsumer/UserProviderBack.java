package com.mashibing.UserConsumer;

import java.util.Map;

import com.teng.springCloud.Person;
import org.springframework.stereotype.Component;


public class UserProviderBack implements ConsumerApi {

	@Override
	public String isAlive() {



		return "降级了";
	}

	@Override
	public String getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person postPserson(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> getMap(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> getMap2(Integer id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> getMap3(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> postMap(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return null;
	}

}
