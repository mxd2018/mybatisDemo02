package com.mxd.dao;

import java.util.List;
import java.util.Map;

import com.mxd.pojo.po.User;

public interface IUserDao {
	//��ѯ��������
	User selectById(Integer id);
	
	//������ж���
	List<User> findAllUser();
	
	//��Ӷ���
	void insertUser(User user);
	
	//ɾ������
	void deleteUser(Integer id);
	
	//�޸Ķ�����Ϣ
	void updateUser(User user);
	
	//ģ����ѯ
	User findUserLike(User user);
	
	//��ҳ��ѯ	
	List<User> selectUserByPage(Map<String,Object> map);
}
