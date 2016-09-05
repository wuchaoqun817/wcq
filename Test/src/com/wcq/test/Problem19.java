package com.wcq.test;

import java.util.Calendar;

public class Problem19 {
	
	
	
	private static boolean isLeapYear(int year){
		if(year%4==0&&year%100!=0||(year%400==0)){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		Calendar c=Calendar.getInstance();
		c.set(1901, 0, 1);
		/*while(c.get(Calendar.DAY_OF_WEEK)!=1){
			c.add(Calendar.DAY_OF_MONTH, 1);
		}*/
		int num=0;
		for(int i=1901;i<=2000;i++){
			num+=FirstSundayNum(i);
		}
		System.err.println(c.getTime());
		System.out.println(c.get(Calendar.MONTH));
		System.out.println(num);
//		System.out.println(c.get(Calendar.d));
	}
	
	private static int FirstSundayNum(int year){
		Calendar c=Calendar.getInstance();
		c.set(year,0,1);
		int num=0;
		while(c.get(Calendar.YEAR)==year){
			if(c.get(Calendar.DAY_OF_MONTH)==1&&c.get(Calendar.DAY_OF_WEEK)==1){
				num++;
			}
			c.add(Calendar.MONTH, 1);
		}
		return num;
	}
}
