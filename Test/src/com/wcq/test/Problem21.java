package com.wcq.test;

import java.util.ArrayList;
/**
 * 求10000以内的互满数         eg:f(a)=b&&f(b)=a------>   a, b 为互满数
 * @author wcq
 *
 */
public class Problem21 {

	public static void main(String[] args) {
		int sum=0;
		ArrayList<Integer> amicableNumbers=new ArrayList<Integer>();
		for(int i=3;i<10000;i++){
			boolean isAmicableNumber=false;
			for(int a:amicableNumbers){
				if(a==i){
					isAmicableNumber=true;
					break;
				}
			}
			if(isAmicableNumber){
				continue;
			}
			int temp=saveSumOfDivisors(i);
			for(int j=i+1;j<10000;j++){
				if(j!=temp){
					continue;
				}
				int temp2=saveSumOfDivisors(j);	
				if(j==temp&&i==temp2){
					amicableNumbers.add(temp);
					amicableNumbers.add(temp2);
					sum+=temp2+temp;
					System.out.println(temp2);
					System.out.println(temp);
					break;
				}
			}
		}
		System.out.println(sum);
	}
		
	private static int saveSumOfDivisors(int numbers){
		int sum=0;
		for(int i=1;i<=numbers/2;i++){
			if(numbers%i==0){
				sum+=i;
			}
		}
		return sum;
	}
}
