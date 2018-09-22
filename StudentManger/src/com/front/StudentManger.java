package com.front;
import com.model.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
/*
* 1，界面设计，整体分成三个部分，上中下，上下为两个JPanel，中间是一个JTable
*    （1）上面的JPanel放置组件，JTextField，文本输入框，
*                           JLabel,     提示信息
*                           JButton，       查询按钮
*    （2）下面的JPanel放置的组件，三个JButton，分别代表删除，增加，修改
*    （3）中间的JTable用model的构造函数初始化，这样可以刷新Table上的数据,
*        并且加入到JScrollPanel中，可以上下滚动
*        
* */

/*
* 加入监听机制，因为操作需要刷新JTable，所以在JFrame上增加监听功能
* 监听的操作包括四个JButton的点击
* 
* */


public class StudentManger extends JFrame implements ActionListener {

	/*定义相关的界面组件*/
	JPanel NorthPanel=null,SouthPanel=null;
	JTable Table=null;
	JTextField InputField=null;
	JLabel Meg = null;
	JButton Query=null,Delete=null,Add=null,Change=null;
	JScrollPane Scroll = null;
	
	StudentModel stuModel = null;
	
	public static void main(String[] args) {
		StudentManger stm = new StudentManger();

	}
	
	public StudentManger() {
		/*初始化NorthPanel*/
		NorthPanel = new JPanel();
		InputField = new JTextField(10);
		Query = new JButton("query");
		Query.addActionListener(this);
		Meg = new JLabel("please input name");
		NorthPanel.add(Meg);
		NorthPanel.add(InputField);
		NorthPanel.add(Query);
		
		/*初始化SouthPanel*/
		SouthPanel = new JPanel();
		Delete = new JButton("delete");
		Delete.addActionListener(this);
		Add = new JButton("add");
		Add.addActionListener(this);
		Change = new JButton("change");
		Change.addActionListener(this);
		SouthPanel.add(Add);
		SouthPanel.add(Change);
		SouthPanel.add(Delete);
		
		/*初始化中间的Table*/
		stuModel = new StudentModel();
		stuModel.queryStudent(null);
		Table=new JTable(stuModel);
		Scroll=new JScrollPane(Table);
		this.add(NorthPanel,BorderLayout.NORTH);
		this.add(SouthPanel,BorderLayout.SOUTH);
		this.add(Scroll);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400,300);
		this.setVisible(true);
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(Query)) {
			query();
		}
		else if(e.getSource().equals(Delete)) {
			delete();
		}
		else if(e.getSource().equals(Add)) {
			add();
		}
		else if(e.getSource().equals(Change)) {
			change();
		}

	}
	public void query() {
		String name = InputField.getText();
		Vector<String> limits = new Vector<>();
		limits.add("StuName='" + name + "'");
		stuModel = new StudentModel();
		stuModel.queryStudent(limits);
		Table.setModel(stuModel);
	}
	public void delete() {
		int lineIndex = Table.getSelectedRow();
		Vector<String> line = (Vector<String>)stuModel.getTable().get(lineIndex);
		String name = line.get(1);
		Vector<String> limits = new Vector<>();
		limits.add("StuName='" + name + "'");
		stuModel = new StudentModel();
		stuModel.deleteStudent(limits);
		stuModel.queryStudent(null);
		Table.setModel(stuModel);
	}
	public void add() {
		new AddStudentDialog();
		stuModel = new StudentModel();
		stuModel.queryStudent(null);
		Table.setModel(stuModel);
	}
	public void change() {
		
	}

}
