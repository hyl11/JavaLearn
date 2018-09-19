package com.listen;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/*
 * 事件处理，改变panel颜色
 * */
public class Change_color extends JFrame implements ActionListener{

	MyPanel jp = null;
	JButton jb1 = null;
	JButton jb2 = null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Change_color cc = new Change_color();
	}
	public Change_color() {
		jp = new MyPanel();
		jb1 = new JButton("black");
		jb2 = new JButton("red");
		
		this.add(jb1,BorderLayout.NORTH);
		this.add(jb2,BorderLayout.SOUTH);
		this.add(jp);
		
		//注册监听,制定act命令
		jb1.addActionListener(this);
		jb1.setActionCommand("black");
		jb2.addActionListener(this);
		jb2.setActionCommand("red");
		
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
	}
	//事件监听处理的方法
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getActionCommand().equals("black")) {
			jp.setBackground(Color.BLACK);
		}
		else {
			jp.setBackground(Color.RED);
		}
	}

}
class MyPanel extends JPanel{
	public void paint(Graphics g) {
		super.paint(g);
	}
	
}
