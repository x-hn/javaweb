package com.xhn.Service;

import java.util.List;

import com.xhn.model.Book;

public interface IBookService {

	List<Book> getAll();

	int add(Book book);

	void delete(Integer id);

	Book get(int parseInt);

	void update(Book book);

	List<Book> getAll(int page, int pageSizes);

}
