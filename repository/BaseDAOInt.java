package com.cg.gsm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.gsm.entities.BaseEntity;

@Repository
public interface BaseDAOInt extends JpaRepository<BaseEntity,Long> {

}
