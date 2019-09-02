package com.xhn.DAO.impel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xhn.DAO.BaseDAO;
import com.xhn.DAO.IBookDao;
import com.xhn.model.Book;
import com.xhn.model.userInfo;

public class IBookDaoImpel extends BaseDAO implements IBookDao {

	@Override
	public int add(Book book) {
		String sql = "insert into book(bookName,bookNumber,categoryId,author,publisher) value(?,?,?,?,?)";
		Object[] params = new Object[] {book.getBookName(),book.getBookNumber(),book.getCategoryId(),book.getAuthor(),book.getPublisher()};
		return this.updateBySql(sql, params);
	}

	@Override
	public int delete(int id) {
		String sql = "delete from book where id=?";
		Object[] params = new Object[] {id};	
		return this.updateBySql(sql, params);
	}

	@Override
	public int update(Book book) {
		String sql = "update book set bookName=?,bookNumber=?,categoryId=?,author=?,publisher=? where id=?";
		Object[] params = new Object[] {book.getBookName(),book.getBookNumber(),book.getCategoryId(),book.getAuthor(),book.getPublisher(),book.getId()};
		return this.updateBySql(sql, params);
	}

	@Override
	public Book get(int id) {
		Book book = new Book();
		String sql = "select * from book where id="+id;
		Object[] params = new Object[] {};
		this.queryBySql(sql, params);
		try {
			while(rs.next()) {
				book.setId(rs.getInt("id"));
				book.setBookName(rs.getString("bookName"));
				book.setBookNumber(rs.getInt("bookNumber"));
				book.setCategoryId(rs.getInt("categoryId"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return book;
	}

	@Override
	public List<Book> getAll() {
		List<Book> list =new ArrayList<>();
		String sql = "select * from book";
		Object[] params = new Object[] {};
		this.queryBySql(sql, params);
		try {
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setBookName(rs.getString("bookName"));
				book.setBookNumber(rs.getInt("bookNumber"));
				book.setCategoryId(rs.getInt("categoryId"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return list;
	}

	@Override
	public List<Book> getAll(int page, int pageSizes) {
		List<Book> list=new ArrayList<>();
		String sql="select * from book limit ?,?";
		int beginIndex=(page-1)*pageSizes;
		Object[] obj=new Object[] {beginIndex,pageSizes};
		this.queryBySql(sql, obj);
		try {
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setBookName(rs.getString("bookName"));
				book.setBookNumber(rs.getInt("bookNumber"));
				book.setCategoryId(rs.getInt("categoryId"));
				book.setAuthor(rs.getString("author"));
				book.setPublisher(rs.getString("publisher"));
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return list;
	}

}
