package com.yipei.zhu.restauranthelper.controllers;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yipei.zhu.restauranthelper.model.User;
import com.yipei.zhu.restauranthelper.service.UserService;
import com.yipei.zhu.restauranthelper.util.QueryResult;
import com.yipei.zhu.restauranthelper.util.RestResponse;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {
	
	@Autowired
	protected UserService userService;
	
	protected ObjectMapper mapper;
	
	@RequestMapping(value="/saveOrUpdate",method=RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
		this.mapper = new ObjectMapper();
		User user = this.mapper.readValue(userJson, User.class);
		//check if the save is new
		if(!this.validate(user)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(),
					"Invalid value on saveOrUpdate");
		}
		this.userService.save(user);
		return new RestResponse(HttpStatus.OK.value(),"Operation executed in saveOrUpdate");
	}
	
	@RequestMapping(value="/deleteUser",method=RequestMethod.POST)
	public List<User> deleteUser(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
		this.mapper = new ObjectMapper();
		User user = this.mapper.readValue(userJson, User.class);
		
		if(user.getId() == null) {
			return this.userService.findAll();
		}
		this.userService.deleteUser(user.getId());
		return this.userService.findAll();
	}
	
	//@CrossOrigin(origins = "http://localhost:8080")
	@RequestMapping(value="/getUsers",method=RequestMethod.GET)
	public List<User> getUsers() {
		return this.userService.findAll();
		
	}
	
	private boolean validate(User user) {
		boolean isValid = true;
		
		if(StringUtils.trimToNull(user.getEmail()) == null) {
			isValid = false;
		}
		
		if(StringUtils.trimToNull(user.getFirstName()) == null) {
			isValid = false;
		}
		
		if(StringUtils.trimToNull(user.getLastName()) == null) {
			isValid = false;
		}
		
		if(StringUtils.trimToNull(user.getPassword()) == null) {
			isValid = false;
		}
		
		
		return isValid;
	}
}
