package com.yipei.zhu.restauranthelper.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yipei.zhu.restauranthelper.model.User;


public interface UserRepository extends JpaRepository<User,Long> {
	
	@SuppressWarnings("unchecked")
	User save(User user);
	
	
	List<User> findAll();
	
}
