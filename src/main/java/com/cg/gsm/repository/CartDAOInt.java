package com.cg.gsm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.gsm.entities.CartEntity;

@Repository
public interface CartDAOInt extends JpaRepository<CartEntity, Long>{
	
	@Query("from CartEntity ce where ce.userEntity.userId=:userid")
	public List<CartEntity> viewCart(@Param("userid") Long userId);

}
