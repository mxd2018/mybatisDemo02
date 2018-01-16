package com.mxd.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mxd.dao.IUserDao;
import com.mxd.pojo.po.User;
import com.mxd.utils.DBUtil;

public class UserServiceImpl {
	//join关联查询
	public List<User> findByJoin(){
		SqlSession session = DBUtil.getSession();
		List<User> users =null;
		try {
			IUserDao userDao = session.getMapper(IUserDao.class);
			users = userDao.findByJoin();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return users;
	}
	
	public List<User> findByJoin2(){
		SqlSession session = DBUtil.getSession();
		List<User> users =null;
		try {
			IUserDao userDao = session.getMapper(IUserDao.class);
			users = userDao.findByJoin2();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return users;
	}
	
	//select关联查询
	public List<User> findBySelect(){
		SqlSession session = DBUtil.getSession();
		List<User> users =null;
		try {
			IUserDao userDao = session.getMapper(IUserDao.class);
			users = userDao.findBySelect();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return users;
	}
	
	public List<User> findBySelect2(){
		SqlSession session = DBUtil.getSession();
		List<User> users =null;
		try {
			IUserDao userDao = session.getMapper(IUserDao.class);
			users = userDao.findByselect2();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return users;
	}
	
	
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
	/**
	 * 一级缓存测试,sqlsession级别的缓存，会自动缓存不需要手动开启，一次session中
	 * 当进行增删改时，mybatis会自动刷新缓存
	 */
	public void findByCache(int id) {
		SqlSession session = DBUtil.getSession();
			//第一次查询
			IUserDao userDao = session.getMapper(IUserDao.class);
			User user = userDao.selectByCache(id);
			//第二次查询
			User user2 = userDao.selectByCache(id);
			
			System.out.println(user==user2);
			session.close();
	}
	
	/**
	 * 二级缓存测试，
	 * @return
	 */
	public void findByCache2(int id) {
		SqlSession session = DBUtil.getSession();
		//第一次查询
		IUserDao userDao = session.getMapper(IUserDao.class);
		User user = userDao.selectByCache2(id);
		session.close();
		
		//第二次查询
		SqlSession session2 = DBUtil.getSession();	
		IUserDao userDao2 = session2.getMapper(IUserDao.class);
		User user2 = userDao2.selectByCache2(id);
		session2.close();	
			
		System.out.println(user==user2);
			
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
	
	//查询地址为addr1的user对象
	public User findUserByAddr(User user){
		SqlSession session = DBUtil.getSession();
		User u = null;
		try {
			IUserDao userDao = session.getMapper(IUserDao.class);
			u = userDao.findUserByAddr(user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return u;
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
