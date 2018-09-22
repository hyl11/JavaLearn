package com.utility;

import java.sql.*;
import java.util.Vector;

public class DataBase {

	String url = "jdbc:sqlserver://localhost:1433;databaseName=Testbase2";
	String usrName = "sa";
	String passwd = "7";
	Connection conn2data = null;
	PreparedStatement prepStmt = null;
	/**
	 * get a connection to database ,and always use this database;
	 */
	public DataBase() {
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn2data = DriverManager.getConnection(url,usrName,passwd);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * 查询语句，执行传入的sql语句执行查询操作并返回查询的结果
	 * 返回结果以表的形式返回
	 * 抛出异常，强制上级关闭相关连接
	 * @param limits(查询的限制语句,例如 StuName=lili ),tableName需要查询的表的名字
	 * @return
	 * @throws Exception
	 */
	public Vector< Vector<String> > queryInfo(Vector<String> limits,String tableName) throws Exception{
		String sql = "select * from " + tableName;
		sql = addLimits2Sql(sql, limits);
		
		Vector< Vector<String> > table = new Vector<>();
		prepStmt = conn2data.prepareStatement(sql);
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next()) {
			Vector<String> line = new Vector<String>();
			int colCount = 1;
			/*TODO 没找到检查返回数据有几列的方法，姑且凑合一下*/
			while(colCount < 5) {
				String value = rs.getString(colCount);
				line.add(value);
				colCount ++;
			}
			table.add(line);
		}
		if(prepStmt != null) {
			try {
				prepStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return table;
	}
	/**
	 * 添加语句，向数据库添加一条信息
	 * 抛出异常
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public int addInfo(Vector<String> insertData,String tableName) throws Exception{
		String sql = "insert into " + tableName;
		sql = comleleteInsertSql(sql, insertData.size());
		prepStmt = conn2data.prepareStatement(sql);
		for(int i = 0; i < insertData.size(); i ++) {
			prepStmt.setString(i+1, insertData.get(i));
		}
	    int ret = prepStmt.executeUpdate();
	    if(prepStmt != null) {
	    	try {
				prepStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    return ret;
	}
	/**
	 * 变更语句
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public int changeInfo(String sql) throws Exception{
		prepStmt = conn2data.prepareStatement(sql);
		int ret = prepStmt.executeUpdate();
		if(prepStmt != null) {
	    	try {
				prepStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    return ret;
	}
	/**
	 * @param limits 
	 * @param tableName 
	 * @return
	 * @throws Exception
	 */
	public int deleteInfo(Vector<String> limits, String tableName) throws Exception{
		String sql = "delete from " + tableName;
		sql = addLimits2Sql(sql, limits);
		prepStmt = conn2data.prepareStatement(sql);
		int ret =  prepStmt.executeUpdate();
		if(prepStmt != null) {
	    	try {
				prepStmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    return ret;
	}
	public void finalize() {
		try {
			if(conn2data != null)
				conn2data.close();
			if(prepStmt != null)
				prepStmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private String addLimits2Sql(String sql,Vector<String> limits) {
		if(limits != null && limits.size() != 0) {
			sql =sql +  " where (" + limits.get(0);
			for(int i = 1; i < limits.size(); i ++) {
				sql = sql + "," + limits.get(i);
			}
			sql += ")";
		}
		return sql;
	}
	/**
	 * 在sql插入语句上完成问号等的添加使其可以直接用于创建prepstmt;
	 * @param sql
	 * @param datasize
	 * @return
	 */
	private String comleleteInsertSql(String sql,int datasize) {
		sql += " values(?";
		for(int i = 1; i < datasize; i ++)
			sql += ",?";
		sql += ")";
		return sql;
	}
}
