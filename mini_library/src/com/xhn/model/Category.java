package com.xhn.model;

public class Category {

	private int id;
	private String CategoryName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", CategoryName=" + CategoryName + "]";
	}
	
	
}
