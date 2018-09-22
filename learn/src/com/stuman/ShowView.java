package com.stuman;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

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

/*
 * 新建StuModel类，用来读取相关的数据库数据并且构造成为model类，可以直接初始化Table
 * */
public class ShowView extends JFrame implements ActionListener {

	/*定义相关的界面组件*/
	JPanel NorthPanel=null,SouthPanel=null;
	JTable Table=null;
	JTextField InputField=null;
	JLabel Meg = null;
	JButton Query=null,Delete=null,Add=null,Change=null;
	JScrollPane Scroll = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("b");
		ShowView sv = new ShowView();
	}
	
	public ShowView() {
		System.out.println("a");
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
		StuModel Stum = new StuModel("select * from Student");
		Table=new JTable(Stum);
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
		// TODO Auto-generated method stub
		if(e.getSource().equals(Query)) {
			String name = InputField.getText();
			StuModel Stum = new StuModel("select * from Student where StuName='" + name + "'");
			Table.setModel(Stum);
		}
	}

}
