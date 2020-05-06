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
	@RequestMapping(method=RequestMethod.POST,value="/addcart")
	public void addfreecartes(@RequestBody Map<String, String> entry){
		cardservice.addcard(entry);
	}
	
	@CrossOrigin 
	@RequestMapping(method=RequestMethod.GET,value="/getcard")
	public List<Card> getallcards(@RequestParam("id") int id) {
		return cardservice.getCardByOwner(id);
	}

	@CrossOrigin 
	@RequestMapping(method=RequestMethod.GET,value="/getcardbyid")
	public Card getcardbyID(@RequestParam("id") int id) {
		return cardservice.getCardByID(id);
	}
	
}
