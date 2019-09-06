package com.xhn.Service.impel;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

import com.xhn.DAO.IBookDao;
import com.xhn.DAO.ILendDao;
import com.xhn.DAO.impel.IBookDaoImpel;
import com.xhn.DAO.impel.ILendDaoImpel;
import com.xhn.Service.ILendService;
import com.xhn.constans.LendConstant;
import com.xhn.model.Book;
import com.xhn.model.Lend;
import com.xhn.model.userInfo;

public class ILendServiceImpel implements ILendService {
	private ILendDao lendao = new ILendDaoImpel();
	
	private IBookDao bookdao = new IBookDaoImpel();
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
	@Override
	public List<Lend> get(int userid) {
		List<Lend> list = this.lendao.getUserId(userid);
		Lend lend = this.lendao.getUser(userid);
		Book book = this.bookdao.get(lend.getBookId());
		for(Lend l:list) {
			l.setBookName(book.getBookName());
		}
		return list;
	}
	@Override
	public Lend getLend(int parseInt) {
		return this.lendao.get(parseInt);
	}
	@Override
	public int delete(int id) {
		return this.lendao.delete(id);
	}
	@Override
	public int record(int userid, int bookid) {
		return this.lendao.countByBookIdUserId(userid,bookid);
	}
	
}
