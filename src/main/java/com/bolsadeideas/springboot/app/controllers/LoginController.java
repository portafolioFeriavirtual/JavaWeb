package com.bolsadeideas.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/")
@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	public String mostrarlogin(){
		return "login";
	}
}
