package com.xhn.Service.impel;

import com.xhn.DAO.IUserInfoDao;
import com.xhn.DAO.impel.IUserDaoImpel;
import com.xhn.Service.IUserService;
import com.xhn.model.userInfo;

public class IUserServiceImpel implements IUserService {
	
	private IUserInfoDao userinfo = new IUserDaoImpel();

	@Override
	public userInfo login(String username, String password) {
		return this.userinfo.login(username,password);
	}

}
