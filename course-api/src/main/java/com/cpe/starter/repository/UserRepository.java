package com.cpe.starter.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.cpe.starter.modele.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select a from User a where a.pseudo=?1")
	public User findUserByPseudo(String pseudo);

    @Query("select a from User a where a.id_user=?1")
	public User findUserByID(int id);
    
    @Transactional
    @Modifying
    @Query("update User set money=:amount where id_user=:id_user ")
    public void UpdateMoney(int id_user,int amount);
}
