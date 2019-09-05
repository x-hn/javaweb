package com.xhn.model;

import java.util.Date;

public class Lend {

	private int id;
	private int userId;
	private int bookId;
	private Date lendDateTime;//借阅时间	
	private Date estimateReturnTime;//预计归还时间	
	private String bookName;
	
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
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public Date getLendDateTime() {
		return lendDateTime;
	}
	public void setLendDateTime(Date lendDateTime) {
		this.lendDateTime = lendDateTime;
	}	
	public Date getEstimateReturnTime() {
		return estimateReturnTime;
	}
	public void setEstimateReturnTime(Date estimateReturnTime) {
		this.estimateReturnTime = estimateReturnTime;
	}
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	@Override
	public String toString() {
		return "Lend [id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", lendDateTime=" + lendDateTime
				+ ", estimateReturnTime=" + estimateReturnTime + "]";
	}
	
}
