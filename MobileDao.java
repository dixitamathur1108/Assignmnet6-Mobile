package com.springcore.dao;

import java.util.List;

import com.springcore.pojo.Mobile;

public interface MobileDao {
	
	Mobile getMobileById(Integer id);

	List<Mobile> getAllMobiles();

	boolean deleteMobile(Mobile mobile);

	boolean updateMobile(Mobile mobile);

	boolean createMobile(Mobile mobile);

}
