package com.tankGame2;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

/*
 * tankgame2.0
 * ����tank
 * ʵ��̹�˵��ƶ�
 * 
 * */

public class TankGame2 extends JFrame{

	MyPanel  mp = null;
	public static void main(String[] args) {
		TankGame2 tm = new TankGame2();
	
	}
	
	public TankGame2() {
		mp = new MyPanel();
		this.add(mp);
		this.addKeyListener(mp);
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}