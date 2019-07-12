package com.ysk.resource;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ysk.api.model.User;

public interface UserMapper {
	// 使用注解的方式
	@Select("select * from t_user where name like concat('%',#{name},'%')")
	public List<User> likeName(String name);

	@Select("select * from t_user where id = #{id}")
	public User getById(Long id);

	// 使用xml的方式
	public List<User> getUsers();

}