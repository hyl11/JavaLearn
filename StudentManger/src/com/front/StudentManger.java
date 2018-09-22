package com.front;
import com.model.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
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


public class StudentManger extends JFrame implements ActionListener {

	/*������صĽ������*/
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
