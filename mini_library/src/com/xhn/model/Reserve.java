package com.xhn.model;

import java.util.Date;

public class Reserve {
	
	private int id;
	private int userId;
	private int bookId;
	private Date reserveDate;
	private int reserveStatus;
	
	
	
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
	public Date getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}
	public int getReserveStatus() {
		return reserveStatus;
	}
	public void setReserveStatus(int reserveStatus) {
		this.reserveStatus = reserveStatus;
	}
	@Override
	public String toString() {
		return "Reserve [id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", reserveDate=" + reserveDate
				+ ", reserveStatus=" + reserveStatus + "]";
	}
	
}
