package com.xhn.Service.impel;

import com.xhn.DAO.ILendDao;
import com.xhn.DAO.impel.ILendDaoImpel;
import com.xhn.Service.ILendService;

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

}
