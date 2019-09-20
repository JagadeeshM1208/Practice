package com.example.Practice;

class Aa{
	Aa(){
		System.out.println("Default Constructor AA!!!!!!!!!!!!!!!!");
	}
	public void showMsg(String msg){
		System.out.println("Show Message like "+msg);
	}
}
class Bb extends Aa{
	public void showMsg(String msg){
		System.out.println("Show Message like BB "+msg);
	}
}

public class ABC {
	public static void main(String[] args) {
		Aa a = new Bb();
		a.showMsg("aaaaaaa");
	}
}


