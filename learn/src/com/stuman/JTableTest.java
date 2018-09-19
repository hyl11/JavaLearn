package com.stuman;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/*JTable 使用*/
import javax.swing.*;
public class JTableTest extends JFrame implements ActionListener{

	/*行数据和列名*/
	Vector rowData,colName;
	JTable jt=null;
	JScrollPane jsp=null;
	public JTableTest() {
		// TODO Auto-generated constructor stub
		colName=new Vector<>();
		colName.add("StuID");
		colName.add("StuName");
		colName.add("StuAge");
		colName.add("StuDept");
		
		rowData=new Vector();
		Vector line=new Vector<>();
		line.add("1234");
		line.add("aaa");
		line.add("500");
		line.add("CS");
		rowData.add(line);
		jt=new JTable(rowData, colName);
		jsp=new JScrollPane(jt);
		this.add(jsp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,300);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

		JTableTest jtt=new JTableTest();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
