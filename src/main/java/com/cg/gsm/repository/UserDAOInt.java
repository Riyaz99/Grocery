package com.cg.gsm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.gsm.entities.UserEntity;

@Repository
public interface UserDAOInt extends JpaRepository<UserEntity, Long>{


//	public UserEntity findByLogin(String login);
//	
//	public List<UserEntity> search(UserEntity bean, long pageNo, int pageSize);
//	
//	public List<UserEntity> search(UserEntity bean);
//	
//	public UserEntity authenticate(UserEntity bean);
	
	public UserEntity findByEmailId(String email);
	
}
