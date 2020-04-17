package com.example.service;

import java.util.List;

import com.example.entity.Userdata;

public interface UserService {

	Userdata addUser(Userdata u);
	
	List<Userdata> getAllUsers();

	Userdata deleteUser(int userId);

	Userdata updateUser(Userdata u);
	
	Boolean loginUser(Userdata u);

}