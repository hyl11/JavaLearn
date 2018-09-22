package com.stuman;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

/*
 * 1��������ƣ�����ֳ��������֣������£�����Ϊ����JPanel���м���һ��JTable
 *    ��1�������JPanel���������JTextField���ı������
 *                           JLabel,     ��ʾ��Ϣ
 *                           JButton��       ��ѯ��ť
 *    ��2�������JPanel���õ����������JButton���ֱ����ɾ�������ӣ��޸�
 *    ��3���м��JTable��model�Ĺ��캯����ʼ������������ˢ��Table�ϵ�����,
 *        ���Ҽ��뵽JScrollPanel�У��������¹���
 *        
 * */

/*
 * ����������ƣ���Ϊ������Ҫˢ��JTable��������JFrame�����Ӽ�������
 * �����Ĳ��������ĸ�JButton�ĵ��
 * 
 * */

/*
 * �½�StuModel�࣬������ȡ��ص����ݿ����ݲ��ҹ����Ϊmodel�࣬����ֱ�ӳ�ʼ��Table
 * */
public class ShowView extends JFrame implements ActionListener {

	/*������صĽ������*/
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
		/*��ʼ��NorthPanel*/
		NorthPanel = new JPanel();
		InputField = new JTextField(10);
		Query = new JButton("query");
		Query.addActionListener(this);
		Meg = new JLabel("please input name");
		NorthPanel.add(Meg);
		NorthPanel.add(InputField);
		NorthPanel.add(Query);
		
		/*��ʼ��SouthPanel*/
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
		
		/*��ʼ���м��Table*/
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
