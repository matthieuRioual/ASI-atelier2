package com.cpe.starter.service;



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
	
	public boolean SellCard(int id_card) {
		Card c=cardservice.GetCardByID(id_card);
		if(c.getFlagmarket()==1) {
			return false;
		}
		else {
			cardservice.ChangeMarketSituation(id_card);
			return true;
		}
	}
	
	public boolean BuyCard(int id_card,int id_buyer) {
		User buyer=userservice.GetUserByID(id_buyer);
		int id_seller=cardservice.GetCardByID(id_card).getOwner().getid_user();
		int price=cardservice.GetCardByID(id_card).getPrice();
		if(buyer.getMoney()>price) {
			userservice.GetDebited(id_buyer,price);
			userservice.GetCredited(id_seller, price);
			cardservice.changeowner(buyer, id_card);
			cardservice.ChangeMarketSituation(id_card);
			return true;}
		else return false;
	}
	
}
