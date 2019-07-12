package com.ysk.api.service;

import java.util.List;

import com.ysk.api.model.User;

public interface UserService {
	
	String sayHello(String str);

	User findUser();
	
	List<User> getUser(int page, int pageSize);

	User getUserForRedis(String key);
}
