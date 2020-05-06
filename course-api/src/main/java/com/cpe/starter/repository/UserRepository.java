package com.cpe.starter.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cpe.starter.modele.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("select a from User a where a.identifiant=?1")
	public User findUserbypseudo(String identifiant);

    @Query("select a from User a where a.id_user=?1")
	public User findUserbyID(int id);
    
}
