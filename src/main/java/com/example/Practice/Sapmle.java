package com.example.Practice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sapmle {/*
	
	@Autowired
	private InterfaceOne inter;
	
	public static void main(String[] args) {
		Map<String,Object> interMap = new HashMap<>();
		interMap.put("Inter1", new InterClassCheck());
		
		InterfaceOne one = (InterfaceOne)interMap.get("Inter1");
		System.out.println(one.getMessages());
		String code="";
		List<String> l1= new ArrayList<>();
		l1.add("41");l1.add("42");l1.add("43");
		List<String> l = new ArrayList<>();
		l.add("06");l.add("71");l.add("42");
		List<String> removableList = l.stream().filter(o-> !l1.contains(o)).collect(Collectors.toList());
		l.removeAll(removableList);
		l.forEach(ob->System.out.println(ob));
		System.out.println(l.toString());
	}
*/
	 
	    public static void main(String[] args)  
	    { 
	        if((Math.sqrt(81)-(Math.floor(Math.sqrt(81)))==0)){
	        	System.out.println("Perfect Square!!!!!!!!!!!!!!!!");
	        }
	        System.out.println("Square Value== " +Math.sqrt(81));
	        System.out.println(getInte1(10));
	        System.out.println(getInte1(10,20,20));
	    }
	    
	    public static int getInte1(int... args){
	    	int val=0;
	    	for(int i:args){
	    		val=val+i;
	    	}
	    	
			return val;    	
	    }

}
