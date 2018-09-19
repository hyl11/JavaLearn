package com.io;
import java.io.*;
public class Stream {

	public Stream() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File f = new File("src/com/io/FileLearn.java");
		FileInputStream input = null;
		try {
			input = new FileInputStream(f);
			byte[] data = new byte[1024];
			while(input.read(data) != -1) {
				//×Ö½Ú×ª»»³Éstr
				String s = new String(data);
				System.out.println(s);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
