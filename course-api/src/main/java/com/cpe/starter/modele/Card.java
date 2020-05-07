package com.cpe.starter.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "cards")
public class Card {
	@Id
	@Column(name = "id_card")
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_card;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="familyName")
	private String familyName;
	@Column(name="urlfamily")
	private String urlfamily;
	@Column(name="imgurl")
	private String imgurl;
	@Column(name="hp")
	private int hp;
	@Column(name="energy")
	private int energy;
	@Column(name="attack")
	private int attack;
	@Column(name="defence")
	private int defence;
	@Column(name="price")
	private int price;
	@Column(name="flagmarket")
	private int flagmarket;
	@ManyToOne()
	@JsonBackReference
	private User owner;
	

	
	public Card(Integer id_card, String name, String description, String familyName, String urlfamily, String imgurl,
			int hp, int energy, int attack, int defence, int price, User owner) {
		super();
		this.id_card = id_card;
		this.name = name;
		this.description = description;
		this.familyName = familyName;
		this.urlfamily = urlfamily;
		this.imgurl = imgurl;
		this.hp = hp;
		this.energy = energy;
		this.attack = attack;
		this.defence = defence;
		this.price = price;
		this.owner = owner;
		this.flagmarket=0;
	}
	

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	
	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getUrlfamily() {
		return urlfamily;
	}

	public void setUrlfamily(String urlfamily) {
		this.urlfamily = urlfamily;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public Card() {
		
	}

	public Card(int id, String name2, String description2, String familyName2, String urlfamily2, String imgurl2,
			int hp, int energy, int attack, int defence, int price, User u) {
		super();
		this.id_card = id;
		this.name = name2;
		this.description = description2;
		this.familyName = familyName2;
		this.urlfamily = urlfamily2;
		this.imgurl = imgurl2;
		this.hp = hp;
		this.energy = energy;
		this.attack = attack;
		this.defence = defence;
		this.price = price;
		this.owner = u;
		this.flagmarket=0;
		}



	public int getId() {
		return id_card;
	}
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public void setId(int id) {
		this.id_card = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getFlagmarket() {
		return flagmarket;
	}


	public void setFlagmarket(int flagmarket) {
		this.flagmarket = flagmarket;
	}


}
