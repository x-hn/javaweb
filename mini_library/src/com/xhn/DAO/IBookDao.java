package com.xhn.DAO;

import java.util.List;

import com.xhn.model.Book;

public interface IBookDao {
	public int add(Book book);
	
	public int delete(int id);
	
	public int update(Book book);
	
	public Book get(int id);
	
	public List<Book> getAll();

	public List<Book> getAll(int page, int pageSizes);
}
