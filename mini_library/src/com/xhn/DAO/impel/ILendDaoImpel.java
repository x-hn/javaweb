package com.xhn.DAO.impel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xhn.DAO.BaseDAO;
import com.xhn.DAO.ILendDao;
import com.xhn.model.Category;
import com.xhn.model.Lend;

public class ILendDaoImpel extends BaseDAO implements ILendDao {

	@Override
	public int add(Lend lend) {
		String sql = "insert into lend(userId,bookId,lendDateTime,estimateReturnTime) value(?,?,?,?)";
		Object[] params = new Object[] {lend.getUserId(),lend.getBookId(),lend.getLendDateTime(),lend.getEstimateReturnTime()};
		return this.updateBySql(sql, params);
	}

	@Override
	public int delete(int id) {
		String sql = "delete from lend where id=?";
		Object[] params = new Object[] {id};	
		return this.updateBySql(sql, params);
	}

	@Override
	public int update(Lend lend) {
		String sql = "update lend set userId=?,bookId=?,lendDateTime=?,estimateReturnTime=? where id=?";
		Object[] params = new Object[] {lend.getUserId(),lend.getBookId(),lend.getLendDateTime(),lend.getEstimateReturnTime(),lend.getId()};
		return this.updateBySql(sql, params);
	}

	@Override
	public Lend get(int id) {
		Lend lend = new Lend();
		String sql = "select * from lend where id="+id;
		Object[] params = new Object[] {};
		this.queryBySql(sql, params);
		try {
			while(rs.next()) {
				lend.setId(rs.getInt("id"));
				lend.setUserId(rs.getInt("userId"));
				lend.setBookId(rs.getInt("bookId"));
				lend.setLendDateTime(rs.getDate("lendDateTime"));
				lend.setEstimateReturnTime(rs.getDate("estimateReturnTime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return lend;
	}

	@Override
	public List<Lend> getAll() {
		List<Lend> list = new ArrayList<>();
		String sql = "select * from lend";
		Object[] params = new Object[] {};
		this.queryBySql(sql, params);
		try {
			while(rs.next()) {
				Lend lend = new Lend();
				lend.setId(rs.getInt("id"));
				lend.setUserId(rs.getInt("userId"));
				lend.setBookId(rs.getInt("bookId"));
				lend.setLendDateTime(rs.getDate("lendDateTime"));
				lend.setEstimateReturnTime(rs.getDate("estimateReturnTime"));
				list.add(lend);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return list;
	}
	
	@Override
	public int countByBookId(int id) {
		String sql = "select count(*) from lend where bookId=?";
		Object[] params = new Object[] {id};
		return this.count(sql, params);
	}

	@Override
	public int countByUserId(int id) {
		String sql = "select count(*) from lend where userId=?";
		Object[] params = new Object[] {id};
		return this.count(sql, params);
	}

	@Override
	public List<Lend> getUserId(int userid) {
		List<Lend> list = new ArrayList<>();
		String sql = "select * from lend where userId="+userid;
		Object[] params = new Object[] {};
		this.queryBySql(sql, params);
		try {
			while(rs.next()) {
				Lend lend = new Lend();
				lend.setId(rs.getInt("id"));
				lend.setUserId(rs.getInt("userId"));
				lend.setBookId(rs.getInt("bookId"));
				lend.setLendDateTime(rs.getDate("lendDateTime"));
				lend.setEstimateReturnTime(rs.getDate("estimateReturnTime"));
				list.add(lend);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return list;
	}

	@Override
	public Lend getUser(int userid) {
		Lend lend = new Lend();
		String sql = "select * from lend where userId="+userid;
		Object[] params = new Object[] {};
		this.queryBySql(sql, params);
		try {
			while(rs.next()) {
				lend.setId(rs.getInt("id"));
				lend.setUserId(rs.getInt("userId"));
				lend.setBookId(rs.getInt("bookId"));
				lend.setLendDateTime(rs.getDate("lendDateTime"));
				lend.setEstimateReturnTime(rs.getDate("estimateReturnTime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return lend;
	}

	@Override
	public int countByBookIdUserId(int userid, int bookid) {
		String sql = "select count(*) from lend where userId=? and bookId=?";
		Object[] params = new Object[] {userid,bookid};
		return this.count(sql, params);
	}

}
