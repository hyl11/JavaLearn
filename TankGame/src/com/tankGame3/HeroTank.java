package com.tankGame3;

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
		
		switch (this.direction) {
		case UP:
			bullet = new Bullet(x + 10, y,UP);
			break;
		case DOWN:
			bullet = new Bullet(x+10, y+30,DOWN);
			break;
		case LEFT:
			bullet = new Bullet(x, y+14,LEFT);
			break;
		case RIGHT:
			bullet = new Bullet(x+30, y+14,RIGHT);
			break;
		default:
			break;
		}
		Thread t = new Thread(bullet);
		t.start();
	}
	
}


