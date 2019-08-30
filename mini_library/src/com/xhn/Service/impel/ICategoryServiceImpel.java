package com.xhn.Service.impel;

import java.util.List;

import com.xhn.DAO.ICategoryDao;
import com.xhn.DAO.impel.ICategoryDaoImpel;
import com.xhn.Service.ICategoryService;
import com.xhn.model.Book;
import com.xhn.model.Category;

public class ICategoryServiceImpel implements ICategoryService {
	private ICategoryDao cate = new ICategoryDaoImpel();
	@Override
	public int add(Category category) {
		return this.cate.add(category);
	}
	@Override
	public List<Category> getAll() {
		return this.cate.getAll();
	}
	@Override
	public void delete(int parseInt) {
		this.cate.delete(parseInt);
	}
	@Override
	public Category get(int parseInt) {
		return this.cate.get(parseInt);
	}
	@Override
	public void update(Category category) {
		this.cate.update(category);
	}

}
