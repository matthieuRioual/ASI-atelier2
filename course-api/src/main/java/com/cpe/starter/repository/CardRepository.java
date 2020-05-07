package com.cpe.starter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cpe.starter.modele.Card;
import com.cpe.starter.modele.User;

public interface CardRepository extends CrudRepository<Card, Integer> {

    @Query("select c from Card c where c.owner.id_user=?1")
	public List<Card> GetCardByUser(int id_user);
    
    @Query("select c from Card c where c.id_card=?1")
	public Card GetCardByID(int id_card);
    
    @Query("SELECT MAX(id_card) FROM Card")
    public int getmaxID();

    @Query("SELECT c from Card c where c.flagmarket=1")
    public List<Card> findAllmarket();
    
    @Transactional
    @Modifying
    @Query("UPDATE Card SET flagmarket=:b WHERE id_card=:id_card")
	public void ChangeMarketSituation(int b,int id_card);

    @Transactional
    @Modifying
    @Query("UPDATE Card SET owner=:u WHERE id_card=:id_card")
	public void Changeowner(int id_card, User u);

}
