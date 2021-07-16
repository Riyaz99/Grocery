package com.cg.gsm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.gsm.entities.ProductEntity;

@Repository
public interface ProductDAOInt extends JpaRepository<ProductEntity, Long>{

//	
//	public ProductEntity findByName(String name);
//	
//	public ProductEntity findByCode(String code);
//	
//	public List<ProductEntity> search(ProductEntity bean, long pageNo, int pageSize);
//	
//	public List<ProductEntity> search(ProductEntity bean);
//	
//	public Blob getImageById(long id) throws SerialException, SQLException;
	
}
