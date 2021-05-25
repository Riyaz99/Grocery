package com.cg.gsm;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cg.gsm.entities.BaseEntity;
import com.cg.gsm.entities.BookProductEntity;
import com.cg.gsm.entities.ChildEntity;
import com.cg.gsm.entities.ProductEntity;
import com.cg.gsm.entities.UserEntity;
import com.cg.gsm.repository.BaseDAOInt;
import com.cg.gsm.repository.BookProductDAOInt;
import com.cg.gsm.repository.ProductDAOInt;
import com.cg.gsm.repository.UserDAOInt;

@SpringBootApplication
public class GroceryShopApplication implements CommandLineRunner {
	@Autowired
	private BookProductDAOInt bpdRepository;
	@Autowired
	private ProductDAOInt pRepository;
	
	  @Autowired
	  private UserDAOInt uRepository;
	 
	@Autowired
	private BaseDAOInt bRepository;

	public static void main(String[] args) {
		SpringApplication.run(GroceryShopApplication.class, args);
	}
	
	 @Override
	public void run(String... args) throws Exception {
		System.out.println("Inside run");
		
		/*
		 * UserEntity u1 = new UserEntity(); u1.setFirstName("A"); u1.setLastName("B");
		 * u1.setLoginId("098"); u1.setPassword("asdf"); u1.setMobileNo("1234");
		 * u1.setEmailId("ab@gmail.com"); u1.setRoleId(123); u1.setId(1);
		 * 
		 * 
		 * 
		 * BookProductEntity bp1 = new BookProductEntity(); bp1.setProductId(1334);
		 * bp1.setProductId(1); bp1.setUsers(u1);
		 * 
		 * u1.setBookproduct(bp1);
		 * 
		 * 
		 * BaseEntity b1 = new ChildEntity();
		 * 
		 * b1.setCreatedBy("abc"); b1.setModifiedBy("def"); b1.setCreatedDateTime(new
		 * Timestamp(12052021)); b1.setModifiedDateTime(new Timestamp(13052021));
		 * b1.setId(123); u1.setBase(b1); b1.setUser(u1); bp1.setBase(b1);
		 * b1.setBookproduct(bp1);
		 * 
		 * ProductEntity p1 = new ProductEntity(); p1.setProdcode(1); p1.setBase2(b1);
		 * b1.setProduct(p1); bpdRepository.save(bp1); uRepository.save(u1);
		 * 
		 * pRepository.save(p1); bRepository.save(b1);
		 */
		 
   
		//bRepository.deleteById(123L);
		
	   pRepository.deleteById(1L);
	    System.out.println("deleted");
		System.out.println("Success!!");
		

}
}