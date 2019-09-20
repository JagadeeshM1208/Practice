package com.example.Practice;

import java.util.HashMap;
import java.util.Map;

abstract class A{
	public abstract void showMsg();
}

class B extends A{

	@Override
	public void showMsg() {
		System.out.println("Overriden Method !!!!!!!!!!!!!!!!!!!!");
	}
	
	public int getSum(int a, int b){
		return a+b;
	}
	
	public double getSum(double a, double b){
		return a+b;
	}
	
}

class exp{
	private String name;
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
}

interface vehicle{
	public void drive();
}

class Car implements vehicle{

	@Override
	public void drive() {
		System.out.println("Car is on Drive mode!!!!");
	}
	
}
class Bike implements vehicle{

	@Override
	public void drive() {
		System.out.println("bike is on Drive mode!!!!");
	}
	
}
public class OOpsExample {
	public static void main(String[] args) {
    
        //Execute the OOPS Concepts......................
		A a = new B();
		a.showMsg();
		B b= new B();
		System.out.println("Interger Sum---"+b.getSum(1, 1));
		System.out.println("Double Sum---"+b.getSum(1.1,1.2));
		exp e = new exp();
		e.setName("jagadeesh!!!!!!!!");
		System.out.println(e.getName());
		vehicle v = new Car();
		v.drive();
		vehicle v1 = new Bike();
		v1.drive();
		System.out.println(getdupilcateNumberCount("jagadeeeeeesh",'e'));
		int[] nums = {1,2,3,4,66,55,77,88,99};
		System.out.println("Second Largest===="+findSecondLargestNum(nums));
		System.out.println("The Given Number is Prime===="+isItPrime(21));
		System.out.println("Is it Perfect Square ===="+ isItPerfectSquere(23));
		System.out.println("Is It Leep Year=="+isItLeepYear(2020));
	}
	
	public static boolean isItLeepYear(int year){
		return (year%400==0) ||((year%100)!=0 && (year%4==0));
	}
	public static int findSecondLargestNum(int[] num){
		int largest=num[0],secondLarget=num[0];
		
		for(int i=0;i<num.length;i++){
			if(num[i]>largest){
				secondLarget=largest;
				largest=num[i];
			} else if(num[i]>secondLarget && num[i]!=largest){
				secondLarget=num[i];
			}
		}
		return secondLarget;
	}
	
	public static boolean isItPrime(int num){
		if(num==2 || num==3){
			return true;
		}
		if(num%2==0){
			return false;
		}
		int sq = (int)Math.sqrt(num)+1;
		for(int i=2;i<sq;i++){
			if(num%i==0){
				return false;
			}
		}
		return true;
	}

	public static Integer getdupilcateNumberCount(String name,char c){
		char[] ch = name.toCharArray();
		Map<Character,Integer> ci = new HashMap<>();
		for(int i=0;i<ch.length;i++){
			if(ci.get(ch[i])!=null){
				ci.put(ch[i],ci.get(ch[i])+1);
			} else{
				ci.put(ch[i],1);
			}
		}
		return ci.get(c);
	}
	
	public static boolean isItPerfectSquere(int num){
		double nums = Math.sqrt(num);
		if(nums-(Math.floor(nums))==0){
			return true;
		}
		return false;
	}
	
	
}

