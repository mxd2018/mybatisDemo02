package com.mxd.dao;

import java.util.List;
import java.util.Map;

import com.mxd.pojo.po.User;

public interface IUserDao {
	//join关联查询，左外链接查询
	List<User> findByJoin();
	
	List<User> findByJoin2();
	
	//select关联查询
	List<User> findBySelect();
	
	List<User> findByselect2();
	
	//查询单个对象
	User selectById(Integer id);
	
	//一级缓存测试
	User selectByCache(Integer id);
	
	//二级缓存测试
	User selectByCache2(Integer id);
	
	//获得所有对象
	List<User> findAllUser();
	
	//查询地址为addr1的user对象，通过外键查询
	User findUserByAddr(User user);
	
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
