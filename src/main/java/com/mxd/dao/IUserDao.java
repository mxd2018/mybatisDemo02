package com.mxd.dao;

import java.util.List;
import java.util.Map;

import com.mxd.pojo.po.User;

public interface IUserDao {
	//查询单个对象
	User selectById(Integer id);
	
	//获得所有对象
	List<User> findAllUser();
	
	//添加对象
	void insertUser(User user);
	
	//删除对象
	void deleteUser(Integer id);
	
	//修改对象信息
	void updateUser(User user);
	
	//模糊查询
	User findUserLike(User user);
	
	//分页查询	
	List<User> selectUserByPage(Map<String,Object> map);
}
