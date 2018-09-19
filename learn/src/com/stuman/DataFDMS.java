package com.stuman;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Vector;
public class DataFDMS extends JFrame{

	Vector rowData,colName;
	JTable jt = null;
	JScrollPane jsp = null;
	ResultSet rs=null;
	String url="jdbc:sqlserver://127.0.0.1:1433;databaseName=Testbase2";
	public DataFDMS() {
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
			ps=ct.prepareStatement("select * from Student");
			rs=ps.executeQuery();
			while(rs.next()) {
				Vector line=new Vector<>();
				line.add(rs.getString(1));
				line.add(rs.getString(2));
				line.add(rs.getString(3));
				line.add(rs.getString(4));
				rowData.add(line);
			}
			jt=new JTable(rowData, colName);
			jsp=new JScrollPane(jt);
			this.add(jsp);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(400,300);
			this.setVisible(true);
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
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DataFDMS df=new DataFDMS();
	}

}
