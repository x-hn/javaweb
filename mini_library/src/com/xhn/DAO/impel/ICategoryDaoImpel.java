package com.xhn.DAO.impel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xhn.DAO.BaseDAO;
import com.xhn.DAO.ICategoryDao;
import com.xhn.model.Book;
import com.xhn.model.Category;

public class ICategoryDaoImpel extends BaseDAO implements ICategoryDao {

	@Override
	public int add(Category category) {
		String sql = "insert into category(categoryName) value(?)";
		Object[] params = new Object[] {category.getCategoryName()};
		return this.updateBySql(sql, params);
	}

	@Override
	public int delete(int id) {
		String sql = "delete from category where id=?";
		Object[] params = new Object[] {id};	
		return this.updateBySql(sql, params);
	}

	@Override
	public int update(Category category) {
		String sql = "update category set categoryName=? where id=?";
		Object[] params = new Object[] {category.getCategoryName(),category.getId()};
		return this.updateBySql(sql, params);
	}

	@Override
	public Category get(int id) {
		Category category = new Category();
		String sql = "select * from category where id="+id;
		Object[] params = new Object[] {};
		this.queryBySql(sql, params);
		try {
			while(rs.next()) {
				category.setId(rs.getInt("id"));
				category.setCategoryName(rs.getString("categoryName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return category;
	}

	@Override
	public List<Category> getAll() {
		List<Category> list= new ArrayList<>();
		String sql = "select * from category";
		Object[] params = new Object[] {};
		this.queryBySql(sql, params);
		try {
			while(rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setCategoryName(rs.getString("categoryName"));
				list.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return list;
	}

	@Override
	public List<Category> getAll(int page, int pageSizes) {
		List<Category> list=new ArrayList<>();
		String sql="select * from category limit ?,?";
		int beginIndex=(page-1)*pageSizes;
		Object[] obj=new Object[] {beginIndex,pageSizes};
		this.queryBySql(sql, obj);
		try {
			while(rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("id"));
				category.setCategoryName(rs.getString("categoryName"));
				list.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return list;
	}

}
