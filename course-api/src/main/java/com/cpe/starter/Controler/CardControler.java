package com.cpe.starter.Controler;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpe.starter.modele.Card;
import com.cpe.starter.service.CardService;

@RestController
public class CardControler {

	@Autowired
	private CardService cardservice;
	
	@CrossOrigin 
	@RequestMapping(method=RequestMethod.GET,value="/getcard")
	public List<Card> GetCardByUser(@RequestParam("id") int id_user) {
		return cardservice.GetCardByUser(id_user);
	}

	@CrossOrigin 
	@RequestMapping(method=RequestMethod.GET,value="/getcardbyid")
	public Card GetCardByID(@RequestParam("id") int id_card) {
		return cardservice.GetCardByID(id_card);
	}
	
	@CrossOrigin 
	@RequestMapping(method=RequestMethod.POST,value="/addcard")
	public void AddCard(@RequestBody Map<String, String> entry){
		cardservice.AddCard(entry);
	}
	
	@CrossOrigin 
	@RequestMapping(method=RequestMethod.GET,value="/market")
	public List<Card> GetCardInMarket(){
		return cardservice.GetCardMarket();
	}
}
