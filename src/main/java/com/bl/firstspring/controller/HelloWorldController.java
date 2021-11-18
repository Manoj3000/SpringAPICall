package com.bl.firstspring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bl.firstspring.model.User;

@RestController
@RequestMapping("/home")
public class HelloWorldController {
	
	@GetMapping(value = {"", "/", "/sayHello"})
	public String sayHello() {
		return "Hello From Java Spring App";
	}
	
	@GetMapping("/getQueryParam")
	@ResponseBody
	public String getQueryParam(@RequestParam String firstname) {
		return "Hello " + firstname;
	}
	
	@GetMapping("/getFirstName/{firstname}")
	public String getName(@PathVariable(name="firstname") String firstname) {
		return "Hello " + firstname;
	}
	
	@PostMapping("/postData")
	public String postData(@RequestBody User user) {
		return "Hello " + user.getFirstname() + " " + user.getLastname();	
	}
	
	@PutMapping("/putData/{firstname}")
	public String putData(@PathVariable String firstname, @RequestParam(value="lastname") String lasttname) {
		return "Hello " + firstname +" "+ lasttname;
	}
}
