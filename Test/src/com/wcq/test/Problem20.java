package com.wcq.test;

import java.math.BigInteger;

public class Problem20 {
	
	public static void main(String[] args){
		BigInteger fac=factorial(new BigInteger("100"));
		String s=fac.toString();
		int sum=0;
		for(int i=0;i<s.length();i++){
			sum+=Integer.parseInt(s.charAt(i)-48+"");			
		}
		System.out.println(sum);
	}
	
	private static BigInteger factorial(BigInteger  fac){	
		if(fac.intValue()==0){
			return new BigInteger("0");
		}else
		if(fac.intValue()==1) {
			return new BigInteger("1");
		}
		return fac.multiply(factorial(fac.subtract(new BigInteger("1")))) ;
	}
}