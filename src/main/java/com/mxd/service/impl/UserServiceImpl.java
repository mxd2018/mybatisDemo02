package com.mxd.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mxd.dao.IUserDao;
import com.mxd.pojo.po.User;
import com.mxd.utils.DBUtil;

public class UserServiceImpl {
	//获得单个对象
	public User findById(int id) {
		SqlSession session = DBUtil.getSession();
		User user =null;
		try {
			IUserDao userDao = session.getMapper(IUserDao.class);
			user = userDao.selectById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return user;
	}
	//查询所有对象
	public List<User> findAll(){
		SqlSession session = DBUtil.getSession();
		List<User> list =null;
		
		try {
			IUserDao userDao = session.getMapper(IUserDao.class);
			list = userDao.findAllUser();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	/**
	 * 添加对象
	 * 注意：增删改操作都需要提交事务，因为mybatis默认取消了事务的自动提交，
	 * 结合spring时就不需要手动提交事务了
	 */
	
	public void addUser(User user){
		SqlSession session = DBUtil.getSession();
		
		try {
			IUserDao userDao = session.getMapper(IUserDao.class);
			userDao.insertUser(user);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}	
	}
	
	//删除对象
	public void removeUser(Integer id){
		SqlSession session = DBUtil.getSession();
		
		try {
			IUserDao userDao = session.getMapper(IUserDao.class);
			userDao.deleteUser(id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}	
	}
	
	//修改信息
	public void updateUser(User user){
		SqlSession session = DBUtil.getSession();
		
		try {
			IUserDao userDao = session.getMapper(IUserDao.class);
			userDao.updateUser(user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}	
	}
	
	/**
	 * 模糊查询
	 * '%#{name}%'这种OGNL---->表达式不行，需要使用EL表达式
	 * 使用EL表达式会存在sql注入问题，需要先将传入的参数过滤，去掉OR或and等会产生注入问题的内容 
	 */
	public User findUserLike(User user){
		SqlSession session = DBUtil.getSession();
		User u =null;
		try {
			IUserDao userDao = session.getMapper(IUserDao.class);
			u = userDao.findUserLike(user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return u;
	}
	
	/**
	 * 分页查询
	 */
	public List<User> selectUserByPage(Map<String, Object> map){
		SqlSession session = DBUtil.getSession();
		List<User> list =null;
		try {
			IUserDao userDao = session.getMapper(IUserDao.class);
			list = userDao.selectUserByPage(map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return list;
	}
}
