package com.cpe.starter.modele;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_user;
	
	static int id_userstatic=0;
	
	@Column(name="identifiant")
	private String identifiant;
	
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String psw;
	

	@Column(name="money")
	private int money;

	@JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "owner")
    private Collection<Card> collection ;
	
    public User() {
    	
    }
    
	public User(String name, String identifiant, String psw) {
		super();
		this.id_user = id_userstatic;
		id_userstatic++;
		this.name=name;
		this.identifiant = identifiant;
		this.psw = psw;
		this.money = 5000;
		this.collection = null;
	}

	public int getid_user() {
		return id_user;
	}

	public void setid_user(int id_user) {
		this.id_user = id_user;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getPsw() {
		return psw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Collection<Card> getCardcollection() {
		return collection;
	}

	public void setCardcollection(Collection<Card> cardcollection) {
		this.collection = cardcollection;
	}
	
	public void addCardcollection(Card C) {
		this.collection.add(C);
	}

}
