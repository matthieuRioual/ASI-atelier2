package com.cpe.starter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpe.starter.modele.Card;
import com.cpe.starter.modele.User;
import com.cpe.starter.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void addCardtoCollection(User user,Card C){
		user.addCardcollection(C);

	}
	
	public User findUserbyID(int id) {
		return userRepository.findUserbyID(id);
	}

	public boolean register(String name, String identifiant, String psw) {
		if(exists(identifiant)==null) {
			User u=new User(name,identifiant,psw);
			userRepository.save(u);	
			return true;
		}
		return false;
	}
	
	public User connection(String identifiant,String psw) {
		User A=exists(identifiant);
		if(A!=null) {
			return A;
		}
		else return null;
	}
	
	public User exists(String identifiant) {
		User U=userRepository.findUserbypseudo(identifiant);
		
		if(U !=null) {
			return U;}
		else return null;
	}

	public void takemoney(int id_user, int price) {
		
	}
	
}
