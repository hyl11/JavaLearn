package com.model;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.utility.DataBase;

public class StudentModel extends AbstractTableModel {

	
	Vector< Vector<String> > table=null;

	Vector<String> colNames=null;
	DataBase dataBase = null;
	String tableName = "Student";
	public StudentModel() {
		dataBase = new DataBase();
		colNames = new Vector<>();
		
		colNames.add("StuID");
		colNames.add("StuName");
		colNames.add("StuAge");
		colNames.add("StuDept");
		
	}
	public void queryStudent(Vector<String> limits) {
		try {
			table = dataBase.queryInfo(limits,tableName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public int addStudent(Vector<String> insertData) {
		int ret = -1;
		try {
			ret = dataBase.addInfo(insertData,tableName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return ret;
	}
	public int deleteStudent(Vector<String> limits) {
		int ret = -1;
		try {
			ret = dataBase.deleteInfo(limits, tableName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}
	public int changeStudent(String sql) {
		int ret = -1;
		try {
			ret = dataBase.changeInfo(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return ret;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return table.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colNames.size();
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)colNames.get(column);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector<String>)table.get(rowIndex)).get(columnIndex);
	}
	public Vector< Vector<String> > getTable() {
		return table;
	}
	public Vector<String> getColNames() {
		return colNames;
	}

}
