package com.xhn.model;

import java.util.Date;

public class Record {

	private int id;
	private int userId;
	private String realname;
	private int bookId;
	private String bookName;
	private Date lendDateTime;
	private Date actualReturnTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}	
	public Date getLendDateTime() {
		return lendDateTime;
	}
	public void setLendDateTime(Date lendDateTime) {
		this.lendDateTime = lendDateTime;
	}
	public Date getActualReturnTime() {
		return actualReturnTime;
	}
	public void setActualReturnTime(Date actualReturnTime) {
		this.actualReturnTime = actualReturnTime;
	}
	@Override
	public String toString() {
		return "Record [id=" + id + ", userId=" + userId + ", realname=" + realname + ", bookId=" + bookId
				+ ", bookName=" + bookName + ", lendDateTime=" + lendDateTime + ", actualReturnTime=" + actualReturnTime
				+ "]";
	}
	
}
