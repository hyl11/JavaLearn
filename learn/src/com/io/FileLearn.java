package com.io;
import java.io.*;
/*
 * file 的基本方法
 * */
public class FileLearn {

	public FileLearn() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f = new File("src/com/draw/DrawPig.java");
		System.out.println("文件路径"+f.getAbsolutePath());
		//创建文件和文件夹
		File f2 = new File("src/com/io/test.txt");
		if(!f2.exists()) {
			try {
				f2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		File f3 = new File("src/test");
		if(!f3.isDirectory()) {
			f3.mkdir();
		}
		File f4 = new File("src/com");
		if(f4.isDirectory()) {
			File[] lists = f4.listFiles();
			for(File f0 : lists)
				System.out.println("文件"+f0.getName());
		}
		
	}

}
