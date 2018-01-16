package com.mxd.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mxd.dao.IUserDao;
import com.mxd.pojo.po.User;
import com.mxd.utils.DBUtil;

public class UserServiceImpl {
	//join������ѯ
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
	
	//select������ѯ
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
	
	
	//��õ�������
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
	 * һ���������,sqlsession����Ļ��棬���Զ����治��Ҫ�ֶ�������һ��session��
	 * ��������ɾ��ʱ��mybatis���Զ�ˢ�»���
	 */
	public void findByCache(int id) {
		SqlSession session = DBUtil.getSession();
			//��һ�β�ѯ
			IUserDao userDao = session.getMapper(IUserDao.class);
			User user = userDao.selectByCache(id);
			//�ڶ��β�ѯ
			User user2 = userDao.selectByCache(id);
			
			System.out.println(user==user2);
			session.close();
	}
	
	/**
	 * ����������ԣ�
	 * @return
	 */
	public void findByCache2(int id) {
		SqlSession session = DBUtil.getSession();
		//��һ�β�ѯ
		IUserDao userDao = session.getMapper(IUserDao.class);
		User user = userDao.selectByCache2(id);
		session.close();
		
		//�ڶ��β�ѯ
		SqlSession session2 = DBUtil.getSession();	
		IUserDao userDao2 = session2.getMapper(IUserDao.class);
		User user2 = userDao2.selectByCache2(id);
		session2.close();	
			
		System.out.println(user==user2);
			
	}
	
	
	//��ѯ���ж���
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
	
	//��ѯ��ַΪaddr1��user����
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
	 * ��Ӷ���
	 * ע�⣺��ɾ�Ĳ�������Ҫ�ύ������ΪmybatisĬ��ȡ����������Զ��ύ��
	 * ���springʱ�Ͳ���Ҫ�ֶ��ύ������
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
	
	//ɾ������
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
	
	//�޸���Ϣ
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
	 * ģ����ѯ
	 * '%#{name}%'����OGNL---->���ʽ���У���Ҫʹ��EL���ʽ
	 * ʹ��EL���ʽ�����sqlע�����⣬��Ҫ�Ƚ�����Ĳ������ˣ�ȥ��OR��and�Ȼ����ע����������� 
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
	 * ��ҳ��ѯ
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
