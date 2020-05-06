package com.cpe.starter.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpe.starter.modele.Card;
import com.cpe.starter.modele.User;
import com.cpe.starter.repository.CardRepository;
import com.cpe.starter.repository.UserRepository;

@Service
public class CardService {

	@Autowired
	CardRepository cardRepository;
	
	@Autowired
	UserService userService;
	
		
	public List<Card> getCardByOwner(int id) {
		return cardRepository.findByOwner(id);
	}

	public void addcard(Map<String,String> entry) {
		
		User u=userService.findUserbyID(Integer.parseInt(entry.get("owner_id_user")));
		Card c=new Card(0, entry.get("name"), entry.get("description"), entry.get("family_name"),entry.get("urlfamily")
				, entry.get("imgurl"),Integer.parseInt(entry.get("hp")), Integer.parseInt(entry.get("energy")),Integer.parseInt(entry.get("attack"))
				, Integer.parseInt(entry.get("defence")), Integer.parseInt(entry.get("price")), u);
		cardRepository.save(c);
	}

	public Card getCardByID(int id) {
		return cardRepository.findById(id);
	}

	public List<Card> findAllmarket() {
		return cardRepository.findAllmarket();
	}

	public boolean isalreadysold(int id) {
		Card c=cardRepository.findById(id);
		if(c.is_sold())
			return true;
		return false;
	}

	public void turntosold(int id) {
		cardRepository.turntosold(id);
		
	}

	public void changeowner(User u, int id_card) {
		cardRepository.changeowner(u,id_card);
	}


}
