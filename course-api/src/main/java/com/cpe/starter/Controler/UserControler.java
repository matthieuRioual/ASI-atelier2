package com.cpe.starter.Controler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cpe.starter.modele.User;
import com.cpe.starter.service.UserService;

@RestController
public class UserControler {

	@Autowired
	private UserService userservice;
	
	@CrossOrigin 
	@RequestMapping(method=RequestMethod.POST,value="/register")
	public User Register(@RequestBody Map<String, String> input) {
		return userservice.Register(input.get("name"),input.get("pseudo"),input.get("psw"));
	}
	
	@CrossOrigin 
	@RequestMapping(method=RequestMethod.POST,value="/connexion")
	public User connection(@RequestBody Map<String, String> payload) {
		return userservice.Login(payload.get("pseudo"),payload.get("psw"));
	}

}
