package com.tankGame5;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

/*
 *1,����tank
 *2��tank�����ƶ�
 *3��hero���Է����ӵ�
 *4������tank��������ʧ
 *5���ұ����б�ը
 *
 *6����ֹ����tank�ص��˶�
 *7������Ϸʱ������ͣ�ͼ���
 *8����¼��ҳɼ�
 *9����������
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