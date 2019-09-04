package com.xhn.DAO;

import java.util.List;

import com.xhn.model.Category;


public interface ICategoryDao {
public int add(Category category);
	
	public int delete(int id);
	
	public int update(Category category);
	
	public Category get(int id);
	
	public List<Category> getAll();

	public List<Category> getAll(int page, int pageSizes);
}
