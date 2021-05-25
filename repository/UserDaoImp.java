package com.cg.gsm.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.cg.gsm.entities.UserEntity;

@Repository
public class UserDaoImp /*implements UserDAOInt*/ {

	/*
	 * @Autowired private EntityManager entityManager;
	 * 
	 * @Override public List<UserEntity> search(UserEntity bean) { Session
	 * currentSession = entityManager.unwrap(Session.class); Query query =
	 * currentSession.createQuery("from user",UserEntity.class); List<UserEntity>
	 * list= query.getResultList(); return list;
	 * 
	 * }
	 */
}
	