package com.io;
import java.io.*;
/*
 * 1,字节流
 * 2，字符流
 * 
 *                      字节     字符
 * 输入         inputstream         Reader
 *输出          outputstream        writer
 *
 *       缓冲字符流
 *       BufferReader BufferWriter 基于上面的字节流或者字符流
 * */
/**
 * @author 11
 *
 */
public class IoLearn {

	public IoLearn() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		 FileReader fr = null;
		 BufferedReader br = null;
		 try {
			fr = new FileReader("src/com/io/FileLearn.java");
			br = new BufferedReader(fr);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				fr.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		// TODO Auto-generated method stub

	}

}
