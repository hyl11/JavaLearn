package com.io;
import java.io.*;
/*
 * file �Ļ�������
 * */
public class FileLearn {

	public FileLearn() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f = new File("src/com/draw/DrawPig.java");
		System.out.println("�ļ�·��"+f.getAbsolutePath());
		//�����ļ����ļ���
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
				System.out.println("�ļ�"+f0.getName());
		}
		
	}

}
