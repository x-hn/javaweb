package com.xhn.DAO;

import java.util.List;

import com.xhn.model.userInfo;

public interface IUserInfoDao {
	public int add(userInfo userinfo);
	
	public int delete(int id);
	
	public int update(userInfo userinfo);
	
	public userInfo get(int id);
	
	public List<userInfo> getAll();

	public userInfo login(String username, String password);

	public List<userInfo> getAll(int page, int pageSizes);
}
