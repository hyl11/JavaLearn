package com.tankGame1;
import java.awt.*;

import javax.swing.*;

/*
 * »­³ötank
 * 
 * */

public class TankGame1 extends JFrame{

	MyPanel  mp = null;
	public static void main(String[] args) {
		TankGame1 tm = new TankGame1();
	
	}
	
	public TankGame1() {
		mp = new MyPanel();
		this.add(mp);
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}

class MyPanel extends JPanel{
	
	MyTank hero_Tank  = null;
	
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0,400, 300);
		//»­³ötank
		draw_Tank(hero_Tank.getX(), hero_Tank.getY(), g, 0, 0);
		
	}
	public void draw_Tank(int x,int y,Graphics g,int direc,int color) {
		switch(color) {
		case 0:
			g.setColor(Color.YELLOW);
			break;
		case 1:
			g.setColor(Color.green);
			break;
		}
		
		switch(direc) {
		case 0:
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x+15, y, 5, 30,false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.fillOval(x+5, y+10, 10,10);
			g.drawLine(x+10, y+15, x+10, y);
			break;
		}
	}
	public MyPanel() {
		hero_Tank = new MyTank(10,10);
	}
}

class MyTank extends Tank{
	
	public MyTank(int x,int y) {
		super(x,y);
	}
}

class Tank{
	
	int x,y;
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public Tank(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
}