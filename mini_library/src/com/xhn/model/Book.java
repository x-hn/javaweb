package com.xhn.model;

public class Book {
	private int id;
	private String bookName;//书名
	private int bookNumber;//数量
	private int categoryId;//分类编号
	private String author;//作者
	private String publisher;//出版社	
	
	private String categoryName;//分类名称
	
	public Book() {
		super();
	}
	
	
	public Book(String bookName, int bookNumber, int categoryId, String author, String publisher) {
		super();
		this.bookName = bookName;
		this.bookNumber = bookNumber;
		this.categoryId = categoryId;
		this.author = author;
		this.publisher = publisher;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(int bookNumber) {
		this.bookNumber = bookNumber;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", bookNumber=" + bookNumber + ", categoryId=" + categoryId
				+ ", author=" + author + ", publisher=" + publisher + "]";
	}
	
}
