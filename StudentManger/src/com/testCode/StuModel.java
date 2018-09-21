package com.testCode;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import java.sql.*;
public class StuModel extends AbstractTableModel {

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)colName.get(column);
	}

	/*定义查询数据想干结构*/
	String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=Testbase2";
	Vector rowData,colName;
	ResultSet rs = null;
	
	public StuModel(String sql) {
		colName=new Vector<>();
		colName.add("StuID");
		colName.add("StuName");
		colName.add("StuAge");
		colName.add("StuDept");
		
		rowData=new Vector();
		PreparedStatement ps = null;
		Connection ct = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			ct=DriverManager.getConnection(url,"sa","7");
			ps=ct.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Vector line=new Vector<>();
				line.add(rs.getString(1));
				line.add(rs.getString(2));
				line.add(rs.getString(3));
				line.add(rs.getString(4));
				rowData.add(line);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				ct.close();
				ps.close();
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rowData.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colName.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)rowData.get(rowIndex)).get(columnIndex);
	}

}
