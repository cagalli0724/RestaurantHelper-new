package com.yipei.zhu.restauranthelper.service;

import java.util.List;

import com.yipei.zhu.restauranthelper.model.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	void deleteUser(Long id);

}
