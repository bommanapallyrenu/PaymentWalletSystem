package com.cg.walletuser.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.walletuser.entity.Userdata;


@Repository
public interface UserDao extends JpaRepository<Userdata, Integer> {
	
	
}
