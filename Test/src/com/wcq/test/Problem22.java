package com.wcq.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Problem22 {

	public static void main(String[] args) {
		File file=new File("problem22.txt");
		if(file.isFile()&&file.exists()){
			try {
				InputStreamReader read=new InputStreamReader(new FileInputStream(file), "UTF-8");
				BufferedReader reader=new BufferedReader(read);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
