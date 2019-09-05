package com.xhn.Service.impel;

import com.xhn.DAO.IRecordDao;
import com.xhn.DAO.impel.IRecordDaoImpel;
import com.xhn.Service.IRecordService;
import com.xhn.model.Record;

public class IRecordServiceImpel implements IRecordService {
	IRecordDao recoreDao = new IRecordDaoImpel();
	@Override
	public int add(Record record) {
		return this.recoreDao.add(record);
	}

}
