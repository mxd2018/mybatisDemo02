package com.mxd.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mxd.dao.IUserDao;
import com.mxd.pojo.po.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-test.xml")
public class UserServiceImplTest2 {
	@Autowired
	private IUserDao iUserDao;
	@Test
	public void Test1(){
		List<User> list = iUserDao.findAllUser();
		System.out.println(list);
	}
}
