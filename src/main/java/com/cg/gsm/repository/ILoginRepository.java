package com.cg.gsm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.gsm.entities.Login;

@Repository
public interface ILoginRepository extends JpaRepository<Login, Integer> {

}
