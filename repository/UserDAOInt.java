package com.cg.gsm.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.gsm.entities.UserEntity;

@Repository
public interface UserDAOInt extends JpaRepository<UserEntity, Long>{

	//public long add(UserEntity bean);
	
	//public void update(UserEntity bean);
	
	//public void delete(UserEntity bean);
	
	//public UserEntity findByLoginId(String login);
	
	//public UserEntity findByPk(long id);
	
	//public List<UserEntity> search(UserEntity bean, long pageNo, int pageSize);
	
	//public List<UserEntity> search(UserEntity bean);
	
	//public UserEntity authenticate(UserEntity bean);
	
}