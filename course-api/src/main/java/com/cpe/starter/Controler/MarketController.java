package com.cpe.starter.Controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpe.starter.modele.Card;
import com.cpe.starter.service.Marketservice;

@RestController
public class MarketController {

	@Autowired
	private Marketservice marketservice;
	
	@CrossOrigin
	@RequestMapping("/market")
	public List<Card> getallcardofmarket() {
		return (List<Card>) marketservice.getallcardmarket();
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET,value="/misenvente")
	public boolean soldcard(@RequestParam("id") int id) {

		return marketservice.soldcard(id);
	}
	
}
