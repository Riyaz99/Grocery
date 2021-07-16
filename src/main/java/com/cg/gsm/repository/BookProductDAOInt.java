package com.cg.gsm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.gsm.entities.BookProductEntity;

@Repository
public interface BookProductDAOInt extends JpaRepository<BookProductEntity, Long> {


	public BookProductEntity findByProductName(String name);
//	
//	public List<BookProductEntity> search(BookProductEntity bean, long pageNo, int pageSize);
//	
//	public List<BookProductEntity> search(BookProductEntity bean);
//	
	
}
