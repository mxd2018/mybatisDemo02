package com.mxd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.mxd.pojo.po.User;

public class UserServiceImplTest {
	UserServiceImpl userServiceImpl;
	
	@Before
	public void init(){
		userServiceImpl=new UserServiceImpl();
	}
	
	@Test
	//查询单个对象
	public void TestSelectById(){
		
		User user = userServiceImpl.findById(1);
		System.out.println(user);
	}
	
	@Test
	//查询所有对象
	public void TestFindAll(){
		List<User> list = userServiceImpl.findAll();
		System.out.println(list);	
	}
	
	@Test
	/**
	 * 添加对象
	 * 主键自增？？？？？
	 */
	
	public void TestAddUser(){
		User u = new User();
		
		u.setName("主键自增测试2");
		u.setPassword("122");
		userServiceImpl.addUser(u);
		
	}
	
	@Test
	//删除对象
	public void TestRemoveUser(){
		userServiceImpl.removeUser(2);
	}
	
	@Test
	//修改对象信息
	public void TestUpdateUser(){
		User u = new User();
		u.setId(1);
		u.setName("修改张三的名字");
		u.setPassword("修改密码");
		userServiceImpl.updateUser(u);
	}
	
	@Test
	//模糊查询
	public void TestFindUserLike(){
		User u = new User();
		
		u.setName("四");
		User user = userServiceImpl.findUserLike(u);
		System.out.println(user);	
	}
	
	@Test
	//分页查询
	public void TestSelectUserByPage(){
		Map<String, Object> map= new HashMap<>();
		map.put("firstpage", 0);
		map.put("pagesize", 3);
		List<User> list = userServiceImpl.selectUserByPage(map);
		System.out.println(list);
		
	}

}
