package com.softwaymedical.sdd2019.thecamp.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/thecamp")
public class TheCampRestController {

	@RequestMapping(method = RequestMethod.GET, value = "/hello", produces = "application/json")
	public void hello() {
		System.out.println("Hello world");
	}

}