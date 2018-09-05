package com.tankGame5;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

/*
 *1,画出tank
 *2，tank可以移动
 *3，hero可以发射子弹
 *4，敌人tank被击中消失
 *5，我被击中爆炸
 *
 *6，防止敌人tank重叠运动
 *7，玩游戏时可以暂停和继续
 *8，记录玩家成绩
 *9，加入声音
 * 
 * */

public class TankGame5 extends JFrame{

	MyPanel  mp = null;
	public static void main(String[] args) {
		TankGame5 tm = new TankGame5();
	
	}
	
	public TankGame5() {
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