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
	 * ��ѯ��䣬ִ�д����sql���ִ�в�ѯ���������ز�ѯ�Ľ��
	 * ���ؽ���Ա����ʽ����
	 * �׳��쳣��ǿ���ϼ��ر��������
	 * @param limits(��ѯ���������,���� StuName=lili ),tableName��Ҫ��ѯ�ı������
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
			/*TODO û�ҵ���鷵�������м��еķ��������Ҵպ�һ��*/
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
	 * �����䣬�����ݿ����һ����Ϣ
	 * �׳��쳣
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
	 * ������
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
	 * ��sql�������������ʺŵȵ����ʹ�����ֱ�����ڴ���prepstmt;
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
