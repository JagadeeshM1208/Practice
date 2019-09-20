package com.example.Practice;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

interface TestFunctionl{
}

public class MethodReferenceWithFunIntr {
	static void showMsg(String msg,String m1){
		System.out.println("messgae is like" + msg+" "+m1);
	}
	static String showMsg(String msg){
		return msg;
	}
	
	static void showMsg1(String msg){
		System.out.println("consumer invoked3333333 "+msg);
	}
	
	public static void main(String[] args) {
		BiConsumer<String, String> msg = MethodReferenceWithFunIntr::showMsg;
		msg.accept("Jagadeesh", "Mannem");
		
		Function<String,String> msg1 = MethodReferenceWithFunIntr::showMsg;
		System.out.println(msg1.apply("Successfully Invoked!!!!!!"));
		
		Consumer<String> c = MethodReferenceWithFunIntr::showMsg1;
		c.accept(" Done");
	}
}
