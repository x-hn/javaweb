package com.xhn.DAO.impel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xhn.DAO.BaseDAO;
import com.xhn.DAO.IRecordDao;
import com.xhn.model.Record;

public class IRecordDaoImpel extends BaseDAO implements IRecordDao {

	@Override
	public int add(Record record) {
		String sql = "insert into record(userId,realname,bookId,bookName,lendDateTime,actualReturnTime) value(?,?,?,?,?,?)";
		Object[] params = new Object[] {record.getUserId(),record.getRealname(),record.getBookId(),record.getBookName(),record.getLendDateTime(),record.getActualReturnTime()};
		return this.updateBySql(sql, params);
	}

	@Override
	public int delete(int id) {
		String sql = "delete from record where id=?";
		Object[] params = new Object[] {id};	
		return this.updateBySql(sql, params);
	}

	@Override
	public int update(Record record) {
		String sql = "update record set userId=?,realname=?,bookId=?,bookName=?,lendDateTime=?,actualReturnTime=? where id=?";
		Object[] params = new Object[] {record.getUserId(),record.getRealname(),record.getBookId(),record.getBookName(),record.getLendDateTime(),record.getActualReturnTime(),record.getId()};
		return this.updateBySql(sql, params);
	}

	@Override
	public Record get(int id) {
		Record record = new Record();
		String sql = "select * from record where id="+id;
		Object[] params = new Object[] {};
		this.queryBySql(sql, params);
		try {
			while(rs.next()) {
				record.setUserId(rs.getInt("userId"));
				record.setRealname(rs.getString("realname"));
				record.setBookId(rs.getInt("bookId"));
				record.setBookName(rs.getString("bookName"));
				record.setLendDateTime(rs.getDate("lendDateTime"));
				record.setActualReturnTime(rs.getDate("actualReturnTime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return record;
	}

	@Override
	public List<Record> getAll() {
		List<Record> list = new ArrayList<>();
		String sql = "select * from record";
		Object[] params = new Object[] {};
		this.queryBySql(sql, params);
		try {
			while(rs.next()) {
				Record record = new Record();
				record.setUserId(rs.getInt("userId"));
				record.setRealname(rs.getString("realname"));
				record.setBookId(rs.getInt("bookId"));
				record.setBookName(rs.getString("bookName"));
				record.setLendDateTime(rs.getDate("lendDateTime"));
				record.setActualReturnTime(rs.getDate("actualReturnTime"));
				list.add(record);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return list;
	}

}
