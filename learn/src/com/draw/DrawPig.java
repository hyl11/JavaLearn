package com.draw;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawPig extends JFrame{

	MyPanel mp = null;
	public DrawPig() {
		mp = new MyPanel();
		this.add(mp);
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		DrawPig dp = new DrawPig();
	}
}
class MyPanel extends JPanel{
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.pink);
		g.fillOval(10, 20, 30, 20);
		g.fillRect(17, 40, 2, 8);
		g.fillRect(32, 40, 2, 8);
		g.fillRect(40, 26, 5, 8);
		g.drawLine(30, 15, 26, 21);
		g.drawLine(30, 15, 34, 23);
		g.drawArc(5, 10, 15, 15, 180, 90);
		g.setColor(Color.black);
		g.fillOval(28, 28, 3, 3);
	}
}
