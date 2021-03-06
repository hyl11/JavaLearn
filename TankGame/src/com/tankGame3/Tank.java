package com.tankGame3;


class Tank{
	
	static final int UP = 0,LEFT=1,DOWN=2,RIGHT=3;
	int x,y;
	/*tank方向，0123，分别代表上下左右*/
	int direction;
	/*tank speed*/
	int speed = 3;
	int color;
	
	Bullet bullet = null;
	
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public Tank(int x,int y) {
		this.x = x;
		this.y = y;
		this.color = 0;
	}
	public int getDirection() {
	    return direction;
    }

    public void setDirection(int direction) {
	    this.direction = direction;
    }
}

