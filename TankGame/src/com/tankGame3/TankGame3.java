package com.tankGame3;
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

public class TankGame3 extends JFrame{

	MyPanel  mp = null;
	public static void main(String[] args) {
		TankGame3 tm = new TankGame3();
	
	}
	
	public TankGame3() {
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