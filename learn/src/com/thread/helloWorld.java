package com.thread;
/*
 * �̳�thread�������߳�
 * ʵ�� runnable
 * */
public class helloWorld {

	public helloWorld() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Cat cat = new Cat();
		/*�����߳�*/
		Thread t = new Thread(cat);
		t.start();
	}

}

class Cat implements Runnable{
	/*rewrite*/
	static int count = 0;
	public void run() {
		while(count < 10) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    System.out.println("hello world!");
		    count ++;
		}
	}
}
