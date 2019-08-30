package com.xhn.Service;

import java.util.List;

import com.xhn.model.Book;

public interface IBookService {

	List<Book> getAll();

	int add(Book book);

	void delete(Integer id);

}
