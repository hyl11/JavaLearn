package com.thread;


/*两个线程同时运行*/
public class demo1 {

	public demo1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Count c = new Count(10);
		Thread tc = new Thread(c);
		Hello h = new Hello();
		Thread th = new Thread(h);
		tc.start();
		th.start();
	}

}
class Count implements Runnable{
	int n;
	int ans = 0;
	int times = 0;
	public Count(int n) {
		this.n = n;
	}
	public void run() {
		while(times < n) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			ans += (++times);
			System.out.println(ans);
		}
	}
}
class Hello implements Runnable{

	int n;
	int times = 0;
	public void run() {
		while(times < 10) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			times ++;
			System.out.println("输出第" + times + "个hello world！");
		}
	}
}
