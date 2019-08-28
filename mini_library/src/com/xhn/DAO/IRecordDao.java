package com.xhn.DAO;

import java.util.List;

import com.xhn.model.Record;

public interface IRecordDao {
	public int add(Record record);
	
	public int delete(int id);
	
	public int update(Record record);
	
	public Record get(int id);
	
	public List<Record> getAll();
}
