package com.tankGame5;

import java.util.Vector;

public class EnemyGroup {

	static Vector<EnemyTank> enemyTanks = new Vector<>();
	public int enemySize = 0;
	
	public EnemyGroup(int enemySize) {
		//¥¥Ω®µ–»Àtank
		this.enemySize = enemySize;
		for(int i = 0; i < enemySize; i ++) {
			EnemyTank et = new EnemyTank(10+35*i, 10);
			enemyTanks.add(et);
			et.shotEnemy();
			Thread t = new Thread(et);
			t.start();
			
		}
	}
	public static boolean is2TankTouched(Tank tank) {
		switch(tank.getDirection()) {
		case Tank.UP:
		case Tank.DOWN:
			for(Tank t : enemyTanks) {
				if(t.equals(tank))
					continue;
				else if(t.getDirection() == Tank.UP || t.getDirection() == Tank.DOWN) {
					if(Math.abs(tank.getX() - t.getX()) <=20 && Math.abs(tank.getY() - t.getY()) <= 30)
						return true;
				}
				else if(t.getDirection() == Tank.LEFT || t.getDirection() == Tank.RIGHT) {
					if(Math.abs(tank.getX() - t.getX()) <=20 && Math.abs(tank.getY() - t.getY()) <= 20)
						return true;
				}
			}
			break;
		case Tank.LEFT:
		case Tank.RIGHT:
			for(Tank t : enemyTanks) {
				if(t.equals(tank))
					continue;
				else if(t.getDirection() == Tank.UP || t.getDirection() == Tank.DOWN) {
					if(Math.abs(tank.getX() - t.getX()) <=30 && Math.abs(tank.getY() - t.getY()) <= 30)
						return true;
				}
				else if(t.getDirection() == Tank.LEFT || t.getDirection() == Tank.RIGHT) {
					if(Math.abs(tank.getX() - t.getX()) <=30 && Math.abs(tank.getY() - t.getY()) <= 20)
						return true;
				}
			}
			break;
		}
		return false;
	}

}
