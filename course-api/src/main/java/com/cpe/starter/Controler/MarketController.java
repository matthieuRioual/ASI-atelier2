package com.cpe.starter.Controler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpe.starter.service.Marketservice;

@RestController
public class MarketController {

	@Autowired
	private Marketservice marketservice;
	

	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET,value="/sellcard")
	public boolean SellCard(@RequestParam("id") int id_card) {
		return marketservice.SellCard(id_card);
	}
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.POST,value="/buycard")
	public boolean AchatCard(@RequestBody Map<String,String> input) {
		return marketservice.BuyCard(Integer.parseInt(input.get("id_card")),Integer.parseInt(input.get("id_buyer")));
	}
	
	
}
