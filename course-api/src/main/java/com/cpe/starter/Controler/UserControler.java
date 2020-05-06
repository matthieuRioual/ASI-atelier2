package com.cpe.starter.Controler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpe.starter.modele.User;
import com.cpe.starter.service.UserService;

@RestController
public class UserControler {

	@Autowired
	private UserService userservice;
	
	@CrossOrigin 
	@RequestMapping(method=RequestMethod.POST,value="/register")
	public boolean register(@RequestBody Map<String, String> input) {
		return userservice.register(input.get("name"),input.get("identifiant"),input.get("psw"));
	}
	
	@CrossOrigin 
	@RequestMapping(method=RequestMethod.POST,value="/connexion")
	public User connection(@RequestBody Map<String, String> payload) {
		return userservice.connection(payload.get("identifiant"),payload.get("psw"));
	}

	@RequestMapping(method=RequestMethod.GET,value="/test")
	public User find(@RequestParam("v") String identifiant) {
		return userservice.exists(identifiant);}
	
}
