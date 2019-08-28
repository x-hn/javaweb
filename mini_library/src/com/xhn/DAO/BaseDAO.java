package com.xhn.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDAO{

	//指定mysql数据库驱动类
	private String driver="com.mysql.jdbc.Driver";
	//指定连接数据库的数据库连接字符串
	private String url="jdbc:mysql://127.0.0.1:3306/bms?useUnicode=yes&characterEncoding=UTF-8&useOldAliasMetadataBehavior=true";
	//指定用户名
	private String user="root";
	//指定用户名
	private String password="";
	
	protected Connection conn=null;
	protected PreparedStatement st=null;
	protected ResultSet rs=null;
	
	//加载数据库驱动
	{
		try {
			//加载数据库驱动到jvm
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//获取数据库连接
	protected Connection getConnecton() {
		
		Connection conn=null;
		
		try {
			//通过DriverManager获取一个到数据库的连接
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
		
	//关闭数据库资源
	protected void close(Connection conn,Statement st,ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}finally {
				if(st!=null) {
					try {
						st.close();
					} catch (SQLException e) {					
						e.printStackTrace();
					}finally {
						if(conn!=null) {
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}	
	/**
	 * 增删改
	 * @param sql
	 * @param params
	 * @return
	 */
	public int updateBySql(String sql,Object[] params) {		
		int  ret=0;
		conn=this.getConnecton();
		try {
			st=conn.prepareStatement(sql);			
			if(params!=null && params.length>0) {
				for(int i=0;i<params.length;i++) {
					st.setObject(i+1, params[i]);
				}
			}
			ret=st.executeUpdate();
						
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(conn, st, rs);
		}
		return ret;
	}
	
	public void queryBySql(String sql,Object[] params) {	
		conn=this.getConnecton();
		try {
			st=conn.prepareStatement(sql);			
			if(params!=null && params.length>0) {
				for(int i=0;i<params.length;i++) {
					st.setObject(i+1, params[i]);
				}
			}
			rs=st.executeQuery();						
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	

}