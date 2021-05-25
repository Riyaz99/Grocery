package com.cg.gsm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.gsm.entities.BookProductEntity;

@Repository
public interface BookProductDAOInt extends JpaRepository<BookProductEntity,Long>{

	//public long add(BookProductEntity bean);
	
	//public void update(BookProductEntity bean);
	
	//public void delete(BookProductEntity bean);
	
	//public BookProductEntity findByName(String name);
	
	//public BookProductEntity findById(long id);
	
	//public List<BookProductEntity> search(BookProductEntity bean, long pageNo, int pageSize);
	
	//public List<BookProductEntity> search(BookProductEntity bean);
	
	
}
