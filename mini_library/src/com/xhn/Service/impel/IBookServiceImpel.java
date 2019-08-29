package com.xhn.Service.impel;

import java.util.List;

import com.xhn.DAO.IBookDao;
import com.xhn.DAO.impel.IBookDaoImpel;
import com.xhn.Service.IBookService;
import com.xhn.model.Book;

public class IBookServiceImpel implements IBookService {
	private IBookDao book =new IBookDaoImpel();
	@Override
	public List<Book> getAll() {
		return this.book.getAll();
	}

}
