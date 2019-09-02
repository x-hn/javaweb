package com.xhn.DAO.impel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xhn.DAO.BaseDAO;
import com.xhn.DAO.IUserInfoDao;
import com.xhn.model.userInfo;

public class IUserDaoImpel extends BaseDAO implements IUserInfoDao {

	@Override
	public int add(userInfo userinfo) {
		String sql = "insert into userinfo(username,realname,email,password,role,maxNumber) value(?,?,?,?,?,?)";
		Object[] params = new Object[] {userinfo.getUsername(),userinfo.getRealname(),userinfo.getEmail(),userinfo.getPassword(),userinfo.getRole(),userinfo.getMaxNumber()};	
		return this.updateBySql(sql, params);
	}

	@Override
	public int delete(int id) {
		String sql = "delete from userinfo where id=?";
		Object[] params = new Object[] {id};	
		return this.updateBySql(sql, params);
	}

	@Override
	public int update(userInfo userinfo) {
		String sql = "update userinfo set username=?,realname=?,email=?,password=?,role=?,maxNumber=? where id=?";
		Object[] params = new Object[] {userinfo.getUsername(),userinfo.getRealname(),userinfo.getEmail(),userinfo.getPassword(),userinfo.getRole(),userinfo.getMaxNumber(),userinfo.getId()};	
		return this.updateBySql(sql, params);
	}

	@Override
	public userInfo get(int id) {
		userInfo userinfo = new userInfo();
		String sql = "select * from userinfo where id="+id;
		Object[] params = new Object[] {};
		this.queryBySql(sql, params);
		try {
			while(rs.next()) {
				userinfo.setId(rs.getInt("id"));
				userinfo.setUsername(rs.getString("username"));
				userinfo.setRealname(rs.getString("realname"));
				userinfo.setEmail(rs.getString("email"));
				userinfo.setPassword(rs.getString("password"));
				userinfo.setRole(rs.getInt("role"));
				userinfo.setMaxNumber(rs.getInt("maxNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return userinfo;
	}

	@Override
	public List<userInfo> getAll() {
		List<userInfo> list= new ArrayList<>();
		String sql = "select * from userinfo";
		Object[] params = new Object[] {};
		this.queryBySql(sql, params);
		try {
			while(rs.next()) {
				userInfo userinfo = new userInfo();
				userinfo.setId(rs.getInt("id"));
				userinfo.setUsername(rs.getString("username"));
				userinfo.setRealname(rs.getString("realname"));
				userinfo.setEmail(rs.getString("email"));
				userinfo.setPassword(rs.getString("password"));
				userinfo.setRole(rs.getInt("role"));
				userinfo.setMaxNumber(rs.getInt("maxNumber"));
				list.add(userinfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return list;
	}

	@Override
	public userInfo login(String username, String password) {
		userInfo userinfo = null;
		String sql = "select * from userinfo where username=? and password=?";
		Object[] params = new Object[] {username,password};
		this.queryBySql(sql, params);
		try {
			while(rs.next()) {
				userinfo = new userInfo();
				userinfo.setId(rs.getInt("id"));
				userinfo.setUsername(rs.getString("username"));
				userinfo.setRealname(rs.getString("realname"));
				userinfo.setEmail(rs.getString("email"));
				userinfo.setPassword(rs.getString("password"));
				userinfo.setRole(rs.getInt("role"));
				userinfo.setMaxNumber(rs.getInt("maxNumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return userinfo;
	}

	@Override
	public List<userInfo> getAll(int page, int pageSizes) {
		List<userInfo> list=new ArrayList<>();
		String sql="select * from userinfo limit ?,?";
		int beginIndex=(page-1)*pageSizes;
		Object[] obj=new Object[] {beginIndex,pageSizes};
		this.queryBySql(sql, obj);
		try {
			while(rs.next()) {
				userInfo userinfo = new userInfo();
				userinfo.setId(rs.getInt("id"));
				userinfo.setUsername(rs.getString("username"));
				userinfo.setRealname(rs.getString("realname"));
				userinfo.setEmail(rs.getString("email"));
				userinfo.setPassword(rs.getString("password"));
				userinfo.setRole(rs.getInt("role"));
				userinfo.setMaxNumber(rs.getInt("maxNumber"));
				list.add(userinfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.close(conn, st, rs);
		}
		return list;
	}

}
