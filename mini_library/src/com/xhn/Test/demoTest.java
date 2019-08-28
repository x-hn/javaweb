package com.xhn.Test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.xhn.DAO.IRecordDao;
import com.xhn.DAO.impel.ICategoryDaoImpel;
import com.xhn.DAO.impel.ILendDaoImpel;
import com.xhn.DAO.impel.IRecordDaoImpel;
import com.xhn.DAO.impel.IReserveDaoImpel;
import com.xhn.model.Category;
import com.xhn.model.Lend;
import com.xhn.model.Record;
import com.xhn.model.Reserve;


public class demoTest {
	@Test
	public void addTest() {
		IReserveDaoImpel impel = new IReserveDaoImpel();
		Reserve reserve=new Reserve();
		reserve.setUserId(10);
		reserve.setBookId(10);
		reserve.setReserveDate(new Date());
		reserve.setReserveStatus(20);
		int result = impel.add(reserve);
		System.out.println(result==1?"success":"fail");
	}
	@Test
	public void dTest() {
		IReserveDaoImpel impel = new IReserveDaoImpel();
		int result = impel.delete(1);
		System.out.println(result==1?"success":"fail");
	}
	@Test
	public void updateTest() {
		IReserveDaoImpel impel = new IReserveDaoImpel();
		Reserve reserve=new Reserve();
		reserve.setUserId(9);
		reserve.setBookId(2);
		reserve.setReserveDate(new Date());
		reserve.setReserveStatus(10);
		reserve.setId(1);
		int result = impel.update(reserve);
		System.out.println(result==1?"success":"fail");
	}
	@Test
	public void getTest() {
		IReserveDaoImpel impel = new IReserveDaoImpel();
		Reserve reserve=impel.get(1);
		System.out.println(reserve.toString());
	}
	@Test
	public void getAllTest() {
		IReserveDaoImpel impel = new IReserveDaoImpel();
		List r = impel.getAll();
		System.out.println(r);
	}
}
