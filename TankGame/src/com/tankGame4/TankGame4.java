package com.tankGame4;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

/*
 * tankgame2.0
 * 画出tank
 * 实现坦克的移动
 * 
 * */

public class TankGame4 extends JFrame{

	MyPanel  mp = null;
	public static void main(String[] args) {
		TankGame4 tm = new TankGame4();
	
	}
	
	public TankGame4() {
		mp = new MyPanel();
		Thread t = new Thread(mp);
		t.start();
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}