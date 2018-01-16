package com.mxd.dao;

import com.mxd.pojo.po.Address;

public interface IAddressDao {
	Address selectById(Integer id);
	
	Address selectByFK(Integer uid);
}
