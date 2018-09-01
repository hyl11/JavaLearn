package com.tankGame4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

import javax.swing.JPanel;
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
		//画出tank
		drawTank(hero_Tank.getX(), hero_Tank.getY(), g, hero_Tank.getDirection(),0);
		for(int i = 0; i < hero_Tank.bullet.size(); i ++) {
			Bullet b = hero_Tank.bullet.get(i);
			if(b != null && b.isAlive) {
				g.draw3DRect(b.x, b.y, 1, 1, false);
			}
			else if(b.isAlive == false)
				hero_Tank.bullet.remove(b);
		}
		for(int i = 0; i < enemySize; i ++) {
			EnemyTank tmp = enemys.get(i);
			for(int j =0; j < hero_Tank.bullet.size(); j ++) {
				Bullet b = hero_Tank.bullet.get(j);
				if(b.isAlive)
				    hitTank(b, tmp);
			}
			if(tmp.isAlive)
			    drawTank(tmp.getX(), tmp.getY(),g, tmp.getDirection(), tmp.getColor());
		}
		
		for(int i = 0; i < bombs.size(); i ++) {
			Bomb b = bombs.get(i);
			if(b.isAlive) {
				if(b.livetime > 6) {
					g.drawImage(i1, b.x, b.y, 30, 30,this);
					b.bombing();
				}
				else if(b.livetime > 3) {
					g.drawImage(i2, b.x, b.y, 30, 30,this);
				    b.bombing();
				}
				else {
					g.drawImage(i3, b.x, b.y, 30, 30,this);
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
	
	public void hitTank(Bullet b, EnemyTank et) {
		switch(et.getDirection()) {
		case Tank.UP:
		case Tank.DOWN:
			if(b.x > et.getX() && b.x < et.getX()+20 && b.y > et.getY() && b.y < et.getY()+30) {
				b.isAlive = false;
				et.isAlive = false;
				bombs.add(new Bomb(et.getX(), et.getY()));
			}
			break;
		case Tank.LEFT:
		case Tank.RIGHT:
            if(b.x > et.getX() && b.x < et.getX()+30 && b.y > et.getY()+5 && b.y < et.getY()+25) {
				b.isAlive = false;
				et.isAlive = false;
				bombs.add(new Bomb(et.getX(), et.getY()));
			}
			break;
		}
	}
	
	public MyPanel() {
		/*enemy tank*/
		hero_Tank = new HeroTank(100, 100);
		for(int i = 0; i < enemySize; i ++) {
			EnemyTank em = new EnemyTank(10+35*i, 10+35*i);
			em.setColor(1);
		    enemys.add(em);
		}
		Toolkit kit = Toolkit.getDefaultToolkit();
		i1 = kit.getImage("picture/picture1.png");
		i2 = kit.getImage("picture/picture2.png");
		i3 = kit.getImage("picture/picture3.png");
		
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
			
			this.repaint();
		}
	}
}