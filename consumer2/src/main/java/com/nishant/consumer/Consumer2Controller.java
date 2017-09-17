package com.nishant.consumer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer2")
public class Consumer2Controller {

	@RequestMapping(value="/get/{name}",method=RequestMethod.GET)
	public String get(@PathVariable String name) {
		return "consumer2 resp "+name;
	}

}
