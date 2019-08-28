package com.xhn.DAO.impel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xhn.DAO.BaseDAO;
import com.xhn.DAO.IReserveDao;
import com.xhn.model.Record;
import com.xhn.model.Reserve;

public class IReserveDaoImpel extends BaseDAO implements IReserveDao {

	@Override
	public int add(Reserve reserve) {
		String sql = "insert into reserve(userId,bookId,reserveDate,reserveStatus) value(?,?,?,?)";
		Object[] params = new Object[] {reserve.getUserId(),reserve.getBookId(),reserve.getReserveDate(),reserve.getReserveStatus()};
		return this.updateBySql(sql, params);
	}

	@Override
	public int delete(int id) {
		String sql = "delete from reserve where id=?";
		Object[] params = new Object[] {id};	
		return this.updateBySql(sql, params);
	}

	@Override
	public int update(Reserve reserve) {
		String sql = "update reserve set userId=?,bookId=?,reserveDate=?,reserveStatus=? where id=?";
		Object[] params = new Object[] {reserve.getUserId(),reserve.getBookId(),reserve.getReserveDate(),reserve.getReserveStatus(),reserve.getId()};
		return this.updateBySql(sql, params);
	}

	@Override
	public Reserve get(int id) {
		Reserve reserve = new Reserve();
		String sql = "select * from reserve where id="+id;
		Object[] params = new Object[] {};
		this.queryBySql(sql, params);
		try {
			while(rs.next()) {
				reserve.setUserId(rs.getInt("userId"));
				reserve.setBookId(rs.getInt("bookId"));
				reserve.setReserveDate(rs.getDate("reserveDate"));
				reserve.setReserveStatus(rs.getInt("reserveStatus"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return reserve;
	}

	@Override
	public List<Reserve> getAll() {
		List<Reserve> list = new ArrayList<Reserve>();
		String sql = "select * from reserve";
		Object[] params = new Object[] {};
		this.queryBySql(sql, params);
		try {
			while(rs.next()) {
				Reserve reserve = new Reserve();
				reserve.setUserId(rs.getInt("userId"));
				reserve.setBookId(rs.getInt("bookId"));
				reserve.setReserveDate(rs.getDate("reserveDate"));
				reserve.setReserveStatus(rs.getInt("reserveStatus"));
				list.add(reserve);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return list;
	}

}
