package com.tankGame4;

public class EnemyTank extends Tank implements Runnable{

	public EnemyTank(int x,int y) {
		super(x, y);
		this.color = 1;
		this.direction = Tank.DOWN;
		this.speed = 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int times = 1;
		while(true) {
			for (int i = 0; i < 30; i++) {
				try {
					Thread.sleep(50);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				switch (this.getDirection()) {
					case Tank.UP:
						if(y > 0)
						    y -= speed;
						break;
					case Tank.DOWN:
						if(y <300)
						    y += speed;
						break;
					case Tank.LEFT:
						if(x > 0)
						    x -= speed;
						break;
					case Tank.RIGHT:
						if(x < 400)
						    x += speed;
						break;
					}
			}
			//随机产生新的方向
			times ++;
			if(times % 5 == 0 && this.bullet.size() < 1)
				shotEnemy();
			this.setDirection((int)(Math.random()*4));
			if(!this.isAlive)
				break;
			
		}
	}

}
