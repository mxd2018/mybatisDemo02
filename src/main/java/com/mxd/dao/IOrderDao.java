package com.mxd.dao;

import java.util.List;

import com.mxd.pojo.po.Order;

public interface IOrderDao {
	Order selectById(Integer id);
	
	List<Order> selectByFK(Integer id);
}
