package com.ssafy.rest.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.rest.domain.Greet;

@RestController
public class SampleController {
	private static final String template = "Hello. %s!!!!";
	private final AtomicLong counter = new AtomicLong();
	
//	@RequestMapping("/hello")
 	@RequestMapping(value="/hello" , method=RequestMethod.GET)
	public String sayHello()
	{
		return "Helle Restful API ...";
	}
 	
 	@GetMapping("/greet")
 	public Greet sayGreet()
 	{
 		Greet vo = new Greet(1029L,"Hi Good Morning!!");
 		// 객체는 반드시 json으로 반환하여야 한다. -> 브라우저는 json만 해석가능..
 		return vo;
 	}
 	
 	//http://127.0.0.1:8888/rest/greet2/200
 	@GetMapping("/greet2/{id}")
 	public String sayGreet2(@PathVariable int id)
 	{
 			return "Hello Greet2";
 	}
 	
 	//http://127.0.0.1:8888/rest/greet3?name=제임스
 	@GetMapping("/greet3")
 	public Greet sayGreet3(@RequestParam String name)
 	{
 		return new Greet(234L,"방가방가");
 	}
 	
 	//http://127.0.0.1:8888/rest/greet4?name=제임스
 	@GetMapping("/greet4")
 	public Greet sayGreet4(@RequestParam(value="name", required=false, defaultValue="World") String name)
 	{
 		return new Greet(counter.incrementAndGet(),String.format(template, name));
 	}
}
