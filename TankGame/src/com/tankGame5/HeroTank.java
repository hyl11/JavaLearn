package com.tankGame5;

import java.util.Vector;

class HeroTank extends Tank{

	public HeroTank(int x,int y) {
		super(x,y);
		this.color = 0;
	}
	/*tank ÏòÉÏÒÆ¶¯*/
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
	
}


