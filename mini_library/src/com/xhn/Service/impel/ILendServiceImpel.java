package com.xhn.Service.impel;

import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

import com.xhn.DAO.ILendDao;
import com.xhn.DAO.impel.ILendDaoImpel;
import com.xhn.Service.ILendService;
import com.xhn.constans.LendConstant;
import com.xhn.model.Lend;
import com.xhn.model.userInfo;

public class ILendServiceImpel implements ILendService {
	private ILendDao lendao=new ILendDaoImpel();
	@Override
	public int countByBookId(int id) {
		return this.lendao.countByBookId(id);
	}
	@Override
	public int countByUserId(int id) {
		return this.lendao.countByUserId(id);
	}
	@Override
	public int add(Lend lend) {
		userInfo userinfo = new userInfo();
		if(userinfo.getRole()==2) {
			lend.setEstimateReturnTime(DateUtils.addDays(new Date(),LendConstant.LEND_MAX_DAYS_STUDENT));
		}else {
			lend.setEstimateReturnTime(DateUtils.addDays(new Date(),LendConstant.LEND_MAX_DAYS_TEACHER));
		}
		return this.lendao.add(lend);
	}

}
