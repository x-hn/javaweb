package com.xhn.Service.impel;

import java.util.List;

import com.xhn.DAO.IUserInfoDao;
import com.xhn.DAO.impel.IUserDaoImpel;
import com.xhn.Service.ILendService;
import com.xhn.Service.IUserService;
import com.xhn.constans.UserConstant;
import com.xhn.model.userInfo;

public class IUserServiceImpel implements IUserService {
	
	private IUserInfoDao userinfo = new IUserDaoImpel();
	private ILendService lendService = new ILendServiceImpel();

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

	@Override
	public void delete(Integer id) {
		this.userinfo.delete(id);
	}

	@Override
	public userInfo get(int id) {
		userInfo user = this.userinfo.get(id);
		int myLendNumber = this.lendService.countByUserId(user.getId());
		user.setMyLendNumber(myLendNumber);
		return user;
	}

	@Override
	public void update(userInfo user) {
		this.userinfo.update(user);
	}

	@Override
	public List<userInfo> getAll(int page, int pageSizes) {
		List<userInfo> list=this.userinfo.getAll(page,pageSizes);
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
	public void updatePassword(userInfo userinfo) {
		this.userinfo.updatePassword(userinfo);
	}

}
