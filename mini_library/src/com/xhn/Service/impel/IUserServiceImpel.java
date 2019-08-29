package com.xhn.Service.impel;

import java.util.List;

import com.xhn.DAO.IUserInfoDao;
import com.xhn.DAO.impel.IUserDaoImpel;
import com.xhn.Service.IUserService;
import com.xhn.constans.UserConstant;
import com.xhn.model.userInfo;

public class IUserServiceImpel implements IUserService {
	
	private IUserInfoDao userinfo = new IUserDaoImpel();

	@Override
	public userInfo login(String username, String password) {
		return this.userinfo.login(username,password);
	}

	@Override
	public List<userInfo> getAll() {
		List<userInfo> list=this.userinfo.getAll();
		if (list!=null && list.size()>0) {
			for(userInfo u:list) {
				if(u.getRole()==0) {
					u.setRoleName(UserConstant.ROLE_NAME_ADMIN);
				}else if(u.getRole()==1) {
					u.setRoleName(UserConstant.ROLE_NAME_TEACHER);
				}else if(u.getRole()==2) {
					u.setRoleName(UserConstant.ROLE_NAME_STUDENT);
				}else {
					u.setRoleName(UserConstant.ROLE_NAME_EMPTY);
				}
			}
		}
		return list;
	}

	@Override
	public int add(userInfo user) {
		return this.userinfo.add(user);
	}

}
