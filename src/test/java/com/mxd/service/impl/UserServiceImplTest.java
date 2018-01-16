package com.mxd.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.mxd.pojo.po.Address;
import com.mxd.pojo.po.User;

public class UserServiceImplTest {
	UserServiceImpl userServiceImpl;
	
	@Before
	public void init(){
		userServiceImpl=new UserServiceImpl();
	}
	
	@Test
	//join������ѯ
	public void TestfindByJoin(){
		List<User> users = userServiceImpl.findByJoin();
		//System.out.println(users);
		for(User user:users){
			System.out.println(user.getAddr().getId()+"-----"+user.getAddr().getName());
		}
	}
	
	@Test
	//join������ѯ2
	public void TestfindByJoin2(){
		List<User> users = userServiceImpl.findByJoin2();
		//System.out.println(users);
		for(User user:users){
			System.out.println(user.getOrders());
		}
	} 
	
	@Test
	/**
	 * select������ѯ1
	 * ע�⣺��Ϊ������Address��ʱname���������ݿ����addr�ֶ�û��ƥ��
	 * 	         �����AddressMapper�ļ���Ҫʹ�ñ����ķ�ʽƥ���ֶ�������
	 * �����е�getName()��������Ϊ��resultMap��ǩ�У�������property��column����
	 */
	public void TestfindBySelect(){
		List<User> users = userServiceImpl.findBySelect();
		for(User user:users){
			System.out.println(user.getAddr().getName());
		}
	}
	@Test
	/**
	 * select������ѯ2
	 * ע�⣺1.�˴�orders���е��ֶκ�Order���е���������ͬ����˲�������������
	 * 	   2.��ʱ�����ػ�δ��������˲�ѯ����л������Address
	 */
	public void TestfindBySelect2(){
		List<User> users = userServiceImpl.findBySelect2();
		for(User user:users){
			System.out.println(user.getOrders().get(1).getOname());
		}
	}
	
	
	@Test
	//��ѯ��������
	public void TestSelectById(){
		
		User user = userServiceImpl.findById(1);
		System.out.println(user);
	}
	
	@Test
	//һ���������
	public void TestSelectByCache(){
		userServiceImpl.findByCache(1);
	}
	
	@Test
	//�����������
	public void TestSelectByCache2(){
		userServiceImpl.findByCache2(1);
	}
	
	@Test
	//��ѯ���ж���
	public void TestFindAll(){
		List<User> list = userServiceImpl.findAll();
		System.out.println(list);	
	}
	
	@Test
	//��ѯ��ַΪaddr1��user����
	public void TestFindUserByAddr(){
		User user = new User();
		Address  address= new Address();
		address.setName("addr1");
		user.setAddr(address);
		
		User u = userServiceImpl.findUserByAddr(user );
		System.out.println(u);
	}
	
	@Test
	/**
	 * ��Ӷ���
	 * ������������������
	 */
	
	public void TestAddUser(){
		User u = new User();
		
		u.setName("������������3");
		u.setPassword("122");
		userServiceImpl.addUser(u);
		System.out.println(u.getId());
		
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
