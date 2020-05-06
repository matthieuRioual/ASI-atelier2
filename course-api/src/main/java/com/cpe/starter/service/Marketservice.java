package com.cpe.starter.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpe.starter.modele.Card;
import com.cpe.starter.modele.User;

@Service
public class Marketservice {
	
	@Autowired
	CardService cardservice;
	@Autowired
	UserService userservice;
	
	public List<Card> getallcardmarket(){
		return (List<Card>) cardservice.findAllmarket();
	}
	
	public boolean soldcard(int id) {
		if(cardservice.getCardByID(id).is_sold()) {
			return false;
		}
		else cardservice.turntosold(id);
		return true;
	}

	public boolean buycard(int id_card, int id_user) {
		User u=userservice.findUserbyID(id_user);
		Card c=cardservice.getCardByID(id_card);
		if(u.getMoney()>c.getPrice()) {
			userservice.takemoney(id_user,c.getPrice());
			cardservice.changeowner(u,id_card);
			return true;
		}
		return false;
	}
	
}
