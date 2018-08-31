package com.tankGame3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JPanel;

class MyPanel extends JPanel implements KeyListener,Runnable{
	
	HeroTank hero_Tank  = null;
	Vector<EnemyTank> enemys = new Vector<>();
	int enemySize = 3;
	
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0,400, 300);
		//画出tank
		drawTank(hero_Tank.getX(), hero_Tank.getY(), g, hero_Tank.getDirection(),0);
		if(hero_Tank.bullet != null && hero_Tank.bullet.isAlive) {
			g.draw3DRect(hero_Tank.bullet.x, hero_Tank.bullet.y, 1, 1, false);
		}
//		for(int i = 0; i < enemySize; i ++) {
//			EnemyTank tmp = enemys.get(i);
//			drawTank(tmp.getX(), tmp.getY(),
//					  g, tmp.getDirection(), tmp.getColor());
//		}
	}
	public void drawTank(int x,int y,Graphics g,int direc,int color) {
		switch(color) {
		case 0:
			g.setColor(Color.YELLOW);
			break;
		case 1:
			g.setColor(Color.green);
			break;
		}
		
		switch(direc) {
		case Tank.UP:
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x+15, y, 5, 30,false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.fillOval(x+5, y+10, 10,10);
			g.drawLine(x+10, y+15, x+10, y);
			break;
		case Tank.LEFT:
			g.fill3DRect(x, y+5, 30, 5, false);
			g.fill3DRect(x, y+20, 30, 5,false);
			g.fill3DRect(x+5, y+10, 20, 10, false);
			g.fillOval(x+10, y+10, 10,10);
			g.drawLine(x, y+15, x+15, y+15);
			break;
		case Tank.DOWN:
			g.fill3DRect(x, y, 5, 30, false);
			g.fill3DRect(x+15, y, 5, 30,false);
			g.fill3DRect(x+5, y+5, 10, 20, false);
			g.fillOval(x+5, y+10, 10,10);
			g.drawLine(x+10, y+15, x+10, y+30);
			break;
		case Tank.RIGHT:
			g.fill3DRect(x, y+5, 30, 5, false);
			g.fill3DRect(x, y+20, 30, 5,false);
			g.fill3DRect(x+5, y+10, 20, 10, false);
			g.fillOval(x+10, y+10, 10,10);
			g.drawLine(x+30, y+15, x+15, y+15);
			break;
		}
	}
	public MyPanel() {
		/*enemy tank*/
		hero_Tank = new HeroTank(100, 100);
		for(int i = 0; i < enemySize; i ++) {
			EnemyTank em = new EnemyTank(10+35*i, 10+35*i);
			em.setColor(0);
		    enemys.add(em);
		}
	}
	
	@Override/*wasd表示上下左右移动  */
	public void keyPressed(KeyEvent arg0) {
		/*设置坦克方向*/
		if(arg0.getKeyCode() == KeyEvent.VK_W) {
			this.hero_Tank.setDirection(Tank.UP);
			this.hero_Tank.moveDirect(Tank.UP);
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_A) {
			this.hero_Tank.setDirection(Tank.LEFT);
			this.hero_Tank.moveDirect(Tank.LEFT);
		} 
		else if(arg0.getKeyCode() == KeyEvent.VK_S) {
			this.hero_Tank.setDirection(Tank.DOWN);
			this.hero_Tank.moveDirect(Tank.DOWN);
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_D) {
			this.hero_Tank.setDirection(Tank.RIGHT);
			this.hero_Tank.moveDirect(Tank.RIGHT);
		}
		//发射子弹
		if(arg0.getKeyCode() == KeyEvent.VK_J) {
			this.hero_Tank.shotEnemy();
		} 
		repaint();
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		/*设置坦克方向*/
		if(arg0.getKeyCode() == KeyEvent.VK_W) {
			this.hero_Tank.setDirection(Tank.UP);
			this.hero_Tank.moveDirect(Tank.UP);
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_A) {
			this.hero_Tank.setDirection(Tank.LEFT);
			this.hero_Tank.moveDirect(Tank.LEFT);
		} 
		else if(arg0.getKeyCode() == KeyEvent.VK_S) {
			this.hero_Tank.setDirection(Tank.DOWN);
			this.hero_Tank.moveDirect(Tank.DOWN);
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_D) {
			this.hero_Tank.setDirection(Tank.RIGHT);
			this.hero_Tank.moveDirect(Tank.RIGHT);
		}
		repaint();
		
	}
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO: handle exception
			}
			this.repaint();
		}
	}
}