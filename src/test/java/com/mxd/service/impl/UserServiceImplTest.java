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
	//join关联查询
	public void TestfindByJoin(){
		List<User> users = userServiceImpl.findByJoin();
		//System.out.println(users);
		for(User user:users){
			System.out.println(user.getAddr().getId()+"-----"+user.getAddr().getName());
		}
	}
	
	@Test
	//join关联查询2
	public void TestfindByJoin2(){
		List<User> users = userServiceImpl.findByJoin2();
		//System.out.println(users);
		for(User user:users){
			System.out.println(user.getOrders());
		}
	} 
	
	@Test
	/**
	 * select关联查询1
	 * 注意：因为在设置Address类时name属性与数据库表中addr字段没有匹配
	 * 	         因此在AddressMapper文件中要使用别名的方式匹配字段与属性
	 * 上文中的getName()可行是因为在resultMap标签中，配置了property与column属性
	 */
	public void TestfindBySelect(){
		List<User> users = userServiceImpl.findBySelect();
		for(User user:users){
			System.out.println(user.getAddr().getName());
		}
	}
	@Test
	/**
	 * select关联查询2
	 * 注意：1.此处orders表中的字段和Order类中的属性名相同，因此不存在上述问题
	 * 	   2.此时懒加载还未开启，因此查询语句中会关联出Address
	 */
	public void TestfindBySelect2(){
		List<User> users = userServiceImpl.findBySelect2();
		for(User user:users){
			System.out.println(user.getOrders().get(1).getOname());
		}
	}
	
	
	@Test
	//查询单个对象
	public void TestSelectById(){
		
		User user = userServiceImpl.findById(1);
		System.out.println(user);
	}
	
	@Test
	//一级缓存测试
	public void TestSelectByCache(){
		userServiceImpl.findByCache(1);
	}
	
	@Test
	//二级缓存测试
	public void TestSelectByCache2(){
		userServiceImpl.findByCache2(1);
	}
	
	@Test
	//查询所有对象
	public void TestFindAll(){
		List<User> list = userServiceImpl.findAll();
		System.out.println(list);	
	}
	
	@Test
	//查询地址为addr1的user对象
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
	 * 添加对象
	 * 主键自增？？？？？
	 */
	
	public void TestAddUser(){
		User u = new User();
		
		u.setName("主键自增测试3");
		u.setPassword("122");
		userServiceImpl.addUser(u);
		System.out.println(u.getId());
		
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
