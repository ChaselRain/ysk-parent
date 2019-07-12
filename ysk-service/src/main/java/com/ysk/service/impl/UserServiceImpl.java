package com.ysk.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.ysk.api.model.User;
import com.ysk.api.service.UserService;
import com.ysk.resource.UserMapper;
import com.ysk.service.RedisService;

@Service(version = "1.0.0", interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RedisService redisService;

	@Override
	public String sayHello(String str) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return dateFormat.format(new Date()) + ": " + str;
	}

	@Override
	public User findUser() {
		User user = new User();
		user.setId(1001);
		user.setName("张三");
		user.setAge(20);
		user.setAddress("上海徐汇");
		return user;
	}

	@Override
	public List<User> getUser(int page, int pageSize) {
		PageHelper.startPage(page, pageSize);
		return userMapper.getUsers();
	}

	@Override
	public User getUserForRedis(String key) {
		User user = new User();
		user.setId(1008);
		user.setName("刘德华");
		user.setAge(60);
		user.setAddress("中国香港");
		redisService.set(user.getId() + "", user);
		return (User) redisService.get(key);
	}
}