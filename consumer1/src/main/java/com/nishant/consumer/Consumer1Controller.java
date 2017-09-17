package com.nishant.consumer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer1")
public class Consumer1Controller {

	@RequestMapping(value="/get/{name}",method=RequestMethod.GET)
	public String get(@PathVariable String name) {
		System.out.println("consumer1 resp "+name);
		return "consumer1 resp "+name;
	}
	@RequestMapping(value="/post",method=RequestMethod.POST)
	public String post(@RequestBody UserVO userVO) {
		System.out.println("consumer1 post resp "+userVO.getName());
		return "consumer1 post resp "+userVO.getName();
	}

}
