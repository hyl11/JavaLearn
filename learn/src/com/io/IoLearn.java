package com.io;
import java.io.*;
/*
 * 1,�ֽ���
 * 2���ַ���
 * 
 *                      �ֽ�     �ַ�
 * ����         inputstream         Reader
 *���          outputstream        writer
 *
 *       �����ַ���
 *       BufferReader BufferWriter ����������ֽ��������ַ���
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
