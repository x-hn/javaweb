package com.xhn.Service;

import java.util.List;

import com.xhn.model.userInfo;

public interface IUserService {

	userInfo login(String username, String password);

	List<userInfo> getAll();

	int add(userInfo user);

	void delete(Integer id);

	userInfo get(int parseInt);

	void update(userInfo user);

}
