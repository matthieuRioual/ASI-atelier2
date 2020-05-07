package com.cpe.starter.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpe.starter.modele.Card;
import com.cpe.starter.modele.User;
import com.cpe.starter.repository.CardRepository;

@Service
public class CardService {

	@Autowired
	CardRepository cardRepository;
	
	@Autowired
	UserService userservice;
	
	//Get the cards you want by critters
	public List<Card> GetCardByUser(int id_user) {
		return cardRepository.GetCardByUser(id_user);
	}

	public Card GetCardByID(int id_card) {
		return cardRepository.GetCardByID(id_card);
	}

	public List<Card> GetCardMarket() {
		return cardRepository.findAllmarket();
	}
	
	//
	public void AddCard(Map<String,String> entry) {
		User u=userservice.GetUserByID(Integer.parseInt(entry.get("id_user")));
		System.out.println(u.getid_user());
		Card c=new Card(0, entry.get("name"), entry.get("description"), entry.get("family_name"),entry.get("urlfamily")
				, entry.get("imgurl"),Integer.parseInt(entry.get("hp")), Integer.parseInt(entry.get("energy")),Integer.parseInt(entry.get("attack"))
				, Integer.parseInt(entry.get("defence")), Integer.parseInt(entry.get("price")), u);
		System.out.println(c.getOwner());
		cardRepository.save(c);
	}

	//Change an attribute after a transaction
	public void ChangeMarketSituation(int id_card) {
		Card C=cardRepository.GetCardByID(id_card);
		if(C.getFlagmarket()==1) {
			cardRepository.ChangeMarketSituation(0,id_card);}
		else 
			cardRepository.ChangeMarketSituation(1,id_card);
		
	}

	public void changeowner(User u, int id_card) {
		cardRepository.Changeowner(id_card,u);
	}


}
