package com.tankGame4;

import java.util.Vector;

class HeroTank extends Tank{

	public HeroTank(int x,int y) {
		super(x,y);
		this.color = 0;
	}
	/*tank œÚ…œ“∆∂Ø*/
	public void moveDirect(int direct) {
		switch (direct) {
		case 0:
			y -= speed;
			break;
		case 1:
			x -= speed;
			break;
		case 2:
			y += speed;
			break;
		case 3:
			x += speed;
			break;
		default:
			break;
		}
	}
	public void shotEnemy() {
		Bullet bu = null;
		switch (this.direction) {
		case UP:{
			bu = new Bullet(x + 10, y,UP);
			bullet.add(bu);
			break;
		}
		case DOWN:{
			bu = new Bullet(x+10, y+30,DOWN);
			bullet.add(bu);
			break;
		}
		case LEFT:{
			bu = new Bullet(x, y+14,LEFT);
			bullet.add(bu);
			break;
		}
		case RIGHT:{
			bu = new Bullet(x+30, y+14,RIGHT);
			bullet.add(bu);
			break;
		}
		default:
			break;
		}
		Thread t = new Thread(bu);
		t.start();
	}
	
}


