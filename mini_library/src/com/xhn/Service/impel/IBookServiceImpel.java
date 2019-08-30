package com.xhn.Service.impel;

import java.util.List;

import com.xhn.DAO.IBookDao;
import com.xhn.DAO.ICategoryDao;
import com.xhn.DAO.impel.IBookDaoImpel;
import com.xhn.DAO.impel.ICategoryDaoImpel;
import com.xhn.Service.IBookService;
import com.xhn.model.Book;
import com.xhn.model.Category;

public class IBookServiceImpel implements IBookService {
	private IBookDao book =new IBookDaoImpel();
	private ICategoryDao category = new ICategoryDaoImpel();
	@Override
	public List<Book> getAll() {
		List<Book> list = this.book.getAll();
		if(list!=null && list.size()>0) {
			for(Book b:list) {
				if(b.getCategoryId()==1) {
					b.setCategoryName((category.get(1)).getCategoryName());
				}else if(b.getCategoryId()==2 || b.getCategoryId()==4) {
					b.setCategoryName((category.get(2)).getCategoryName());
				}else if(b.getCategoryId()==3) {
					b.setCategoryName((category.get(3)).getCategoryName());
				}else {
					b.setCategoryName((category.get(5)).getCategoryName());
				}
			}
		}
		return list;
	}
	@Override
	public int add(Book book) {
		return this.book.add(book);
	}
	@Override
	public void delete(Integer id) {
		this.book.delete(id);
	}

}
