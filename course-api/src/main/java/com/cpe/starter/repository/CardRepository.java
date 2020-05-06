package com.cpe.starter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cpe.starter.modele.Card;
import com.cpe.starter.modele.User;

public interface CardRepository extends CrudRepository<Card, Integer> {

    @Query("select c from Card c where c.owner.id_user=?1")
	public List<Card> findByOwner(int id);
    
    @Query("select c from Card c where c.id_card=?1")
	public Card findById(int id);
    
    @Query("SELECT MAX(id_card) FROM Card")
    public int getmaxID();

    @Query("SELECT c from Card where c.isold='true'")
    public List<Card> findAllmarket();

    @Query("")
	public Object isalreadysold(int id);
    
    @Query("")
	public void turntosold(int id);

    @Query("UPDATE cards" + 
    		"SET owner_id_user = :id_user"+ 
    		"WHERE id_card=:id_cad")
	public void changeowner(int id_user, int id_card);

}
