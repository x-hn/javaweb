package com.xhn.DAO;

import java.util.List;

import com.xhn.model.Lend;


public interface ILendDao {
	public int add(Lend lend);
	public int delete(int id);
	
	public int update(Lend lend);
	
	public Lend get(int id);
	
	public List<Lend> getAll();
}