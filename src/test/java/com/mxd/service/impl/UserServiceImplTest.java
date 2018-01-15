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
	//��ѯ��������
	public void TestSelectById(){
		
		User user = userServiceImpl.findById(1);
		System.out.println(user);
	}
	
	@Test
	//��ѯ���ж���
	public void TestFindAll(){
		List<User> list = userServiceImpl.findAll();
		System.out.println(list);	
	}
	
	@Test
	/**
	 * ��Ӷ���
	 * ������������������
	 */
	
	public void TestAddUser(){
		User u = new User();
		
		u.setName("������������2");
		u.setPassword("122");
		userServiceImpl.addUser(u);
		
	}
	
	@Test
	//ɾ������
	public void TestRemoveUser(){
		userServiceImpl.removeUser(2);
	}
	
	@Test
	//�޸Ķ�����Ϣ
	public void TestUpdateUser(){
		User u = new User();
		u.setId(1);
		u.setName("�޸�����������");
		u.setPassword("�޸�����");
		userServiceImpl.updateUser(u);
	}
	
	@Test
	//ģ����ѯ
	public void TestFindUserLike(){
		User u = new User();
		
		u.setName("��");
		User user = userServiceImpl.findUserLike(u);
		System.out.println(user);	
	}
	
	@Test
	//��ҳ��ѯ
	public void TestSelectUserByPage(){
		Map<String, Object> map= new HashMap<>();
		map.put("firstpage", 0);
		map.put("pagesize", 3);
		List<User> list = userServiceImpl.selectUserByPage(map);
		System.out.println(list);
		
	}

}
