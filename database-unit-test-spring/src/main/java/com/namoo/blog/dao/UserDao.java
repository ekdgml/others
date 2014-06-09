package com.namoo.blog.dao;

import java.util.List;

import com.namoo.blog.domain.User;

public interface UserDao {
	//
	List<User> readAllUser();
	User readUser(String userId);
	void insertUser(User user);
	void updateUser(User user);
	void deleteUser(String userId);
}
