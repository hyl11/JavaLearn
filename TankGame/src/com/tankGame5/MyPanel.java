package com.tankGame5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.*;
import java.awt.*;

class MyPanel extends JPanel implements KeyListener,Runnable{
	
	HeroTank hero_Tank  = null;
	Vector<EnemyTank> enemys = new Vector<>();
	Vector<Bomb> bombs = new Vector<>();
	int enemySize = 3;
	Image i1,i2,i3;
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0,400, 300);
		//画出hero_tank和子弹
		if(hero_Tank.isAlive)
		    drawTank(hero_Tank.getX(), hero_Tank.getY(), g, hero_Tank.getDirection(),0);
		for(int i = 0; i < hero_Tank.bullet.size(); i ++) {
			Bullet b = hero_Tank.bullet.get(i);
			if(b != null && b.isAlive) {
				g.draw3DRect(b.x, b.y, 1, 1, false);
			}
			else
				hero_Tank.bullet.remove(b);
		}
		//画出enemy_tank
		for(int i = 0; i < enemySize; i ++) {
			EnemyTank tmp = enemys.get(i);
			if(tmp.isAlive)
			    drawTank(tmp.getX(), tmp.getY(),g, tmp.getDirection(), tmp.getColor());
		    for(int j = 0;j < tmp.bullet.size(); j ++) {
		    	Bullet b = tmp.bullet.get(j);
		    	if(b != null && b.isAlive) {
		    		g.draw3DRect(b.x, b.y, 1, 1, false);
		    	}
		    	else {
		    		tmp.bullet.remove(b);
		    	}
		    }
		}
		//System.out.println("size = " + bombs.size());
		for(int i = 0; i < bombs.size(); i ++) {
			//System.out.println("get a bomb and its life is ");
			Bomb b = bombs.get(i);
			//System.out.println(b.livetime + "isalive" + b.isAlive);
			if(b.isAlive) {
				if(b.livetime > 6) {
				//	System.out.println("draw gif1");
					g.drawImage(i1, b.x, b.y, 20, 20,this);
					b.bombing();
				}
				else if(b.livetime > 3) {
				//	System.out.println("draw gif2");
					g.drawImage(i2, b.x, b.y, 20, 20,this);
				    b.bombing();
				}
				else {
				//	System.out.println("draw gif3");
					g.drawImage(i3, b.x, b.y, 20, 20,this);
					b.bombing();
				}
			}
			else {
				bombs.remove(b);
			}
		}
		
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
	
	public void hitTank(Bullet b, Tank t) {
		switch(t.getDirection()) {
		case Tank.UP:
		case Tank.DOWN:
			if(b.x > t.getX() && b.x < t.getX()+20 && b.y > t.getY() && b.y < t.getY()+30) {
				b.isAlive = false;
				t.isAlive = false;
				bombs.add(new Bomb(t.getX(), t.getY()));
			}
			break;
		case Tank.LEFT:
		case Tank.RIGHT:
            if(b.x > t.getX() && b.x < t.getX()+30 && b.y > t.getY()+5 && b.y < t.getY()+25) {
				b.isAlive = false;
				t.isAlive = false;
				bombs.add(new Bomb(t.getX(), t.getY()));
			}
			break;
		}
	}
	
	public MyPanel() {
		/*enemy tank*/
		hero_Tank = new HeroTank(100, 100);
		for(int i = 0; i < enemySize; i ++) {
			EnemyTank em = new EnemyTank(10+35*i, 10);
			em.setColor(1);
		    enemys.add(em);
		    Thread t = new Thread(em);
		    t.start();
		    //给敌人坦克添加子弹
		   em.shotEnemy();
		}
		Toolkit kit = Toolkit.getDefaultToolkit();
		i1 = kit.getImage("picture/bomb_1.gif");
		i2 = kit.getImage("picture/bomb_2.gif");
		i3 = kit.getImage("picture/bomb_3.gif");
		
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
			if(hero_Tank.bullet.size() < 5)
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
			//判断我的子弹是否击中敌人坦克
			for(int i = 0; i < enemySize; i ++) {
				EnemyTank tmp = enemys.get(i);
				for(int j =0; j < hero_Tank.bullet.size(); j ++) {
					Bullet b = hero_Tank.bullet.get(j);
					if(b.isAlive)
					    hitTank(b, tmp);
				}
			}
			//判断敌人坦克是否击中我的tank
			for(int i = 0; i < enemySize; i ++) {
				for(Bullet b : enemys.get(i).bullet) {
					if(b.isAlive)
						hitTank(b, hero_Tank);
				}
			}
			this.repaint();
		}
	}
}