package com.thread;
/*
 * �߳�ע������
 * 1,�߳�һ������ֻ������һ��
 * 2���߳�ͬ��
 * */
public class Demo2 {

	public Demo2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Cat1 c = new Cat1();
//		Dog d = new Dog();
//		c.start();
//		d.start();
//		c.start();
		Ticket t1 = new Ticket();
		Ticket t2 = new Ticket();
		t1.start();
		t2.start();
		

	}
}
class Cat1 extends Thread{
	public void run() {
		System.out.println("11");
	}
}
class Dog extends Thread{
	public void run() {
		System.out.println("22");
		
	}
}
class Ticket extends Thread{
	static int totalTickets = 0;
	public void run() {
		while(totalTickets < 2000) {
			totalTickets ++;
			System.out.println(Thread.currentThread().getName() + " " + totalTickets);
		}
	}
}