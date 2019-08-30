package com.xhn.Service;

import java.util.List;

import com.xhn.model.Category;

public interface ICategoryService {

	int add(Category category);

	List<Category> getAll();

	void delete(int parseInt);

	Category get(int parseInt);

	void update(Category category);

}
