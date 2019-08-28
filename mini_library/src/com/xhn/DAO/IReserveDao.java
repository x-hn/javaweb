package com.xhn.DAO;

import java.util.List;

import com.xhn.model.Reserve;


public interface IReserveDao {
	public int add(Reserve reserve);
	
	public int delete(int id);
	
	public int update(Reserve reserve);
	
	public Reserve get(int id);
	
	public List<Reserve> getAll();
}
