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
	
	//Getters of User entity
	public User GetUserByPseudo(String pseudo) {
		User u=userRepository.findUserByPseudo(pseudo);
		return u;
	}
	
	public User GetUserByID(int id) {
		return userRepository.findUserByID(id);
	}

	//Main functions register and login
	public User Register(String name, String pseudo, String psw) {
		if(GetUserByPseudo(pseudo)==null) {
			User u=new User(name,pseudo,psw);
			userRepository.save(u);	
			return u;
		}
		return null;
	}
	
	public User Login(String pseudo,String psw) {
		if(UserExists(pseudo,psw)) {
			return GetUserByPseudo(pseudo);
		}
		else return null;
	}
	
	//Verification of an existing user
	public boolean UserExists(String pseudo,String psw) {
		User u=GetUserByPseudo(pseudo);
		if (u!=null){
			if(u.getPsw().equals(psw)) {
				return true;}
			return false;
		}
		else return false;
	}

	//Action of money of user (used in market)
	public void GetCredited(int id_user, int price) {
		User u =GetUserByID(id_user);
		int amount=u.getMoney()+price;
		userRepository.UpdateMoney(id_user,amount);
	}
	
	public void GetDebited(int id_user,int price){
		User u =GetUserByID(id_user);
		int amount=u.getMoney()-price;
		userRepository.UpdateMoney(id_user,amount);
		}
}

