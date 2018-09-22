package com.front;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;
import com.model.*;
/*
 * 1,界面布局：上面连续四个文本框，用于输入添加的学生信息,每个前面有一个JLable，用于提示
 *           最下面是一个Panel，上面放置两个button，分别为确定和取消
 * 2,需要加入监听，对两个button分别监听
 * */
public class AddStudentDialog extends JDialog implements ActionListener{
	StudentModel stuModel = null;
	int inputSize = 0;
	Vector<String> colNames = null;
	/*界面组件*/
	JTextField[] inputFields = null;
	JLabel[] inputMesg = null;
	JButton yes = null,quit = null;
	JPanel[] panel = null;
	public AddStudentDialog() {
		stuModel = new StudentModel();
		this.setLayout(new GridLayout(5,1));
		colNames = stuModel.getColNames();
		inputSize = colNames.size();
		inputFields = new JTextField[inputSize];
		inputMesg = new JLabel[inputSize];
		panel = new JPanel[inputSize+1];
		for(int i = 0; i < inputSize; i ++) {
			inputFields[i] = new JTextField(10);
			inputMesg[i] = new JLabel(colNames.get(i));
			panel[i] = new JPanel();
			panel[i].add(inputMesg[i]);
			panel[i].add(inputFields[i]);
			this.add(panel[i]);
		}
		quit = new JButton("quit");
		quit.addActionListener(this);
		yes = new JButton("yes");
		yes.addActionListener(this);
		panel[inputSize] = new JPanel();
		panel[inputSize].add(quit);
		panel[inputSize].add(yes);
		this.add(panel[inputSize]);
		this.setSize(300,400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(quit)) {
			this.dispose();
		}
		else {
			Vector<String> insertData = new Vector<>();
			for(int i = 0; i < inputSize; i ++) {
				insertData.add(inputFields[i].getText());
			}
			stuModel.addStudent(insertData);
			this.dispose();
		}
	}

}
