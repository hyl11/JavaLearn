package com.tankGame5;

public class Bomb {

	int x,y;
	int livetime;
	Boolean isAlive;
	public Bomb(int x,int y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		livetime = 9;
		isAlive = true;
	}
	public void bombing() {
		if(livetime > 0) {
			livetime --;
		}
		else {
			this.isAlive = false;
		}
	}

}
