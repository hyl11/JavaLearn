package com.tankGame3;

public class Bullet implements Runnable{

	int x;
	int y;
	int direction;
	int speed;
	boolean isAlive ;
	public Bullet(int x,int y,int direction) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.speed = 1;
		this.isAlive = true;
	}
	public void run() {
		while(true) {
			switch(direction) {
			case Tank.UP:
				y -= speed;
				break;
			case Tank.DOWN:
				y += speed;
				break;
			case Tank.LEFT:
				x -= speed;
				break;
			case Tank.RIGHT:
				x += speed;
				break;
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*ÅÐ¶Ï×Óµ¯ÊÇ·ñµ½±ßÔµ*/
			if(x < 0 || x > 400 || y < 0 || y > 300)
				isAlive = false;
			//×Óµ¯ËÀÍö
			if(!isAlive)
				break;
		}
	}

}
